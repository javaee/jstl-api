/*
 * Copyright 2008 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * $Id$
 */

package com.sun.ts.lib.harness;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import com.sun.ts.lib.deliverable.DeliverableFactory;
import com.sun.ts.lib.deliverable.PropertyManagerInterface;
import com.sun.ts.lib.util.TestUtil;

public final class ProfileHelper {
    
    private static PropertyManagerInterface jteMgr;
    
    public static String[] getArchives(String sDir, String sInteropDirections)
    {
        try {
            jteMgr = 
                DeliverableFactory.getDeliverableInstance().getPropertyManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String javaeeLevel = jteMgr.getProperty("javaee.level", "full");
        ArrayList<String> sFilteredAppJarsArray = new ArrayList<String>();
        boolean bEarPresent = false;
        
        File fTestDir = new File(sDir);
        String[] sAppJarsArray = fTestDir.list(ArchiveFilter.getInstance());
        
        if (sInteropDirections.equals("forward") && !isInteropDir(sDir))
        {    
            //if forward and not an interop dir, then only deploy the non vibuilt apps
            sAppJarsArray = fTestDir.list(NonVIBuiltArchiveFilter.getInstance());
        }
        else if(sInteropDirections.equals("reverse") && !isInteropDir(sDir))
        {    
            //if reverse and not an interop dir, then only deploy the vibuilt apps
            sAppJarsArray = fTestDir.list(VIBuiltArchiveFilter.getInstance());
        }
        
        if(sAppJarsArray != null)
        {
            //first, see if we have any ears
            bEarPresent = isEarPresent(sAppJarsArray);

            if(javaeeLevel.equalsIgnoreCase("full"))
            {
                if(bEarPresent)
                {
                    for(int ii=0; ii<sAppJarsArray.length; ii++)
                    {
                        String name= sAppJarsArray[ii];
                        if((name.endsWith(".ear") || 
                           (name.indexOf("_component") != -1 && 
                           (name.endsWith(".jar") || 
                            name.endsWith(".war") || 
                            name.endsWith(".rar") || 
                            name.endsWith(".car")))))
                        {
                            //if any ears exist, return only ears and _component
                            sFilteredAppJarsArray.add(name);
                        }
                    }
                    sAppJarsArray = sFilteredAppJarsArray.toArray(new String[0]);
                }
            }
            else
            {
                //Must be in a subset of EE so strip out ears if necessary
                if(bEarPresent)
                {
                    for(int ii=0; ii<sAppJarsArray.length; ii++)
                    {
                        String name= sAppJarsArray[ii];
                        if(!name.endsWith(".ear"))
                        {
                            //if any ears exist, return all non-ears
                            sFilteredAppJarsArray.add(name);
                        }
                    }
                    sAppJarsArray = sFilteredAppJarsArray.toArray(new String[0]);
                }
            }
        }
        return sAppJarsArray;
    }
    
    private static boolean isEarPresent(String[] archives) {
        
        boolean bFoundEar = false;
        
        for(int ii=0; ii<archives.length; ii++)
        {
            if(archives[ii].endsWith(".ear"))
            {
                bFoundEar = true;
                break;
            }
        }
        return bFoundEar;
    }
    
    private static boolean isInteropDir(String sDir) {
        return (sDir.indexOf("interop") != -1);
    }
    
    public static class VIBuiltArchiveFilter
        extends ArchiveFilter {
        private static VIBuiltArchiveFilter instance = new VIBuiltArchiveFilter();

        private VIBuiltArchiveFilter() {
        }

        public static VIBuiltArchiveFilter getInstance() {
            return instance;
        }

        public boolean accept(File dir, String name) {
            return (name.endsWith(".ear") || 
                   name.endsWith(".war") ||
                   name.endsWith(".rar") ||
                   name.endsWith(".jar")) &&
                   name.startsWith("vi_built_") && 
                   deployThisVehicleApp(dir, name);
        }
    }
    
    public static class NonVIBuiltArchiveFilter
        extends ArchiveFilter {
        private static NonVIBuiltArchiveFilter instance = new NonVIBuiltArchiveFilter();

        private NonVIBuiltArchiveFilter() {
        }

        public static NonVIBuiltArchiveFilter getInstance() {
            return instance;
        }

        public boolean accept(File dir, String name) {
            return (name.endsWith(".ear") || 
                   name.endsWith(".war") ||
                   name.endsWith(".rar") ||
                   name.endsWith(".jar")) &&
                   !name.startsWith("vi_built_") && 
                   deployThisVehicleApp(dir, name);
        }
    }
    
    public static class ArchiveFilter implements FilenameFilter {
        private static ArchiveFilter instance = new ArchiveFilter();

        private ArchiveFilter() {
        }

        public static ArchiveFilter getInstance() {
            return instance;
        }

        public boolean accept(File dir, String name) {
            return (name.endsWith(".ear")
                    || name.endsWith(".war")
                    || name.endsWith(".rar")
                    || name.endsWith(".jar"))
                && deployThisVehicleApp(dir, name);
        }

        protected boolean deployThisVehicleApp(File file, String sName) {
            boolean bVal = false;
            //test whether we should deploy this vehicle ear file
            if (sName.indexOf("_vehicle") == -1 || sName.indexOf("_vehicles") != -1) {
                bVal = true;
            } else {
                //check that this vehicle archive should be deployed
                VehicleVerifier vehicleVerifier = VehicleVerifier.getInstance(file);
                String[] sVal = vehicleVerifier.getVehicleSet();
                if (sVal != null) {

                    //check keywords to see if the user has subsetted...
                    String keywords = jteMgr.getProperty("current.keywords", "all");

                    ArrayList<String> filtered = new ArrayList<String>();

                    for(int ii = 0; ii < sVal.length; ii++)
                    {
                        if(keywords.indexOf(sVal[ii] + "_vehicle") != -1)
                        {
                            filtered.add(sVal[ii]);

                        }
                    }
                    
                    //if keywords refer to specific veicle(s), then subset the list of valid vehicles
                    if(!filtered.isEmpty())
                    {
                        sVal = filtered.toArray(new String[0]);
                    }

                    
                    for (int ii = 0; ii < sVal.length; ii++)
                    {
                        if (sName.indexOf(sVal[ii] + "_vehicle") != -1)
                            bVal = true;
                    }
                }
            }
            return bVal;
        }
    }
}
