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

package org.apache.taglibs.standard.tag.el.core;

import javax.servlet.jsp.JspException;

import org.apache.taglibs.standard.tag.common.core.NullAttributeException;
import org.apache.taglibs.standard.tag.common.core.SetSupport;

/**
 * <p>A handler for &lt;set&gt;, which redirects the browser to a
 * new URL.
 *
 * @author Shawn Bayern
 */

public class SetTag extends SetSupport {

    //*********************************************************************
    // 'Private' state (implementation details)

    private String value_;			// stores EL-based property
    private String target_;			// stores EL-based property
    private String property_;			// stores EL-based property


    //*********************************************************************
    // Constructor

    public SetTag() {
        super();
        init();
    }


    //*********************************************************************
    // Tag logic

    // evaluates expression and chains to parent
    public int doStartTag() throws JspException {

        // evaluate any expressions we were passed, once per invocation
        evaluateExpressions();

	// chain to the parent implementation
	return super.doStartTag();
    }


    // Releases any resources we may have (or inherit)
    public void release() {
        super.release();
        init();
    }


    //*********************************************************************
    // Accessor methods

    public void setValue(String value_) {
        this.value_ = value_;
	this.valueSpecified = true;
    }

    public void setTarget(String target_) {
        this.target_ = target_;
    }

    public void setProperty(String property_) {
        this.property_ = property_;
    }


    //*********************************************************************
    // Private (utility) methods

    // (re)initializes state (during release() or construction)
    private void init() {
        // null implies "no expression"
	value_ = target_ = property_ = null;
    }

    /* Evaluates expressions as necessary */
    private void evaluateExpressions() throws JspException {
        /* 
         * Note: we don't check for type mismatches here; we assume
         * the expression evaluator will return the expected type
         * (by virtue of knowledge we give it about what that type is).
         * A ClassCastException here is truly unexpected, so we let it
         * propagate up.
         */

	// 'value'
	try {
	    value = ExpressionUtil.evalNotNull(
	        "set", "value", value_, Object.class, this, pageContext);
	} catch (NullAttributeException ex) {
	    // explicitly let 'value' be null
	    value = null;
	}

	// 'target'
	target = ExpressionUtil.evalNotNull(
	    "set", "target", target_, Object.class, this, pageContext);

	// 'property'
	try {
	    property = (String) ExpressionUtil.evalNotNull(
	         "set", "property", property_, String.class, this, pageContext);
        } catch (NullAttributeException ex) {
            // explicitly let 'property' be null
            property = null;
        }
    }
}
