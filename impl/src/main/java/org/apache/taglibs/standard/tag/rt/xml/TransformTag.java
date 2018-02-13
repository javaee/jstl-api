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

package org.apache.taglibs.standard.tag.rt.xml;

import javax.servlet.jsp.JspTagException;
import javax.xml.transform.Result;

import org.apache.taglibs.standard.tag.common.xml.TransformSupport;

/**
 * <p>A handler for &lt;transform&gt; that supports rtexprvalue-based
 * attributes.</p>
 *
 * @author Shawn Bayern
 */

public class TransformTag extends TransformSupport {

    //*********************************************************************
    // Accessor methods

    // Deprecated as of JSTL 1.1
    // for tag attribute
    public void setXml(Object xml) throws JspTagException {
        this.xml = xml;
    }

    // 'doc' replaces 'xml' as of JSTL 1.1
    public void setDoc(Object xml) throws JspTagException {
        this.xml = xml;
    }

    // Deprecated as of JSTL 1.1
    // for tag attribute
    public void setXmlSystemId(String xmlSystemId) throws JspTagException {
        this.xmlSystemId = xmlSystemId;
    }

    // 'docSystemId' replaces 'xmlSystemId' as of JSTL 1.1
    public void setDocSystemId(String xmlSystemId) throws JspTagException {
        this.xmlSystemId = xmlSystemId;
    }

    // for tag attribute
    public void setXslt(Object xslt) throws JspTagException {
        this.xslt = xslt;
    }

    // for tag attribute
    public void setXsltSystemId(String xsltSystemId) throws JspTagException {
        this.xsltSystemId = xsltSystemId;
    }

    // for tag attribute
    public void setResult(Result result) throws JspTagException {
        this.result = result;
    }

}
