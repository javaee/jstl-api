/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2018 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://oss.oracle.com/licenses/CDDL+GPL-1.1
 * or LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package org.apache.taglibs.standard.tag.common.fmt;

import java.io.UnsupportedEncodingException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Support for tag handlers for &lt;requestEncoding&gt;, the tag for setting
 * the request character encoding in JSTL 1.0.
 *
 * @author Jan Luehe
 * @author Pierre Delisle
 */

public abstract class RequestEncodingSupport extends TagSupport {

    //*********************************************************************
    // Package-scoped constants

    static final String REQUEST_CHAR_SET =
	"javax.servlet.jsp.jstl.fmt.request.charset";


    //*********************************************************************
    // Private constants

    private static final String DEFAULT_ENCODING = "ISO-8859-1";


    //*********************************************************************
    // Tag attributes

    protected String value;             // 'value' attribute
    

    //*********************************************************************
    // Derived information
    
    protected String charEncoding;   // derived from 'value' attribute  
    

    //*********************************************************************
    // Constructor and initialization

    public RequestEncodingSupport() {
	super();
	init();
    }

    private void init() {
	value = null;
    }


    //*********************************************************************
    // Tag logic

    public int doEndTag() throws JspException {
        charEncoding = value;
	if ((charEncoding == null)
	        && (pageContext.getRequest().getCharacterEncoding() == null)) { 
            // Use charset from session-scoped attribute
	    charEncoding = (String)
		pageContext.getAttribute(REQUEST_CHAR_SET,
					 PageContext.SESSION_SCOPE);
	    if (charEncoding == null) {
		// Use default encoding
		charEncoding = DEFAULT_ENCODING;
	    }
	}

	/*
	 * If char encoding was already set in the request, we don't need to 
	 * set it again.
	 */
	if (charEncoding != null) {
	    try {
		pageContext.getRequest().setCharacterEncoding(charEncoding);
	    } catch (UnsupportedEncodingException uee) {
		throw new JspTagException(uee.toString(), uee);
	    }
	}

	return EVAL_PAGE;
    }

    // Releases any resources we may have (or inherit)
    public void release() {
	init();
    }
}
