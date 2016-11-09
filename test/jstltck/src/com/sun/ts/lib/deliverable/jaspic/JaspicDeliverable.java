/*
 * JaspicDeliverable.java
 *
 * Created on November 1, 2006, 3:53 PM
 *
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 *
 * @author Raja Perumal
 */

package com.sun.ts.lib.deliverable.jaspic;

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
 * This class serves as a place for Jaspic Deliverable specific info.
 */
public class JaspicDeliverable extends AbstractDeliverable {
    
    public PropertyManagerInterface createPropertyManager(TestEnvironment te) throws Exception {
        JaspicPropertyManager propMgr = JaspicPropertyManager.getJaspicPropertyManager(te);
        
        //create Jaspic specific working directories
        createDir(propMgr.getProperty("wsdlRepository1"));
        createDir(propMgr.getProperty("wsdlRepository2"));
        return propMgr;
    }
    
    public PropertyManagerInterface createPropertyManager(Properties p) throws Exception {
        return JaspicPropertyManager.getJaspicPropertyManager(p);
    }
    
    public PropertyManagerInterface getPropertyManager() throws Exception {
        return JaspicPropertyManager.getJaspicPropertyManager();
    }
    
    public Map getValidVehicles() {
        super.getValidVehicles();
        
         htTSValidVehicles.put("tests.service_eetest.vehicles", new String[] {
                 "servlet", "jsp"
            });

        return htTSValidVehicles;
    }
    
    public Map getInteropDirections() {
        super.getInteropDirections();
        
        return htValidRunDirections;
    }
    
    public boolean supportsInterop() {
        return false;
    }

    public boolean supportsAutoDeployment()
    {
        return false;
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
