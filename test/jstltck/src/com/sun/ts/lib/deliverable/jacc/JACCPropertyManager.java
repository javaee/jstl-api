/*
 * Copyright 2008 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */


package com.sun.ts.lib.deliverable.jacc;

import com.sun.ts.lib.deliverable.*;
import com.sun.javatest.TestEnvironment;
import java.util.Properties;

public class JACCPropertyManager extends AbstractPropertyManager {
    
    private static JACCPropertyManager jteMgr = new JACCPropertyManager();
    
    /**
     * This method returns
     * the singleton instance of JACCPropertyManager which provides access
     * to all ts.jte properties.  This is only called once by the test harness.
     *
     * @param	env - TestEnvironment object from JavaTest
     * @return	JACCPropertyManager - singleton property manager object
     */
    
    public final static JACCPropertyManager getJACCPropertyManager(TestEnvironment env) throws Exception {
        jteMgr.setTestEnvironment(env);
        return  jteMgr;
    }
    
    /**
     * This method returns
     * the singleton instance of JACCPropertyManager which provides access
     * to all ts.jte properties.  This is only called by the init()
     * method in ManualDeployment.java
     *
     * @param	p - Properties object from JavaTest
     * @return	JACCPropertyManager - singleton property manager object
     */
    public final static JACCPropertyManager getJACCPropertyManager(Properties p) throws Exception {
        jteMgr.setJteProperties(p);
        return  jteMgr;
    }
    
    public final static JACCPropertyManager getJACCPropertyManager() throws Exception {
        return  jteMgr;
    }
    
    /**
     * This method is called by the test harness to retrieve all properties
     * needed by a particular test.
     *
     * @param	sPropKeys - Properties to retrieve
     * @return	Properties - property/value pairs
     */
    public Properties getTestSpecificProperties(String[] sPropKeys) throws PropertyNotSetException {
        Properties pTestProps = super.getTestSpecificProperties(sPropKeys);
        String sJtePropVal = "";
        pTestProps.put("porting.ts.url.class.1", getProperty("porting.ts.url.class.1"));
        String tsHome = getProperty("TS_HOME", null);
        if(tsHome == null)
            tsHome = getProperty("ts_home", null);
        if(tsHome != null)
            pTestProps.put("ts_home", tsHome);
        
        
        return  pTestProps;
    }
}

