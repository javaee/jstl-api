/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/common/tags/CheckRuntime.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.common.tags;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspException;

/** Simple tag to check the J2SE runtime.
 */

public class CheckRuntime extends TagSupport {
    
    /** Scoped variable in which to export the
     *  result of the runtime check.
     */
    private String _var = null;

    /** Creates new CheckRuntime */
    public CheckRuntime() {
        super();
    }

/* 
 * public methods
 * ========================================================================
 */
    
    /** Sets the name of the scoped attribute in which to export
     *  the result of the runtime check
     */
    public void setVar(String var) {
        _var = var;
    }
    
    /**
     * Actions may behave differently based on the available runtime version.
     * This action will check to see if we're a 1.4 runtime or an earlier 
     * version.
     */
    public int doEndTag() throws JspException {
        boolean is14 = false;
        try {
            Class c = Class.forName("java.util.Currency");
            is14 = true;
        } catch (Exception e) {
            ;
        }
        pageContext.setAttribute(_var, new Boolean(is14));
        return EVAL_PAGE;
    }
    
    /** Releases tag state.
     */
    public void release() {
        _var = null;
    }
}
