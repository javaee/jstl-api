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

package org.apache.taglibs.standard.tag.rt.fmt;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.jstl.fmt.LocalizationContext;

import org.apache.taglibs.standard.tag.common.fmt.MessageSupport;

/**
 * <p>A handler for &lt;message&gt; that supports rtexprvalue-based
 * attributes.</p>
 *
 * @author Jan Luehe
 */

public class MessageTag extends MessageSupport {

    //*********************************************************************
    // Accessor methods

    // for tag attribute
    public void setKey(String key) throws JspTagException {
        this.keyAttrValue = key;
	this.keySpecified = true;
    }

    // for tag attribute
    public void setBundle(LocalizationContext locCtxt) throws JspTagException {
        this.bundleAttrValue = locCtxt;
        this.bundleSpecified = true;
    }
}
