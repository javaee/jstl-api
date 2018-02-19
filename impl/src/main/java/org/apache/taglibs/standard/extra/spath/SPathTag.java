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

package org.apache.taglibs.standard.extra.spath;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * <p>Tag handler that exposes SPath functionality.</p>
 *
 * @author Shawn Bayern
 */

public class SPathTag extends TagSupport {

    //*********************************************************************
    // Internal state

    private String select;                       // tag attribute
    private String var;				 // tag attribute

    //*********************************************************************
    // Construction and initialization

    /**
     * Constructs a new handler.  As with TagSupport, subclasses should
     * not provide other constructors and are expected to call the
     * superclass constructor.
     */
    public SPathTag() {
        super();
        init();
    }

    // resets local state
    private void init() {
	select = var = null;
    }


    //*********************************************************************
    // Tag logic

    // applies XPath expression from 'select' and exposes a filter as 'var'
    public int doStartTag() throws JspException {
      try {
	SPathFilter s = new SPathFilter(new SPathParser(select).expression());
	pageContext.setAttribute(var, s);
	return SKIP_BODY;
      } catch (ParseException ex) {
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

    public void setVar(String var) {
	this.var = var;
    }
}
