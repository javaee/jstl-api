/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/common/wrappers/FormatResponseWrapper.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.common.wrappers;

import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/*
 * This is a simple HttpResposneWrapper to "log" calls
 * to setLocale() made by specific I18N actions.
 */

public class FormatResponseWrapper extends HttpServletResponseWrapper{

    /** Creates new FormatResponseWrapper */
    public FormatResponseWrapper(HttpServletResponse response) {
        super(response);
    }

/* 
 * public methods
 * ========================================================================
 */
    
    /*
     * Sets the locale of the response. 
     *
     * @param locale the locale of the response
     */
    public void setLocale(Locale locale) {
        super.setHeader("setlocale", locale.toString());
        super.setLocale(locale);
    }  
    
    /*
     * Returns the name of the charset used for the MIME body sent in 
     * this reponse
     *
     * @return a String specifying the name of the charset, for example, 
     *         ISO-8859-1
     */
    public String getCharacterEncoding() {
        super.setHeader("charencoding", "called");
        return super.getCharacterEncoding();
    }
}
