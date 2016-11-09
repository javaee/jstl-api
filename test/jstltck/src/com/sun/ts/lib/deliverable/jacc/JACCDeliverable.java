/*
 * Copyright 2008 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */


package com.sun.ts.lib.deliverable.jacc;

import com.sun.ts.lib.deliverable.AbstractDeliverable;
import com.sun.ts.lib.deliverable.PropertyManagerInterface;
import com.sun.javatest.TestEnvironment;
import com.sun.ts.lib.util.TestUtil;
import java.io.File;
import java.util.Map;
import java.util.Properties;

public class JACCDeliverable extends AbstractDeliverable {
    
    
    public PropertyManagerInterface createPropertyManager(TestEnvironment te) throws Exception {
        return JACCPropertyManager.getJACCPropertyManager(te);
    }
    
    public PropertyManagerInterface createPropertyManager(Properties p) throws Exception {
        return JACCPropertyManager.getJACCPropertyManager(p);
    }
    
    public PropertyManagerInterface getPropertyManager() throws Exception {
        return JACCPropertyManager.getJACCPropertyManager();
    }
    
    public boolean supportsAutoDeployment() {
        return false;
    }
    
    public boolean supportsAutoJMSAdmin() {
        return false;
    }
    
    public boolean supportsInterop() {
        return false;
    }
    
    public Map getValidVehicles() {
        super.getValidVehicles();
        
        //add default values
        htTSValidVehicles.put("tests.service_eetest.vehicles", new String[]{"standalone", "ejblitesecuredjsp"});
        
        return htTSValidVehicles;
    }
    
}
