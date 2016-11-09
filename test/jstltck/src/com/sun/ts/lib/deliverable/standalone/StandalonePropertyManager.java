/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * $Id: StandalonePropertyManager.java 52683 2007-02-12 02:25:42Z lschwenk $
 */


package  com.sun.ts.lib.deliverable.standalone;

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
public class StandalonePropertyManager extends AbstractPropertyManager {
    private static StandalonePropertyManager jteMgr = new StandalonePropertyManager();

    /**
     * This method returns
     * the singleton instance of StandalonePropertyManager which provides access
     * to all ts.jte properties.  This is only called once by the test harness.
     *
     * @param	env - TestEnvironment object from JavaTest
     * @return	StandalonePropertyManager - singleton property manager object
     */
    public final static StandalonePropertyManager getStandalonePropertyManager (TestEnvironment env) throws Exception {
        jteMgr.setTestEnvironment(env);
        return  jteMgr;
    }

    /**
     * This method returns
     * the singleton instance of StandalonePropertyManager which provides access
     * to all ts.jte properties.  This is only called by the init()
     * method in ManualDeployment.java
     *
     * @param	p - Properties object from JavaTest
     * @return	StandalonePropertyManager - singleton property manager object
     */
    public final static StandalonePropertyManager getStandalonePropertyManager (Properties p) throws Exception {
        jteMgr.setJteProperties(p);
        return  jteMgr;
    }

    public final static StandalonePropertyManager getStandalonePropertyManager () throws Exception {
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
        String sJtePropVal = "";
        pTestProps.put("porting.ts.url.class.1", getProperty("porting.ts.url.class.1"));
	String tsHome = getProperty("TS_HOME", null);
	if(tsHome == null)
	    tsHome = getProperty("cts_home", null);
	if(tsHome != null)
            pTestProps.put("cts_home", tsHome);

        return  pTestProps;
    }
}



