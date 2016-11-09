/*
 * JaspicJavaEEDeliverable.java
 *
 * Created on December 26, 2006, 3:53 PM
 *
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 *
 * @author Raja Perumal
 */

package com.sun.ts.lib.deliverable.jaspic;

import com.sun.ts.lib.deliverable.PropertyManagerInterface;
import com.sun.ts.lib.porting.DeploymentInfo;
import com.sun.ts.lib.implementation.sun.javaee.runtime.SunRIDeploymentInfo;
import com.sun.ts.lib.deliverable.AbstractDeliverable;
import com.sun.ts.lib.deliverable.PropertyNotSetException;
import com.sun.ts.lib.util.TestUtil;

import com.sun.javatest.TestEnvironment;

import java.util.Properties;
import java.util.Map;
import java.io.File;

/**
 * This class serves as a place for JaspicJavaEE Deliverable specific info.
 */
public class JaspicJavaEEDeliverable extends AbstractDeliverable {
    
    public PropertyManagerInterface createPropertyManager(TestEnvironment te) throws Exception {
        
        JaspicJavaEEPropertyManager propMgr = JaspicJavaEEPropertyManager.getJaspicJavaEEPropertyManager(te);
        
        //create JaspicJavaEE specific working directories
        createDir(propMgr.getProperty("wsdlRepository1"));
        createDir(propMgr.getProperty("wsdlRepository2"));
        return propMgr;
    }
    
    public PropertyManagerInterface createPropertyManager(Properties p) throws Exception {
        return JaspicJavaEEPropertyManager.getJaspicJavaEEPropertyManager(p);
    }
    
    public PropertyManagerInterface getPropertyManager() throws Exception {
        return JaspicJavaEEPropertyManager.getJaspicJavaEEPropertyManager();
    }
    
    public DeploymentInfo getDeploymentInfo(String earFile, String[] sValidRuntimeInfoFilesArray) {
        DeploymentInfo info = null;
        try {
            info = new SunRIDeploymentInfo(earFile, sValidRuntimeInfoFilesArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  info;
    }
    
    public boolean supportsInterop() {
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
