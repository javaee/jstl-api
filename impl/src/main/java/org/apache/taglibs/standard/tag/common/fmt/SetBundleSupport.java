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

package org.apache.taglibs.standard.tag.common.fmt;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.jstl.core.Config;
import javax.servlet.jsp.jstl.fmt.LocalizationContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.taglibs.standard.tag.common.core.Util;

/**
 * Support for tag handlers for &lt;setBundle&gt;, the JSTL 1.0 tag that loads
 * a resource bundle and stores it in a scoped variable.
 *
 * @author Jan Luehe
 */

public abstract class SetBundleSupport extends TagSupport {

    
    //*********************************************************************
    // Protected state

    protected String basename;                  // 'basename' attribute


    //*********************************************************************
    // Private state

    private int scope;                          // 'scope' attribute
    private String var;                         // 'var' attribute


    //*********************************************************************
    // Constructor and initialization

    public SetBundleSupport() {
	super();
	init();
    }

    private void init() {
	basename = null;
	scope = PageContext.PAGE_SCOPE;
    }


    //*********************************************************************
    // Tag attributes known at translation time

    public void setVar(String var) {
        this.var = var;
    }

    public void setScope(String scope) {
	this.scope = Util.getScope(scope);
    }


    //*********************************************************************
    // Tag logic

    public int doEndTag() throws JspException {
	LocalizationContext locCtxt =
	    BundleSupport.getLocalizationContext(pageContext, basename);

	if (var != null) {
	    pageContext.setAttribute(var, locCtxt, scope);
	} else {
	    Config.set(pageContext, Config.FMT_LOCALIZATION_CONTEXT, locCtxt,
		       scope);
	}

	return EVAL_PAGE;
    }

    // Releases any resources we may have (or inherit)
    public void release() {
	init();
    }
}
