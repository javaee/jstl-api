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
import org.apache.taglibs.standard.tag.common.sql.TransactionTagSupport;

/**
 * Subclass for the JSTL library with EL support.
 *
 * @author Hans Bergsten
 * @author Justyna Horwat
 */
public class TransactionTag extends TransactionTagSupport {
    
    private String dataSourceEL;
    private String isolationEL;

    public void setDataSource(String dataSourceEL) {
	this.dataSourceEL = dataSourceEL;
	this.dataSourceSpecified = true;
    }

    public void setIsolation(String isolationEL) {
	this.isolationEL = isolationEL;
    }

    public int doStartTag() throws JspException {
	if (dataSourceEL != null) {
	    rawDataSource = (Object) 
		ExpressionEvaluatorManager.evaluate("dataSource", 
		    dataSourceEL, Object.class, this, pageContext);
	}

	if (isolationEL != null) {
	    isolationEL = (String) 
		ExpressionEvaluatorManager.evaluate("isolation", 
		    isolationEL, String.class, this, pageContext);
            super.setIsolation(isolationEL);
	}

	return super.doStartTag();
    }
}
