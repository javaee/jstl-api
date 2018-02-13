/*
 * Copyright (c) 1997-2018 Oracle and/or its affiliates. All rights reserved.
 * Copyright 2004 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.taglibs.standard.tag.common.sql;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * <p>Tag handler for &lt;Driver&gt; in JSTL, used to create
 * a simple DataSource for prototyping.</p>
 * 
 * @author Hans Bergsten
 */
public class DriverTag extends TagSupport {
    private static final String DRIVER_CLASS_NAME =
	"javax.servlet.jsp.jstl.sql.driver";
    private static final String JDBC_URL =
	"javax.servlet.jsp.jstl.sql.jdbcURL";
    private static final String USER_NAME =
	"javax.servlet.jsp.jstl.sql.userName";
    private static final String PASSWORD =
	"javax.servlet.jsp.jstl.sql.password";

    private String driverClassName;
    private String jdbcURL;
    private int scope = PageContext.PAGE_SCOPE;
    private String userName;
    private String var;

    //*********************************************************************
    // Accessor methods

    public void setDriver(String driverClassName) {
	this.driverClassName = driverClassName;
    }

    public void setJdbcURL(String jdbcURL) {
	this.jdbcURL = jdbcURL;
    }

    /**
     * Setter method for the scope of the variable to hold the
     * result.
     *
     */
    public void setScope(String scopeName) {
        if ("page".equals(scopeName)) {
            scope = PageContext.PAGE_SCOPE;
        }
        else if ("request".equals(scopeName)) {
            scope = PageContext.REQUEST_SCOPE;
        }
        else if ("session".equals(scopeName)) {
            scope = PageContext.SESSION_SCOPE;
        }
        else if ("application".equals(scopeName)) {
            scope = PageContext.APPLICATION_SCOPE;
        }
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public void setVar(String var) {
	this.var = var;
    }

    //*********************************************************************
    // Tag logic

    public int doStartTag() throws JspException {
	DataSourceWrapper ds = new DataSourceWrapper();
	try {
	ds.setDriverClassName(getDriverClassName());
	}
	catch (Exception e) {
	    throw new JspTagException("Invalid driver class name: " +
		e.toString(), e);
	}
	ds.setJdbcURL(getJdbcURL());
	ds.setUserName(getUserName());
	ds.setPassword(getPassword());
	pageContext.setAttribute(var, ds, scope);
	return SKIP_BODY;
    }


    //*********************************************************************
    // Private utility methods

    private String getDriverClassName() {
	if (driverClassName != null) {
	    return driverClassName;
	}
	ServletContext application = pageContext.getServletContext();
	return application.getInitParameter(DRIVER_CLASS_NAME);
    }

    private String getJdbcURL() {
	if (jdbcURL != null) {
	    return jdbcURL;
	}
	ServletContext application = pageContext.getServletContext();
	return application.getInitParameter(JDBC_URL);
    }

    private String getUserName() {
	if (userName != null) {
	    return userName;
	}
	ServletContext application = pageContext.getServletContext();
	return application.getInitParameter(USER_NAME);
    }

    private String getPassword() {
	ServletContext application = pageContext.getServletContext();
	return application.getInitParameter(PASSWORD);
    }
}
