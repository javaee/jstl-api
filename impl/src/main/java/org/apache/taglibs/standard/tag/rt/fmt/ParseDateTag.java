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

import java.util.Locale;

import javax.servlet.jsp.JspTagException;

import org.apache.taglibs.standard.tag.common.fmt.ParseDateSupport;
import org.apache.taglibs.standard.tag.common.fmt.SetLocaleSupport;

/**
 * <p>A handler for &lt;parseDate&gt; that supports rtexprvalue-based
 * attributes.</p>
 *
 * @author Jan Luehe
 */

public class ParseDateTag extends ParseDateSupport {

    //*********************************************************************
    // Accessor methods

    // 'value' attribute
    public void setValue(String value) throws JspTagException {
        this.value = value;
	this.valueSpecified = true;
    }

    // 'type' attribute
    public void setType(String type) throws JspTagException {
        this.type = type;
    }

    // 'dateStyle' attribute
    public void setDateStyle(String dateStyle) throws JspTagException {
        this.dateStyle = dateStyle;
    }

    // 'timeStyle' attribute
    public void setTimeStyle(String timeStyle) throws JspTagException {
        this.timeStyle = timeStyle;
    }

    // 'pattern' attribute
    public void setPattern(String pattern) throws JspTagException {
        this.pattern = pattern;
    }

    // 'timeZone' attribute
    public void setTimeZone(Object timeZone) throws JspTagException {
        this.timeZone = timeZone;
    }

    // 'parseLocale' attribute
    public void setParseLocale(Object loc) throws JspTagException {
	if (loc != null) {
	    if (loc instanceof Locale) {
		this.parseLocale = (Locale) loc;
	    } else {
		if (!"".equals((String) loc)) {
		    this.parseLocale = SetLocaleSupport.parseLocale((String)
								    loc);
		}
	    }
	}
    }
}
