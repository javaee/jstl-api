/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/common/tags/DisplayTypeTag.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.common.tags;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspException;
import java.io.IOException;

public class DisplayTypeTag extends TagSupport {
    
    /** Scoped variable name
     */
    private String _varName = null;

    /** Creates new DisplayTypeTag */
    public DisplayTypeTag() {
        super();
    }

/* 
 * public methods
 * ========================================================================
 */
    
    /** 
     * Sets the name of the scoped variable that type information
     * should be displayed.
     *
     * @param varName scoped variable name
     */
    public void setVarName(String varName) {
        _varName = varName;
    }
    
    /**
     * When called, this will get the attribute from the pageContext,
     * get the name of the implementing class of the object, and write
     * the result to the current JspWriter.
     *
     * @return EVAL_PAGE
     */
    public int doEndTag() throws JspException {
        Object o = pageContext.findAttribute(_varName);
        String type = null;
        if (o != null) {
            type = o.getClass().getName();
        } else {
            type = "<strong>Error:</strong> Attribute, " + 
                   _varName + ", not found in any scope<br>";
        }
        try {
            pageContext.getOut().print("<strong>" + _varName + "</strong> is " +
                                       "of type:<strong>" + type + "</strong>");
        } catch (IOException ioe) {
            throw new JspException(ioe.toString());
        }
        return EVAL_PAGE;
    }
    
    public void release() {
        _varName = null;
    }
}
