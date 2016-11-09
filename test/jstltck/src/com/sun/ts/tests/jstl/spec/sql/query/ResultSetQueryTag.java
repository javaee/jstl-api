/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: ResultSetQueryTag.java 53812 2007-09-10 18:01:51Z dougd $ 
 */

/*
 * Copyright 1999-2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.sun.ts.tests.jstl.spec.sql.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TryCatchFinally;
import javax.sql.DataSource;


/**
 * <p>Tag handler similar to &lt;Query&gt; in JSTL but 
 * uses javax.servlet.jsp.jstl.sql.ResultSupport.
 * To simplify testing, the scope of the scoped variable is set to
 * page scope. It does not accept sql:param as sub-elements.  It
 * does not participate in a transaction. dataSource attribute must 
 * be set explicitly.  The presence of maxRows attribute determine
 * which ResultSupport method will be invoked.
 * 
 */

public class ResultSetQueryTag extends BodyTagSupport 
    implements TryCatchFinally {

    private String var;
    private int scope;

    /*
     * The following properties take expression values, so the
     * setter methods are implemented by the expression type
     * specific subclasses.
     */
    protected Object rawDataSource;
    protected String sql;
    protected int maxRows;
    protected boolean maxRowsSpecified;
    protected int startRow;

    /*
     * Instance variables that are not for attributes
     */
    private Connection conn;


    //*********************************************************************
    // Constructor and initialization

    public ResultSetQueryTag () {
        super();
        init();
    }

    private void init() {
        startRow = 0;
        maxRows = -1;
        maxRowsSpecified = false;
	conn = null;
	rawDataSource = null;
	sql = null;
	var = null;
        scope = PageContext.PAGE_SCOPE;
    }


    //*********************************************************************
    // Accessor methods

    /**
     * Setter method for the name of the variable to hold the
     * result.
     */
    public void setVar(String var) {
	this.var = var;
    }
    
    public void setDataSource(Object dataSource) {
	this.rawDataSource = dataSource;
    }

    /**
     * The index of the first row returned can be
     * specified using startRow.
     */
    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    /**
     * Query result can be limited by specifying
     * the maximum number of rows returned.
     */
    public void setMaxRows(int maxRows) {
        this.maxRows = maxRows;
	this.maxRowsSpecified = true;
    }

    /**
     * Setter method for the SQL statement to use for the
     * query. The statement may contain parameter markers
     * (question marks, ?). If so, the parameter values must
     * be set using nested value elements.
     */
    public void setSql(String sql) {
	this.sql = sql;
    }

    //*********************************************************************
    // Tag logic

    /**
     * Prepares for execution by setting the initial state, such as
     * getting the <code>Connection</code>
     */
    public int doStartTag() throws JspException {
	try {
	    conn = getConnection();
	} catch (SQLException e) {
	    throw new JspException(sql + ": " + e.getMessage(), e);
	}

	return EVAL_BODY_BUFFERED;
    }

    /**
     * <p>Execute the SQL statement, set either through the <code>sql</code>
     * attribute or as the body, and save the result as a variable
     * named by the <code>var</code> attribute in the scope specified
     * by the <code>scope</code> attribute, as an object that implements
     * the Result interface.
     *
     * <p>The connection used to execute the statement comes either
     * from the <code>DataSource</code> specified by the
     * <code>dataSource</code> attribute, provided by a parent action
     * element, or is retrieved from a JSP scope  attribute
     * named <code>javax.servlet.jstl.sql.dataSource</code>.
     */
    public int doEndTag() throws JspException {
	/*
	 * Use the SQL statement specified by the sql attribute, if any,
	 * otherwise use the body as the statement.
	 */
	String sqlStatement = null;
	if (sql != null) {
	    sqlStatement = sql;
	}
	else if (bodyContent != null) {
	    sqlStatement = bodyContent.getString();
	}
	if (sqlStatement == null || sqlStatement.trim().length() == 0) {
	    throw new JspTagException("No sql statement from attribute or body content.");
	}
        /*
         * We shouldn't have a negative startRow or illegal maxrows
         */
        if ((startRow < 0) || (maxRows < -1)) {
            throw new JspException("startRow less than 0 or maxRow less than -1");
        }

	Result result = null;
	/* 
	 * Note! We must not use the setMaxRows() method on the
	 * the statement to limit the number of rows, since the
	 * Result factory must be able to figure out the correct
	 * value for isLimitedByMaxRows(); there's no way to check
	 * if it was from the ResultSet.
          */
	try {
	    PreparedStatement ps = conn.prepareStatement(sqlStatement);
	    ResultSet rs = ps.executeQuery();
	    //result = new ResultImpl(rs, startRow, maxRows);
            if(maxRowsSpecified) {
    	        result = ResultSupport.toResult(rs, maxRows);
            } else {
                result = ResultSupport.toResult(rs);
            }
            ps.close();
	}
	catch (Throwable e) {
	    throw new JspException(sqlStatement + ": " + e.getMessage(), e);
	}
	pageContext.setAttribute(var, result, scope);
	return EVAL_PAGE;
    }

    /**
     * Just rethrows the Throwable.
     */
    public void doCatch(Throwable t) throws Throwable {
	throw t;
    }

    /**
     * Close the <code>Connection</code>, unless this action is used
     * as part of a transaction.
     */
    public void doFinally() {
	if (conn != null) {
	    try {
		conn.close();
	    } catch (SQLException e) {} // Not much we can do
	}
	conn = null;
    }


    //*********************************************************************
    // Private utility methods

    private Connection getConnection() throws JspException, SQLException {
	Connection conn = null;
        if (rawDataSource == null) {
            throw new JspException("dataSource attribute is null.");
        }
        DataSource dataSource = null;
        if(rawDataSource instanceof DataSource) {
            dataSource = (DataSource) rawDataSource;
        } else {
            throw new JspException("dataSource attribute must be of type javax.sql.DataSource.");
        }
        try {
            conn = dataSource.getConnection();
        } catch (Exception ex) {
            throw new JspException(ex);
        }
        return conn;
    }
}
