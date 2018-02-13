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

package org.apache.taglibs.standard.tag.common.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.taglibs.standard.resources.Resources;

/**
 * <p>Support for tag handlers for &lt;url&gt;, the URL creation
 * and rewriting tag in JSTL 1.0.</p>
 *
 * @author Shawn Bayern
 */

public abstract class UrlSupport extends BodyTagSupport
    implements ParamParent {

    //*********************************************************************
    // Protected state

    protected String value;                      // 'value' attribute
    protected String context;			 // 'context' attribute

    //*********************************************************************
    // Private state

    private String var;                          // 'var' attribute
    private int scope;				 // processed 'scope' attr
    private ParamSupport.ParamManager params;	 // added parameters

    //*********************************************************************
    // Constructor and initialization

    public UrlSupport() {
	super();
	init();
    }

    private void init() {
	value = var = null;
	params = null;
	context = null;
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
    // Collaboration with subtags

    // inherit Javadoc
    public void addParameter(String name, String value) {
	params.addParameter(name, value);
    }


    //*********************************************************************
    // Tag logic

    // resets any parameters that might be sent
    public int doStartTag() throws JspException {
	params = new ParamSupport.ParamManager();
	return EVAL_BODY_BUFFERED;
    }


    // gets the right value, encodes it, and prints or stores it
    public int doEndTag() throws JspException {
	String result;				// the eventual result

	// add (already encoded) parameters
	String baseUrl = resolveUrl(value, context, pageContext);
	result = params.aggregateParams(baseUrl);

	// if the URL is relative, rewrite it
	if (!ImportSupport.isAbsoluteUrl(result)) {
	    HttpServletResponse response =
                ((HttpServletResponse) pageContext.getResponse());
            result = response.encodeURL(result);
	}

	// store or print the output
	if (var != null)
	    pageContext.setAttribute(var, result, scope);
	else {
	    try {
	        pageContext.getOut().print(result);
	    } catch (java.io.IOException ex) {
		throw new JspTagException(ex.toString(), ex);
	    }
	}

	return EVAL_PAGE;
    }

    // Releases any resources we may have (or inherit)
    public void release() {
	init();
    }

    //*********************************************************************
    // Utility methods

    public static String resolveUrl(
            String url, String context, PageContext pageContext)
	    throws JspException {
	// don't touch absolute URLs
	if (ImportSupport.isAbsoluteUrl(url))
	    return url;

	// normalize relative URLs against a context root
	HttpServletRequest request =
	    (HttpServletRequest) pageContext.getRequest();
	if (context == null) {
	    if (url.startsWith("/"))
		return (request.getContextPath() + url);
	    else
		return url;
	} else {
            if (!context.startsWith("/") || !url.startsWith("/")) {
                throw new JspTagException(
                    Resources.getMessage("IMPORT_BAD_RELATIVE"));
            }
            if (context.equals("/")) {
                // Don't produce string starting with '//', many
                // browsers interpret this as host name, not as
                // path on same host.
                return url;
            } else {
                return (context + url);
            }
        }
    }

}
