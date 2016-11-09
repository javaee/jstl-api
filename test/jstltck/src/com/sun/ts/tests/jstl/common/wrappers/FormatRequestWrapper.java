/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/common/wrappers/FormatRequestWrapper.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.common.wrappers;

import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;


public class FormatRequestWrapper extends HttpServletRequestWrapper{

    /** Creates new FormatRequestWrapper */
    public FormatRequestWrapper(HttpServletRequest request) {
        super(request);
    }

/* 
 * public methods
 * ========================================================================
 */
    
    /**
     * This wrapper method will add an attribute to the passed request
     * when this method is called.
     */
    public void setCharacterEncoding(String enc) 
      throws UnsupportedEncodingException {
        super.setAttribute("charenc", enc.toLowerCase());
        super.setCharacterEncoding(enc);
    }

    
}
