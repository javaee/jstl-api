/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/common/filters/FormatFilter.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.common.filters;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import com.sun.ts.tests.jstl.common.wrappers.FormatResponseWrapper;
import com.sun.ts.tests.jstl.common.wrappers.FormatRequestWrapper;

/*
 * Simple Filter to wrap requests and responses for the fmt tests.
 */

public class FormatFilter implements Filter {
    
    /** Filter configuration
     */
    private FilterConfig _config = null;

    /** Creates new FormatFilter */
    public FormatFilter() {
    }

/* 
 * public methods
 * ========================================================================
 */
    
    /**
     * Called by the container to initialize this filter.
     *
     * @param config filter configuration.
     */
    public void init(FilterConfig config) {
        _config = config;
    }
    
    /**
     * When called by the container, the current request and response
     * are wrapped by an instance of FormatRequestWrapper and
     * FormatResponseWrapper respectively.  Doing this allows the 
     * "logging" of certain events that must take place when using
     * certain formatting actions.
     */
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        FormatResponseWrapper resWrapper = 
                    new FormatResponseWrapper((HttpServletResponse) response);
        FormatRequestWrapper reqWrapper = 
                    new FormatRequestWrapper((HttpServletRequest) request);
        chain.doFilter(reqWrapper, resWrapper);
    }
    
    /** Called by the container to destroy this instance.
     */
    public void destroy() {
        _config = null;
    }    
}
