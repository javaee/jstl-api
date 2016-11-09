/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/common/tags/ThrowTag.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.common.tags;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspException;

/**
 * This tag simply throws a JspException when used
 */

public class ThrowTag extends TagSupport {

    /** Creates new ThrowTag */
    public ThrowTag() {
        super();
    }

/* 
 * public methods
 * ========================================================================
 */
    
    /**
     * The tag will throw a JspException when doEndTag() is called.
     * @throws JspException
     * @return int 
     */    
    public int doEndTag() throws JspException {
        throw new IllegalArgumentException();
    }
}
