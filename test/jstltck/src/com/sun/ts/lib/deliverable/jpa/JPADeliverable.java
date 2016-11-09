/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: JPADeliverable.java 51077 2006-08-29 13:39:58Z lschwenk $
 */

package com.sun.ts.lib.deliverable.jpa;

import com.sun.ts.lib.deliverable.AbstractDeliverable;
import com.sun.ts.lib.deliverable.PropertyManagerInterface;
import com.sun.javatest.TestEnvironment;
import com.sun.ts.lib.util.TestUtil;
import java.io.File;
import java.util.Map;
import java.util.Properties;

public class JPADeliverable extends AbstractDeliverable {
    
    private static String PERSISTENCE_ARCHIVE_FILE_EXT = ".jar";
    
    public PropertyManagerInterface createPropertyManager(TestEnvironment te) throws Exception {
        return JPAPropertyManager.getJPAPropertyManager(te);
    }
    
    public PropertyManagerInterface createPropertyManager(Properties p) throws Exception {
        return JPAPropertyManager.getJPAPropertyManager(p);
    }
    
    public PropertyManagerInterface getPropertyManager() throws Exception {
        return JPAPropertyManager.getJPAPropertyManager();
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
        htTSValidVehicles.put("tests.service_eetest.vehicles", new String[]{"standalone"});
        
        return htTSValidVehicles;
    }
    
    public String getAdditionalClasspath(String distDir) {
        String result = null;
        TestUtil.logMsg("Search for persistence archives under the current dist dir:" +
                distDir);
        File currentDistDirAsFile = new File(distDir);
        for(File aFile : currentDistDirAsFile.listFiles()) {
            if(!aFile.isDirectory()
              && aFile.getName().endsWith(PERSISTENCE_ARCHIVE_FILE_EXT)) {
                TestUtil.logMsg("Found persistence archive file: " + aFile.getName());
                if(result == null) {
                    //the first persistence archive file in the current dist dir
                    result = aFile.getAbsolutePath();
                } else {
                    //we already have found other persistence archives in the current dist dir
                    result += File.pathSeparator + aFile.getAbsolutePath();
                }
            }
        }
        TestUtil.logMsg("Will need to append the following to test run classpath: " +
                result);
        return result;
    }
}
