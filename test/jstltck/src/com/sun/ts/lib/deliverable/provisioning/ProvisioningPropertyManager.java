/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * $Id: ProvisioningPropertyManager.java 51061 2003-08-26 14:27:12Z lschwenk $
 */


package  com.sun.ts.lib.deliverable.provisioning;

import java.util.Properties;
import com.sun.ts.lib.deliverable.AbstractPropertyManager;
import com.sun.ts.lib.deliverable.PropertyNotSetException;
import com.sun.ts.lib.util.TestUtil;
import com.sun.javatest.TestEnvironment;


/**
 * This class serves as a well known place for harness, util, and porting
 * classes to retrieve property values.
 *
 */
public class ProvisioningPropertyManager extends AbstractPropertyManager {
    private static ProvisioningPropertyManager jteMgr = 
        new ProvisioningPropertyManager();

    private ProvisioningPropertyManager() {}

    /**
     * This method returns the singleton instance of
     * ProvisioningPropertyManager which provides access to all ts.jte
     * properties.  This is only called once by the test harness.
     *
     * @param	env - TestEnvironment object from JavaTest
     * @return	ProvisioningPropertyManager - singleton property manager object
     */
    public final static ProvisioningPropertyManager 
        getProvisioningPropertyManager(TestEnvironment env) throws Exception {

        jteMgr.setTestEnvironment(env);
        return  jteMgr;
    }

    /**
     * This method returns the singleton instance of
     * ProvisioningPropertyManager which provides access to all ts.jte
     * properties.  This is only called by the init() method in
     * ManualDeployment.java
     *
     * @param	p - Properties object from JavaTest
     * @return	ProvisioningPropertyManager - singleton property manager object
     */
    public final static ProvisioningPropertyManager 
        getProvisioningPropertyManager(Properties p) throws Exception {

        jteMgr.setJteProperties(p);
        return  jteMgr;
    }

    /**
     * This method returns the singleton instance of
     * ProvisioningPropertyManager which provides access to all ts.jte
     * properties.  This is only called by the init() method in
     * ManualDeployment.java
     *
     */
    public final static ProvisioningPropertyManager 
        getProvisioningPropertyManager() throws Exception {

        return  jteMgr;
    }

    /**
     * This method is called by the test harness to retrieve all properties
     * needed by a particular test.
     *
     * @param	sPropKeys - Properties to retrieve
     * @return	Properties - property/value pairs
     */
    public Properties getTestSpecificProperties(String[] sPropKeys) throws 
                                                PropertyNotSetException {

        Properties pTestProps = super.getTestSpecificProperties(sPropKeys);

        pTestProps.put("porting.ts.url.class.1", 
                        getProperty("porting.ts.url.class.1"));

        pTestProps.put("porting.ts.deploy.class.1", 
                        getProperty("porting.ts.deploy.class.1"));

        pTestProps.put("porting.ts.provisioning.class.1", 
                        getProperty("porting.ts.provisioning.class.1"));

        return  pTestProps;
    }
}
