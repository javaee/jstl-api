/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * $Id: JMSPropertyManager.java 51069 2003-03-27 12:46:18Z lschwenk $
 */


package  com.sun.ts.lib.deliverable.jms;

import  com.sun.ts.lib.deliverable.*;
import  com.sun.ts.lib.util.*;
import  com.sun.javatest.*;
import  java.util.*;
import  java.io.*;


/**
 * This class serves as a well known place for harness, util, and porting
 * classes to retrieve property values.
 *
 * @author	Dianne Jiao
 */
public class JMSPropertyManager extends AbstractPropertyManager {
    private static JMSPropertyManager jteMgr = new JMSPropertyManager();

    private JMSPropertyManager() {}

    /**
     * This method returns
     * the singleton instance of JMSPropertyManager which provides access
     * to all ts.jte properties.  This is only called once by the test harness.
     *
     * @param	env - TestEnvironment object from JavaTest
     * @return	JMSPropertyManager - singleton property manager object
     */
    public final static JMSPropertyManager getJMSPropertyManager (TestEnvironment env) throws Exception {
        jteMgr.setTestEnvironment(env);
        return  jteMgr;
    }

    /**
     * This method returns
     * the singleton instance of JMSPropertyManager which provides access
     * to all ts.jte properties.  This is only called by the init()
     * method in ManualDeployment.java
     *
     * @param	p - Properties object from JavaTest
     * @return	JMSPropertyManager - singleton property manager object
     */
    public final static JMSPropertyManager getJMSPropertyManager (Properties p) throws Exception {
        jteMgr.setJteProperties(p);
        return  jteMgr;
    }

    public final static JMSPropertyManager getJMSPropertyManager () throws Exception {
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
        pTestProps.put("porting.ts.jmsObjects.class.1", getProperty("porting.ts.jmsObjects.class.1"));
        return  pTestProps;
    }
}



