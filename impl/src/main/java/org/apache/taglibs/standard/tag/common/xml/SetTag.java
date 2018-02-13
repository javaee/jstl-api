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

package org.apache.taglibs.standard.tag.common.xml;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.taglibs.standard.tag.common.core.Util;

/**
 * <p>Tag handler for &lt;set&gt; in JSTL's XML library.</p>
 *
 * @author Shawn Bayern
 */
public class SetTag extends TagSupport {

    //*********************************************************************
    // Internal state

    private String select;                    // tag attribute
    private String var;                       // tag attribute
    private int scope;			      // processed tag attribute

    //*********************************************************************
    // Construction and initialization

    /**
     * Constructs a new handler.  As with TagSupport, subclasses should
     * not provide other constructors and are expected to call the
     * superclass constructor.
     */
    public SetTag() {
        super();
        init();
    }

    // resets local state
    private void init() {
	var = null;
	select = null;
        scope = PageContext.PAGE_SCOPE;
    }


    //*********************************************************************
    // Tag logic

    // applies XPath expression from 'select' and stores the result in 'var'
    public int doStartTag() throws JspException {
        // process the query
        XPathUtil xu = new XPathUtil(pageContext);
        List result =
        xu.selectNodes(XPathUtil.getContext(this), select);
        Object ret = result;
        
        // unwrap primitive types if that's what we received
        if (result.size() == 1) {
            Object o = result.get(0);
            if (o instanceof String || o instanceof Boolean
            || o instanceof Number)
                ret = o;
        }
        
        // expose the final result
        pageContext.setAttribute(var, ret, scope);
        return SKIP_BODY;
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

    public void setScope(String scope) {
	this.scope = Util.getScope(scope);
    }
}
