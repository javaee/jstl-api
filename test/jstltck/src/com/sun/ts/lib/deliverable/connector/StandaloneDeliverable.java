/*
 * StandaloneDeliverable.java
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

package com.sun.ts.lib.deliverable.connector;

import com.sun.ts.lib.deliverable.AbstractDeliverable;
import com.sun.ts.lib.deliverable.PropertyManagerInterface;
import com.sun.ts.lib.util.TestUtil;
import com.sun.ts.lib.implementation.sun.javaee.runtime.SunRIDeploymentInfo;
import com.sun.ts.lib.porting.DeploymentInfo;
import com.sun.javatest.TestEnvironment;

import java.util.Map;
import java.util.Properties;
import java.io.File;

/**
 * This class serves as a place for Deliverable specific info.
 */
public class StandaloneDeliverable extends AbstractDeliverable {
    
    public PropertyManagerInterface createPropertyManager(TestEnvironment te) throws Exception {
        StandalonePropertyManager propMgr = StandalonePropertyManager.getStandalonePropertyManager(te);
        
        // create specific working directories
        createDir(propMgr.getProperty("wsdlRepository1"));
        createDir(propMgr.getProperty("wsdlRepository2"));
        return propMgr;
    }
    
    public PropertyManagerInterface createPropertyManager(Properties p) throws Exception {
        return StandalonePropertyManager.getStandalonePropertyManager(p);
    }
    
    public PropertyManagerInterface getPropertyManager() throws Exception {
        return StandalonePropertyManager.getStandalonePropertyManager();
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
        
         htTSValidVehicles.put("tests.service_eetest.vehicles", new String[] {
                 "servlet", "standalone", "ejb" 
         });

        return htTSValidVehicles;
    }

    private void createDir(String sDir) throws Exception {
        File fDir = new File(sDir);
        
        if (!fDir.exists()) {
            if (!fDir.mkdirs()) {
                throw new Exception("Failed to create directory: "
                        + sDir);
            }
            TestUtil.logHarnessDebug("Successfully created directory: "
                    + sDir);
        }
    }
}
