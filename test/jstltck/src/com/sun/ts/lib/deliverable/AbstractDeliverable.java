/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: AbstractDeliverable.java 57251 2009-03-19 20:06:04Z kgrucci $
 */


package  com.sun.ts.lib.deliverable;

import  com.sun.ts.lib.util.TestUtil;
import  com.sun.ts.lib.porting.DeploymentInfo;
import  java.util.Map;
import  java.util.Hashtable;


/**
 * This class serves as an abstract implementation of the DeliverableInterface.
 * It can be extended to customize values for a particular deliverable.
 *
 * @author	Kyle Grucci
 */
public abstract class AbstractDeliverable
        implements DeliverableInterface {
    protected Map htTSValidVehicles;
    protected Map htValidApps;
    protected Map htValidRunDirections;

    public boolean supportsAutoDeployment () {
        return  true;
    }

    public boolean supportsAutoJMSAdmin () {
        return  true;
    }

    public Map getValidVehicles () {
        if (htTSValidVehicles == null) {
            // TS hash table
            htTSValidVehicles = new Hashtable();
            //add default values
            htTSValidVehicles.put("tests.service_eetest.vehicles", new String[] {
                "ejb", "servlet", "jsp"
            });
        }
        return  htTSValidVehicles;
    }

    public Map getInteropDirections () {
        if (htValidRunDirections == null) {
            htValidRunDirections = new Hashtable();
            //default for all tests
            htValidRunDirections.put("tests.interop", "forward");
        }
        return  htValidRunDirections;
    }

    public boolean supportsInterop () {
        return  true;
    }

    public String getAdditionalClasspath(String distDir)
    {
        return null;
    }

    public DeploymentInfo getDeploymentInfo (String earFile, String[] sValidRuntimeInfoFilesArray) {
        return  null;
    }
}



