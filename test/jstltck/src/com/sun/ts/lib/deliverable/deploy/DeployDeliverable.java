/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: DeployDeliverable.java 56666 2009-02-03 17:27:41Z cf126330 $
 */
 
package com.sun.ts.lib.deliverable.deploy;

import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import com.sun.javatest.TestEnvironment;
import com.sun.ts.lib.deliverable.DeliverableInterface;
import com.sun.ts.lib.deliverable.PropertyManagerInterface;
import com.sun.ts.lib.deliverable.tck.TCKDeliverable;
import com.sun.ts.lib.implementation.sun.javaee.runtime.SunRIDeploymentInfo;
import com.sun.ts.lib.porting.DeploymentInfo;

/**
 * This class serves as a well known place for harness, util, and porting 
 * classes to retrieve property values.
 *  
 * @author	Anand Dhingra
 */	
public class DeployDeliverable extends TCKDeliverable implements DeliverableInterface {

  public PropertyManagerInterface createPropertyManager(TestEnvironment te) throws Exception {
    return DeployPropertyManager.getDeployPropertyManager(te);
  }
	
  public PropertyManagerInterface createPropertyManager(Properties p) throws Exception {
    return DeployPropertyManager.getDeployPropertyManager(p);
  }
	
  public PropertyManagerInterface getPropertyManager() throws Exception {
    return DeployPropertyManager.getDeployPropertyManager();
  }
	
  public boolean supportsAutoDeployment() {
    return true;
  }
	
  public Map getValidVehicles () {
        if (htTSValidVehicles == null) {
            // TS hash table
            htTSValidVehicles = new Hashtable();
            //add mgmt values
            htTSValidVehicles.put("tests.service_eetest.vehicles",
                   new String[]{"standalone"});
        }
        return  htTSValidVehicles;
    }

  public DeploymentInfo getDeploymentInfo (String earFile, String[] sValidRuntimeInfoFilesArray) {
    DeploymentInfo info = null;
    try {
        info = new SunRIDeploymentInfo(earFile, sValidRuntimeInfoFilesArray);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return  info;
  }
  
  public String getAdditionalClasspath(String distDir)
  {
      return null;
  }
}
