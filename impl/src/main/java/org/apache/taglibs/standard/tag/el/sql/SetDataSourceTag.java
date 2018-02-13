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

package org.apache.taglibs.standard.tag.el.sql;

import javax.servlet.jsp.JspException;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;
import org.apache.taglibs.standard.tag.common.sql.SetDataSourceTagSupport;

/**
 * <p>Tag handler for &lt;SetDataSource&gt; in JSTL, used to create
 * a simple DataSource for prototyping.</p>
 * 
 */
public class SetDataSourceTag extends SetDataSourceTagSupport {

    private String dataSourceEL;
    private String driverClassNameEL;
    private String jdbcURLEL;
    private String userNameEL;
    private String passwordEL;

    //*********************************************************************
    // Accessor methods

    public void setDataSource(String dataSourceEL) {
	this.dataSourceEL = dataSourceEL;
	this.dataSourceSpecified = true;
    }

    public void setDriver(String driverClassNameEL) {
	this.driverClassNameEL = driverClassNameEL;
    }

    public void setUrl(String jdbcURLEL) {
	this.jdbcURLEL = jdbcURLEL;
    }

    public void setUser(String userNameEL) {
	this.userNameEL = userNameEL;
    }

    public void setPassword(String passwordEL) {
	this.passwordEL = passwordEL;
    }

    //*********************************************************************
    // Tag logic

    public int doStartTag() throws JspException {
        evaluateExpressions();

        return super.doStartTag();
    }


    //*********************************************************************
    // Private utility methods

    // Evaluates expressions as necessary
    private void evaluateExpressions() throws JspException {
        if (dataSourceEL != null) {
                dataSource = ExpressionEvaluatorManager.evaluate
                ("dataSource", dataSourceEL, Object.class, this, pageContext);
        }

        if (driverClassNameEL != null) {
                driverClassName = (String) ExpressionEvaluatorManager.evaluate
                ("driver", driverClassNameEL, String.class, this, pageContext);
        }

        if (jdbcURLEL != null) {
                jdbcURL = (String) ExpressionEvaluatorManager.evaluate
                ("url", jdbcURLEL, String.class, this, pageContext);
        }

        if (userNameEL != null) {
                userName = (String) ExpressionEvaluatorManager.evaluate
                ("user", userNameEL, String.class, this, pageContext);
        }

        if (passwordEL != null) {
                password = (String) ExpressionEvaluatorManager.evaluate
                ("password", passwordEL, String.class, this, pageContext);
        }
    }

}
