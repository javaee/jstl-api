/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: JstlDbFilter.java 53811 2007-09-10 18:01:23Z dougd $
 */

package com.sun.ts.tests.jstl.common.filters;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import com.sun.ts.tests.jstl.common.JstlTckConstants;
import com.sun.ts.tests.jstl.common.wrappers.TckDataSourceWrapper;
import org.apache.tools.ant.util.StringUtils;

/*
 * Simple Filter to wrap requests and responses for the sql tests.
 */

public class JstlDbFilter implements Filter, JstlTckConstants {
    private FilterConfig _config = null;
    private ServletContext _context;

    /** Debug flag
     */
    private boolean _debug = true;
    
    private void addDataSource(HttpServletRequest req) 
        throws IOException, ServletException {
        if(_context.getAttribute(JSTLDS) != null &&
            _context.getAttribute(LOGDS) != null) {
            return;
        }
        String url = req.getHeader(JSTL_DB_URL);
        url = escapeComma(url);
        String driver = req.getHeader(JSTL_DB_DRIVER);
        String user = req.getHeader(JSTL_DB_USER);
        String password = req.getHeader(JSTL_DB_PASSWORD);
        
        // Create standard TckDataSourceWrapper
        trace("Creating TckDataSourceWrapper...");
        TckDataSourceWrapper ds = new TckDataSourceWrapper();
        try {
            ds.setDriverClassName(driver);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (InstantiationException e) {
            throw new ServletException(e);
        } catch (IllegalAccessException e) {
            throw new ServletException(e);
        }
        ds.setJdbcURL(url);
        ds.setUserName(user);
        ds.setPassword(password);
        trace("TckDataSourceWrapper, jstlDS, created: " + ds);
        trace("TckDataSourceWrapper info: " + ds.getDSInfo());
        _context.setAttribute(JSTLDS, ds);
    
        // Create TckDataSourceWrapper that returns wrapped connections
        trace("Creating TckDataSourceWrapper that returns wrapped Connections...");
        TckDataSourceWrapper dsw = new TckDataSourceWrapper(_context);
        try {
            dsw.setDriverClassName(driver);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (InstantiationException e) {
            throw new ServletException(e);
        } catch (IllegalAccessException e) {
            throw new ServletException(e);
        }
        dsw.setJdbcURL(url);
        dsw.setUserName(user);
        dsw.setPassword(password);
        trace("TckDataSourceWrapper, logDS, created: " + dsw);
        trace("TckDataSourceWrapper info: " + dsw.getDSInfo());
        _context.setAttribute(LOGDS, dsw);
    }
    

    public JstlDbFilter() {
    }

    public void init(FilterConfig config) {
        _config = config;
        _context = _config.getServletContext();
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
        HttpServletRequest req = (HttpServletRequest) request;
        addDataSource(req);
        chain.doFilter(req, response);
    }
    
    public void destroy() {
        _config = null;
    }    

    /**
     * trace<br>
     * Dump output messages to the server log
     *
     * @param buf  The message to print.
     */
    private void trace(String buf) {
        if(_debug)
           System.out.println("[JstlDbFilter] " + buf); 
    }

    private String escapeComma(String url) {
        if(url == null) return url;
        int comma = url.indexOf(',');
        if(comma == -1) return url;
        String result = StringUtils.replace(url, ",", "\\,");
        return result;
    }
}
