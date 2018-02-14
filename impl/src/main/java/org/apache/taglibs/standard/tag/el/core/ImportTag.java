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

import org.apache.taglibs.standard.tag.common.core.ImportSupport;
import org.apache.taglibs.standard.tag.common.core.NullAttributeException;

/**
 * <p>A handler for &lt;import&gt; that accepts attributes as Strings
 * and evaluates them as expressions at runtime.</p>
 *
 * @author Shawn Bayern
 */

public class ImportTag extends ImportSupport {

    //*********************************************************************
    // 'Private' state (implementation details)

    private String context_;                    // stores EL-based property
    private String charEncoding_;		// stores EL-based property
    private String url_;			// stores EL-based property


    //*********************************************************************
    // Constructor

    /**
     * Constructs a new ImportTag.  As with TagSupport, subclasses
     * should not provide other constructors and are expected to call
     * the superclass constructor
     */
    public ImportTag() {
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

    // for EL-based attribute
    public void setUrl(String url_) {
        this.url_ = url_;
    }

    public void setContext(String context_) {
        this.context_ = context_;
    }

    public void setCharEncoding(String charEncoding_) {
        this.charEncoding_ = charEncoding_;
    }

    //*********************************************************************
    // Private (utility) methods

    // (re)initializes state (during release() or construction)
    private void init() {
        // null implies "no expression"
	url_ = context_ = charEncoding_ = null;
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

	url = (String) ExpressionUtil.evalNotNull(
	    "import", "url", url_, String.class, this, pageContext);
	if (url == null || url.equals(""))
	    throw new NullAttributeException("import", "url");

	context = (String) ExpressionUtil.evalNotNull(
	    "import", "context", context_, String.class, this, pageContext);
	charEncoding = (String) ExpressionUtil.evalNotNull(
	    "import", "charEncoding", charEncoding_, String.class, this,
	    pageContext);
    }
}
