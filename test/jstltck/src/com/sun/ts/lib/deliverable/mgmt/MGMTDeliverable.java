/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: MGMTDeliverable.java 51086 2003-04-29 09:47:55Z lschwenk $
 */
 
package com.sun.ts.lib.deliverable.mgmt;

import com.sun.ts.lib.deliverable.*;
import com.sun.ts.lib.porting.DeploymentInfo;
import com.sun.ts.lib.implementation.sun.javaee.runtime.SunRIDeploymentInfo;
import com.sun.javatest.*;
import java.util.*;
import java.io.*;

/**
 * This class serves as a well known place for harness, util, and porting 
 * classes to retrieve property values.
 *  
 * @author	Anand Dhingra
 */	
public class MGMTDeliverable extends AbstractDeliverable {

  public PropertyManagerInterface createPropertyManager(TestEnvironment te) throws Exception {
    return MGMTPropertyManager.getMGMTPropertyManager(te);
  }
	
  public PropertyManagerInterface createPropertyManager(Properties p) throws Exception {
    return MGMTPropertyManager.getMGMTPropertyManager(p);
  }
	
  public PropertyManagerInterface getPropertyManager() throws Exception {
    return MGMTPropertyManager.getMGMTPropertyManager();
  }
	
  public Map getValidVehicles () {
        if (htTSValidVehicles == null) {
            // TS hash table
            htTSValidVehicles = new Hashtable();
            //add mgmt values
            htTSValidVehicles.put("tests_j2eetools_mgmt.service_eetest.vehicles",
                   new String[]{"ejb"});
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


}
