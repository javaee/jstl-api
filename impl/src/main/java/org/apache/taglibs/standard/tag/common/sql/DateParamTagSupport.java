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

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.jstl.sql.SQLExecutionTag;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.taglibs.standard.resources.Resources;


/**
 * <p>Tag handler for &lt;Param&gt; in JSTL, used to set
 * parameter values for a SQL statement.</p>
 * 
 * @author Justyna Horwat
 */

public abstract class DateParamTagSupport extends TagSupport {

    //*********************************************************************
    // Private constants
    
    private static final String TIMESTAMP_TYPE = "timestamp";
    private static final String TIME_TYPE = "time";
    private static final String DATE_TYPE = "date";
	

    //*********************************************************************
    // Protected state

    protected String type;
    protected java.util.Date value;


    //*********************************************************************
    // Constructor

    public DateParamTagSupport() {
        super();
        init();
    }

    private void init() {
        value = null;
        type = null;
    }


    //*********************************************************************
    // Tag logic

    public int doEndTag() throws JspException {
	SQLExecutionTag parent = (SQLExecutionTag) 
	    findAncestorWithClass(this, SQLExecutionTag.class);
	if (parent == null) {
	    throw new JspTagException(
                Resources.getMessage("SQL_PARAM_OUTSIDE_PARENT"));
	}

        if (value != null) {
            convertValue();
        }

	parent.addSQLParameter(value);
	return EVAL_PAGE;
    }


    //*********************************************************************
    // Private utility methods

    private void convertValue() throws JspException {

	if ((type == null) || (type.equalsIgnoreCase(TIMESTAMP_TYPE))) {
	    if (!(value instanceof java.sql.Timestamp)) {
		value = new java.sql.Timestamp(value.getTime());
	    }
	} else if (type.equalsIgnoreCase(TIME_TYPE)) {
	    if (!(value instanceof java.sql.Time)) {
		value = new java.sql.Time(value.getTime());
	    }
	} else if (type.equalsIgnoreCase(DATE_TYPE)) {
	    if (!(value instanceof java.sql.Date)) {
		value = new java.sql.Date(value.getTime());
	    }
	} else {
	    throw new JspException(
                Resources.getMessage("SQL_DATE_PARAM_INVALID_TYPE", type));
	}
    }
}
