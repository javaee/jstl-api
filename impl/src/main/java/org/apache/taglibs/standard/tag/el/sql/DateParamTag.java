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

import java.util.Date;

import javax.servlet.jsp.JspException;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;
import org.apache.taglibs.standard.tag.common.sql.DateParamTagSupport;

/**
 * Subclass for the JSTL library with EL support.
 *
 * @author Justyna Horwat
 */
public class DateParamTag extends DateParamTagSupport {
    
    private String valueEL;
    private String typeEL;

    public void setValue(String valueEL) {
	this.valueEL = valueEL;
    }

    public void setType(String typeEL) {
	this.typeEL = typeEL;
    }

    public int doStartTag() throws JspException {
        evaluateExpressions();
	return super.doStartTag();
    }

    //*********************************************************************
    // Private utility methods

    // Evaluates expressions as necessary
    private void evaluateExpressions() throws JspException {
	if (valueEL != null) {
	    value = (Date) ExpressionEvaluatorManager.evaluate(
                "value", valueEL, Date.class, this, pageContext);
	}

	if (typeEL != null) {
	    type = (String) ExpressionEvaluatorManager.evaluate(
                "type", typeEL, String.class, this, pageContext);
        }
    }

}
