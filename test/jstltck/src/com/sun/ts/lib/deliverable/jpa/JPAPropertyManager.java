/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * $Id: JPAPropertyManager.java 51075 2003-03-27 10:44:21Z lschwenk $
 */


package com.sun.ts.lib.deliverable.jpa;

import com.sun.ts.lib.deliverable.*;
import com.sun.javatest.*;
import com.sun.ts.tests.ejb30.persistence.common.PMClientBase;
import java.util.*;

public class JPAPropertyManager extends AbstractPropertyManager {
    
    private static JPAPropertyManager jteMgr = new JPAPropertyManager();
    
    /**
     * This method returns
     * the singleton instance of JPAPropertyManager which provides access
     * to all ts.jte properties.  This is only called once by the test harness.
     *
     * @param	env - TestEnvironment object from JavaTest
     * @return	JPAPropertyManager - singleton property manager object
     */
    
    public final static JPAPropertyManager getJPAPropertyManager(TestEnvironment env) throws Exception {
        jteMgr.setTestEnvironment(env);
        return  jteMgr;
    }
    
    /**
     * This method returns
     * the singleton instance of JPAPropertyManager which provides access
     * to all ts.jte properties.  This is only called by the init()
     * method in ManualDeployment.java
     *
     * @param	p - Properties object from JavaTest
     * @return	JPAPropertyManager - singleton property manager object
     */
    public final static JPAPropertyManager getJPAPropertyManager(Properties p) throws Exception {
        jteMgr.setJteProperties(p);
        return  jteMgr;
    }
    
    public final static JPAPropertyManager getJPAPropertyManager() throws Exception {
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
            tsHome = getProperty("cts_home", null);
        if(tsHome != null)
            pTestProps.put("cts_home", tsHome);
        
        //get persistence tck specific properties
        String mode = getProperty(PMClientBase.MODE_PROP);
        String puName = getProperty(PMClientBase.PERSISTENCE_UNIT_NAME_PROP);
        String puPropFilePath = getProperty(PMClientBase.PERSISTENCE_UNIT_PROPERTIES_FILE_PROP);
        String errorMsg = "";
        if(mode == null) {
            errorMsg += PMClientBase.MODE_PROP + " is not set in ts.jte. ";
        }
        if(puName == null) {
            errorMsg += PMClientBase.PERSISTENCE_UNIT_NAME_PROP +
                    " is not set in ts.jte. ";
        }
        if(puPropFilePath == null) {
            errorMsg += PMClientBase.PERSISTENCE_UNIT_PROPERTIES_FILE_PROP +
                    " is not set in ts.jte. ";
        }
        if(errorMsg.length() > 0) {
            throw new PropertyNotSetException(errorMsg);
        } else {
            pTestProps.put(PMClientBase.MODE_PROP, mode);
            pTestProps.put(PMClientBase.PERSISTENCE_UNIT_NAME_PROP, puName);
            pTestProps.put(PMClientBase.PERSISTENCE_UNIT_PROPERTIES_FILE_PROP, puPropFilePath);
        }
        
        return  pTestProps;
    }
}

