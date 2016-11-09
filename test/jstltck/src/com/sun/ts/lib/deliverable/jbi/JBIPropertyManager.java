/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * $Id: JBIPropertyManager.java 51076 2006-03-15 15:23:06Z lschwenk $
 */


package com.sun.ts.lib.deliverable.jbi;

import com.sun.ts.lib.deliverable.tck.TCKPropertyManager;
import com.sun.ts.lib.deliverable.PropertyNotSetException;
import com.sun.javatest.TestEnvironment;
import java.util.Properties;

/**
 * This class serves as a well known place for harness, util, and porting
 * classes to retrieve property values.
 *
 */
public class JBIPropertyManager extends TCKPropertyManager {
    private static JBIPropertyManager jteMgr = new JBIPropertyManager();

    /**
     * This method returns
     * the singleton instance of TCKPropertyManager which provides access
     * to all ts.jte properties.  This is only called once by the test harness.
     *
     * @param	env - TestEnvironment object from JavaTest
     * @return	JBIPropertyManager - singleton property manager object
     */
    public final static JBIPropertyManager getJBIPropertyManager (TestEnvironment env) throws Exception {
        jteMgr.setTestEnvironment(env);
        return  jteMgr;
    }

    /**
     * This method returns
     * the singleton instance of JBIPropertyManager which provides access
     * to all ts.jte properties.  This is only called by the init()
     * method in ManualDeployment.java
     *
     * @param	p - Properties object from JavaTest
     * @return	JBIPropertyManager - singleton property manager object
     */
    public final static JBIPropertyManager getJBIPropertyManager (Properties p) 
	                    throws Exception {
        jteMgr.setJteProperties(p);
        return  jteMgr;
    }

    public final static JBIPropertyManager getJBIPropertyManager () throws Exception {
        return  jteMgr;
    }

    /**
     * This method is called by the test harness to retrieve all properties
     * needed by a particular test.
     *
     * @param	sPropKeys - Properties to retrieve
     * @return	Properties - property/value pairs
     */
    public Properties getTestSpecificProperties (String[] sPropKeys) throws PropertyNotSetException {
        Properties pTestProps = super.getTestSpecificProperties(sPropKeys);
	
	    //Add all common props that all JBI tests will need access to
        pTestProps.put("cts_home", getProperty("TS_HOME", null));
        pTestProps.put("ts.home", getProperty("ts.home", null));
        pTestProps.put("jbi.rmi.host", getProperty("jbi.rmi.host", "localhost"));
        pTestProps.put("jbi.rmi.port", getProperty("jbi.rmi.port", "1099"));

        //pTestProps.put("porting.ts.url.class.1", getProperty("porting.ts.url.class.1"));
        
        return  pTestProps;
    }
}



