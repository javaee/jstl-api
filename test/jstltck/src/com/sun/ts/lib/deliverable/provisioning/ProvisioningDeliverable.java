/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: ProvisioningDeliverable.java 51057 2003-03-28 10:52:15Z lschwenk $
 */
 
package com.sun.ts.lib.deliverable.provisioning;

import java.util.Map;
import java.util.Properties;

import com.sun.ts.lib.deliverable.AbstractDeliverable;
import com.sun.ts.lib.deliverable.PropertyManagerInterface;
import com.sun.javatest.TestEnvironment;
import com.sun.ts.lib.util.TestUtil;

/**
 * This class serves as a well known place for harness, util, and porting 
 * classes to retrieve property values.
 *  
 */	
public class ProvisioningDeliverable extends AbstractDeliverable {
    public PropertyManagerInterface createPropertyManager(TestEnvironment te) 
        throws Exception {

	return ProvisioningPropertyManager.getProvisioningPropertyManager(te);

    }
	
    public PropertyManagerInterface createPropertyManager(Properties p) 
        throws Exception {

	return ProvisioningPropertyManager.getProvisioningPropertyManager(p);

    }
	
    public PropertyManagerInterface getPropertyManager() 
        throws Exception {

	return ProvisioningPropertyManager.getProvisioningPropertyManager();

    }
	
    public boolean supportsAutoJMSAdmin() {
        return false;
    }

    public boolean supportsInterop() {
        return false;
    }

    public Map getValidVehicles() {
	super.getValidVehicles();
		
	htTSValidVehicles.put(
            "tests.service_eetest.vehicles", new String[] {"standalone"});

	return htTSValidVehicles;
    }

}
