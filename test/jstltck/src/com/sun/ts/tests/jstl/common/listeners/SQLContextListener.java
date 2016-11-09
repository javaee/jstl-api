/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * @(#)SQLContextListener.java	1.3 04/06/02
 */

package com.sun.ts.tests.jstl.common.listeners;

import javax.sql.DataSource;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;
import java.util.Properties;
import java.util.Enumeration;
import java.io.IOException;
import com.sun.ts.tests.jstl.common.wrappers.TckDataSourceWrapper;
import com.sun.ts.tests.jstl.common.JstlTckConstants;

/**
 * SQLContextListner.<br>
 * This class is used to initialize resources required by the JSTL sql 
 * tags.<p>
 */

public final class SQLContextListener 
        implements ServletContextListener, JstlTckConstants {
    private ServletContext _context;
    private boolean _debug = true;
    
/* 
 * public methods
 * ========================================================================
 */
    
    /**
     * contextInitialized<br>
     * Obtain the required context initialization parameters and then
     * create an attribute for each one.<p>
     * Use the context parameters to create in instance of an object which
     * looks like a DataSource.  This will be used by all of the JSTL sql
     * tags.<p>
     *
     * @param event
     */
    public void contextInitialized(ServletContextEvent event) {
        _context = event.getServletContext();
        Integer jstl_tab1_rows = new Integer(
                                    _context.getInitParameter(JSTL_TAB1_ROWS));
        
        _context.setAttribute(JSTL_TAB1_ROWS, jstl_tab1_rows);

        Properties props = new Properties();
        _context.setAttribute(SQLPROPS, props);
        try {
            trace("Loading sql.properties from URI: " + PROPS_URI);
            props.load(_context.getResourceAsStream(PROPS_URI));
            if(_debug) {
               Enumeration e = props.propertyNames(); 
               while(e.hasMoreElements()) {
                  String key= (String)e.nextElement();
                  trace(key + "=" + props.getProperty(key));
               }
            }
        } catch (IOException io) {
            trace("Unexpected IOException loading " +
               "sql.properties from URI: " + PROPS_URI);
            trace("Exception received: " + io.toString());
        }
    }
    
    /**
     * contextDestroyed.<br>
     * Release the attributes that were created by this listener and JstlDbFilter
     *
     * @param event
     */
    public void contextDestroyed(ServletContextEvent event) {
        _context.removeAttribute(JSTLDS);
        trace("Removed jstlDS from context.");
        _context.removeAttribute(LOGDS);
        trace("Removed logDS from context.");
        _context.removeAttribute(SQLPROPS);
        trace("Removed sqlProps from context.");
        _context.removeAttribute(JSTL_TAB1_ROWS);
        trace("Removed JSTL_TAB1_ROWS from context.");
    }

    /**
     * trace<br>
     * Dump output messages to the server log
     *
     * @param buf  The message to print.
     */
    private void trace(String buf) {
        if(_debug)
           _context.log("[SQLContextListener] " + buf); 
    }
}
