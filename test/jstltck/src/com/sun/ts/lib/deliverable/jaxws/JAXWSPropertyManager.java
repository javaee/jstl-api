/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * $Id: JAXWSPropertyManager.java 51084 2006-03-24 15:39:49Z lschwenk $
 */


package  com.sun.ts.lib.deliverable.jaxws;

import  com.sun.ts.lib.deliverable.*;
import  com.sun.ts.lib.util.*;
import  com.sun.javatest.*;
import  java.util.*;
import  java.io.*;


/**
 * This class serves as a well known place for harness, util, and porting
 * classes to retrieve property values.
 *
 */
public class JAXWSPropertyManager extends com.sun.ts.lib.deliverable.tck.TCKPropertyManager {
    private static JAXWSPropertyManager jteMgr = new JAXWSPropertyManager();

    private String sURLClass1;
    private String sURLClass2;
    private String sWebServerHost;
    private String sWebServerPort;
    private String sWebServerHost2;
    private String sWebServerPort2;

    /**
     * This method returns
     * the singleton instance of JAXWSPropertyManager which provides access
     * to all ts.jte properties.  This is only called once by the test harness.
     *
     * @param	env - TestEnvironment object from JavaTest
     * @return	JAXWSPropertyManager - singleton property manager object
     */
    public final static JAXWSPropertyManager getJAXWSPropertyManager (TestEnvironment env) throws Exception {
        jteMgr.setTestEnvironment(env);
        jteMgr.initInteropProperties();
        return  jteMgr;
    }

    /**
     * This method returns
     * the singleton instance of JAXWSPropertyManager which provides access
     * to all ts.jte properties.  This is only called by the init()
     * method in ManualDeployment.java
     *
     * @param	p - Properties object from JavaTest
     * @return	JAXWSPropertyManager - singleton property manager object
     */
    public final static JAXWSPropertyManager getJAXWSPropertyManager (Properties p) throws Exception {
        jteMgr.setJteProperties(p);
        return  jteMgr;
    }

    public final static JAXWSPropertyManager getJAXWSPropertyManager () throws Exception {
        return  jteMgr;
    }

    /**
     * This method is called by the test harness to retrieve all properties
     * needed by a particular test.
     *
     * @param  sPropKeys - Properties to retrieve
     * @return Properties - property/value pairs
     */
    public Properties getTestSpecificProperties (String[] sPropKeys) throws PropertyNotSetException {
        Properties pTestProps = super.getTestSpecificProperties(sPropKeys);
        pTestProps.put("porting.ts.url.class.2", getProperty("porting.ts.url.class.2"));
        return  pTestProps;
    }

    public void forwardValues () {
        //reverse all interop props
        setProperty("porting.ts.url.class.1", sURLClass1);
        setProperty("porting.ts.url.class.2", sURLClass2);
        setProperty("webServerHost", sWebServerHost);
        setProperty("webServerHost.2", sWebServerHost2);
        setProperty("webServerPort", sWebServerPort);
        setProperty("webServerPort.2", sWebServerPort2);
        super.forwardValues();
    }

    public void reverseValues () {
        //reverse all interop props
        setProperty("porting.ts.url.class.1", sURLClass2);
        setProperty("porting.ts.url.class.2", sURLClass1);
        setProperty("webServerHost", sWebServerHost2);
        setProperty("webServerHost.2", sWebServerHost);
        setProperty("webServerPort", sWebServerPort2);
        setProperty("webServerPort.2", sWebServerPort);
		
        super.reverseValues();
    }


    private void initInteropProperties () {
        sURLClass1 = getProperty("porting.ts.url.class.1", null);
        sURLClass2 = getProperty("porting.ts.url.class.2", null);
        sWebServerHost = getProperty("webServerHost", null);
        sWebServerPort = getProperty("webServerPort", null);
        sWebServerHost2 = getProperty("webServerHost.2", null);
        sWebServerPort2 = getProperty("webServerPort.2", null);
    
    }

}



