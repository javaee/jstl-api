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

package org.apache.taglibs.standard.tag.common.xml;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * <p>Tag handler for &lt;expr&gt; in JSTL's XML library.</p>
 *
 * @author Shawn Bayern
 */

public abstract class ExprSupport extends TagSupport {

    //*********************************************************************
    // Internal state

    private String select;                       // tag attribute
    protected boolean escapeXml;		 // tag attribute

    //*********************************************************************
    // Construction and initialization

    /**
     * Constructs a new handler.  As with TagSupport, subclasses should
     * not provide other constructors and are expected to call the
     * superclass constructor.
     */
    public ExprSupport() {
        super();
        init();
    }

    // resets local state
    private void init() {
	select = null;
        escapeXml = true;
    }


    //*********************************************************************
    // Tag logic

    // applies XPath expression from 'select' and prints the result
    public int doStartTag() throws JspException {
        try {
	    XPathUtil xu = new XPathUtil(pageContext);
	    String result = xu.valueOf(XPathUtil.getContext(this), select);
	    org.apache.taglibs.standard.tag.common.core.OutSupport.out(
              pageContext, escapeXml, result);
	    return SKIP_BODY;
        } catch (java.io.IOException ex) {
	    throw new JspTagException(ex.toString(), ex);
        }
    }

    // Releases any resources we may have (or inherit)
    public void release() {
        super.release();
        init();
    }


    //*********************************************************************
    // Attribute accessors

    public void setSelect(String select) {
	this.select = select;
    }
}
