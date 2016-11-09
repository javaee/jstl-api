/*
 * StandalonePropertyManager.java
 *
 * Created on November 1, 2006, 3:53 PM
 *
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 *
 * 
 */


package  com.sun.ts.lib.deliverable.connector;

import com.sun.ts.lib.deliverable.*;
import com.sun.ts.lib.deliverable.tck.*;
import com.sun.javatest.TestEnvironment;

import java.util.Map;
import java.util.Properties;


/**
 * This class serves as a well known place for harness, util, and porting
 * classes to retrieve property values.
 */
public class StandalonePropertyManager extends TCKPropertyManager {

    // uninitialized singleton instance
    private static StandalonePropertyManager jteMgr = new StandalonePropertyManager();
    

    /**
     * This method returns
     * the singleton instance of TSPropertyManager which provides access
     * to all ts.jte properties.  This is only called once by the test harness.
     *
     * @param	env - TestEnvironment object from JavaTest
     * @return	TSPropertyManager - singleton property manager object
     */
    public final static StandalonePropertyManager getStandalonePropertyManager(TestEnvironment env)
    throws PropertyNotSetException {
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
    public final static StandalonePropertyManager getStandalonePropertyManager(Properties p)
    throws PropertyNotSetException {
        jteMgr.setJteProperties(p);
        return  jteMgr;
    }
    

    public final static StandalonePropertyManager getStandalonePropertyManager()
    throws PropertyNotSetException {
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
        
        //if the abstract propertymanager already loaded all props, just return
        // if (pTestProps.getProperty("all.props").equalsIgnoreCase("true")) {
        //     return pTestProps;
        // }
        
        String sJtePropVal = "";
        // add all porting class props so the factories can work in the server
        pTestProps.put("porting.ts.deploy.class.1", getProperty("porting.ts.deploy.class.1"));
        pTestProps.put("porting.ts.deploy.class.2", getProperty("porting.ts.deploy.class.2"));
        pTestProps.put("porting.ts.login.class.1", getProperty("porting.ts.login.class.1"));
        pTestProps.put("porting.ts.login.class.2", getProperty("porting.ts.login.class.2"));
        pTestProps.put("porting.ts.HttpsURLConnection.class.1", 
                       getProperty("porting.ts.HttpsURLConnection.class.1"));
        pTestProps.put("porting.ts.HttpsURLConnection.class.2", 
                       getProperty("porting.ts.HttpsURLConnection.class.2"));
        pTestProps.put("porting.ts.url.class.1", getProperty("porting.ts.url.class.1"));
        pTestProps.put("porting.ts.url.class.2", getProperty("porting.ts.url.class.2"));
        pTestProps.put("porting.ts.jms.class.1", getProperty("porting.ts.jms.class.1"));
        pTestProps.put("porting.ts.jms.class.2", getProperty("porting.ts.jms.class.2"));
        pTestProps.put("namingServiceHost2", getProperty("namingServiceHost2"));
        pTestProps.put("namingServicePort2", getProperty("namingServicePort2"));
        pTestProps.put("namingServiceHost1", getProperty("namingServiceHost1"));
        pTestProps.put("namingServicePort1", getProperty("namingServicePort1"));
        pTestProps.put("wsdlRepository1", getProperty("wsdlRepository1"));
        pTestProps.put("wsdlRepository2", getProperty("wsdlRepository2"));
        pTestProps.put("porting.ts.jms.class.2", getProperty("porting.ts.jms.class.2"));
        
        //props needed when using the JSR-88 APIs
        pTestProps.put("deployManagerJarFile.1", getProperty("deployManagerJarFile.1"));
        pTestProps.put("deployManageruri.1", getProperty("deployManageruri.1"));
        
        pTestProps.put("deployManageruname.1", getProperty("deployManageruname.1"));
        pTestProps.put("deployManagerpasswd.1", getProperty("deployManagerpasswd.1"));
        pTestProps.put("deployManagerJarFile.2", getProperty("deployManagerJarFile.2"));
        pTestProps.put("deployManageruri.2", getProperty("deployManageruri.2"));
        
        pTestProps.put("deployManageruname.2", getProperty("deployManageruname.2"));
        pTestProps.put("deployManagerpasswd.2", getProperty("deployManagerpasswd.2"));
        pTestProps.put("porting.ts.deploy2.class.1", getProperty("porting.ts.deploy2.class.1"));
        pTestProps.put("porting.ts.deploy2.class.2", getProperty("porting.ts.deploy2.class.2"));
        
        pTestProps.put("porting.ts.connectorConnection.class", 
                       getProperty("porting.ts.connectorConnection.class"));
        
        return  pTestProps;
    }
}



