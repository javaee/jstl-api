/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * $Id: TCKPropertyManager.java 52683 2007-02-12 02:25:42Z lschwenk $
 */


package  com.sun.ts.lib.deliverable.tck;

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
public class TCKPropertyManager extends AbstractPropertyManager {
    private static TCKPropertyManager jteMgr = new TCKPropertyManager();

    /**
     * This method returns
     * the singleton instance of TCKPropertyManager which provides access
     * to all ts.jte properties.  This is only called once by the test harness.
     *
     * @param	env - TestEnvironment object from JavaTest
     * @return	TCKPropertyManager - singleton property manager object
     */
    public final static TCKPropertyManager getTCKPropertyManager (TestEnvironment env) throws Exception {
        jteMgr.setTestEnvironment(env);
        return  jteMgr;
    }

    /**
     * This method returns
     * the singleton instance of TCKPropertyManager which provides access
     * to all ts.jte properties.  This is only called by the init()
     * method in ManualDeployment.java
     *
     * @param	p - Properties object from JavaTest
     * @return	TCKPropertyManager - singleton property manager object
     */
    public final static TCKPropertyManager getTCKPropertyManager (Properties p) throws Exception {
        jteMgr.setJteProperties(p);
        return  jteMgr;
    }

    public final static TCKPropertyManager getTCKPropertyManager () throws Exception {
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



