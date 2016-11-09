/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * $Id: MGMTPropertyManager.java 51043 2005-11-12 22:05:31Z lschwenk $
 */


package  com.sun.ts.lib.deliverable.mgmt;

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
public class MGMTPropertyManager extends AbstractPropertyManager {
    private static MGMTPropertyManager jteMgr = new MGMTPropertyManager();

    private MGMTPropertyManager() {}

    /**
     * This method returns
     * the singleton instance of MGMTPropertyManager which provides access
     * to all ts.jte properties.  This is only called once by the test harness.
     *
     * @param	env - TestEnvironment object from JavaTest
     * @return	MGMTPropertyManager - singleton property manager object
     */
    public final static MGMTPropertyManager getMGMTPropertyManager (TestEnvironment env) throws Exception {
        jteMgr.setTestEnvironment(env);
        return  jteMgr;
    }

    /**
     * This method returns
     * the singleton instance of MGMTPropertyManager which provides access
     * to all ts.jte properties.  This is only called by the init()
     * method in ManualDeployment.java
     *
     * @param	p - Properties object from JavaTest
     * @return	MGMTPropertyManager - singleton property manager object
     */
    public final static MGMTPropertyManager getMGMTPropertyManager (Properties p) throws Exception {
        jteMgr.setJteProperties(p);
        return  jteMgr;
    }

    public final static MGMTPropertyManager getMGMTPropertyManager () throws Exception {
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
        String ctsHome = getProperty("cts_home", null);
	if(ctsHome != null) {
	    pTestProps.put("cts_home", ctsHome);
	}
        return  pTestProps;
    }
}



