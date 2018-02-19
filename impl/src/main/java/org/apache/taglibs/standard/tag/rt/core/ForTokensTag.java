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

package org.apache.taglibs.standard.tag.rt.core;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.jstl.core.LoopTag;
import javax.servlet.jsp.tagext.IterationTag;

import org.apache.taglibs.standard.tag.common.core.ForTokensSupport;

/**
 * <p>A handler for &lt;forTokens&gt; that supports rtexprvalue-based
 * attributes.</p>
 *
 * @author Shawn Bayern
 */

public class ForTokensTag
    extends ForTokensSupport
    implements LoopTag, IterationTag
{

    //*********************************************************************
    // Accessor methods

    // for tag attribute
    public void setBegin(int begin) throws JspTagException {
        this.beginSpecified = true;
        this.begin = begin;
        validateBegin();
    }

    // for tag attribute
    public void setEnd(int end) throws JspTagException {
        this.endSpecified = true;
        this.end = end;
        validateEnd();
    }

    // for tag attribute
    public void setStep(int step) throws JspTagException {
        this.stepSpecified = true;
        this.step = step;
        validateStep();
    }

    // stores the 'items' String we're passed
    public void setItems(Object s) throws JspTagException {
        items = s;
	// use the empty string to indicate "no iteration"
        if (s == null)
	    items = "";
    }

    // stores the 'delims' String we're passed
    public void setDelims(String s) throws JspTagException {
        delims = s;
	// use the empty string to cause monolithic tokenization
        if (s == null)
	    delims = "";
    }

}
