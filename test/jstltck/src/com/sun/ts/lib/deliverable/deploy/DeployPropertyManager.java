/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * $Id: DeployPropertyManager.java 52683 2007-02-12 02:25:42Z lschwenk $
 */


package  com.sun.ts.lib.deliverable.deploy;

import  com.sun.ts.lib.deliverable.*;
import  com.sun.ts.lib.util.*;
import  com.sun.javatest.*;
import  java.util.*;
import  java.io.*;


/**
 * This class serves as a well known place for harness, util, and porting
 * classes to retrieve property values.
 *
 * @author	Kyle Grucci
 */
public class DeployPropertyManager extends AbstractPropertyManager {
    private static DeployPropertyManager jteMgr = new DeployPropertyManager();

    private DeployPropertyManager() {}

    /**
     * This method returns
     * the singleton instance of DeployPropertyManager which provides access
     * to all ts.jte properties.  This is only called once by the test harness.
     *
     * @param	env - TestEnvironment object from JavaTest
     * @return	DeployPropertyManager - singleton property manager object
     */
    public final static DeployPropertyManager getDeployPropertyManager (TestEnvironment env) throws Exception {
        jteMgr.setTestEnvironment(env);
        return  jteMgr;
    }

    /**
     * This method returns
     * the singleton instance of DeployPropertyManager which provides access
     * to all ts.jte properties.  This is only called by the init()
     * method in ManualDeployment.java
     *
     * @param	p - Properties object from JavaTest
     * @return	DeployPropertyManager - singleton property manager object
     */
    public final static DeployPropertyManager getDeployPropertyManager (Properties p) throws Exception {
        jteMgr.setJteProperties(p);
        return  jteMgr;
    }

    public final static DeployPropertyManager getDeployPropertyManager () throws Exception {
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
        // Deployment needs four additional properties to load a vendors
        // DeploymentManager implementation
        pTestProps.put("deployManagerJarFile", getProperty("deployManagerJarFile"));
        pTestProps.put("deployManageruri", getProperty("deployManageruri"));
        pTestProps.put("deployManageruname", getProperty("deployManageruname"));
        pTestProps.put("deployManagerpasswd", getProperty("deployManagerpasswd"));
        // Modules and deploymentplans to deploy for testing
        pTestProps.put("deploytestsEarFile", getProperty("deploytestsEarFile"));
        pTestProps.put("deploytestsEarPlan", getProperty("deploytestsEarPlan"));
        pTestProps.put("deploytestsEjbJarFile", getProperty("deploytestsEjbJarFile"));
        pTestProps.put("deploytestsEjbJarPlan", getProperty("deploytestsEjbJarPlan"));
        pTestProps.put("deploytestsWARFile", getProperty("deploytestsWARFile"));
        pTestProps.put("deploytestsWARPlan", getProperty("deploytestsWARPlan"));
        pTestProps.put("deploytestsCARFile", getProperty("deploytestsCARFile"));
        pTestProps.put("deploytestsCARPlan", getProperty("deploytestsCARPlan"));
        pTestProps.put("deploytestsRARFile", getProperty("deploytestsRARFile"));
        pTestProps.put("deploytestsRARPlan", getProperty("deploytestsRARPlan"));
        // Tools sig file properties
        pTestProps.put("ToolsSigTestClasspath", getProperty("ToolsSigTestClasspath"));
        pTestProps.put("ToolsSigTestUrl", getProperty("ToolsSigTestUrl"));

	String ctsHome = getProperty("cts_home", null);
	if(ctsHome != null) {
	    pTestProps.put("cts_home", ctsHome);
	}
        return  pTestProps;
    }
}



