/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: VehicleVerifier.java 52502 2007-01-24 02:50:22Z lschwenk $
 */


package  com.sun.ts.lib.harness;

import  com.sun.ts.lib.util.*;
import  java.util.*;
import  java.io.*;


/**
 * This class is used by the TS harness to figure out which vehicles are
 * to be used by the Service tests in the TS.  These defaults can be overridden
 * by editing appropriate properties file.  However, this override mechanism
 * is only to be used for debugging purposes.  When testing for J2EE
 * certification, the defaults specified in this class must be used.
 *
 * A singleton class not intended for concurrent access.
 *
 * @author	Kyle Grucci
 */
public class VehicleVerifier {
    public final static String VEHICLE_PROP_FILE_NAME = "vehicle.properties";
    public final static String EXCLUDE_KEY = "exclude.dir";

    private static Properties mapping;
    private static String[] keys;  //sorted ascending
    private static String[] excludes;
    private String relativeTestDir;
    private static boolean loaded;

    //an uninitialized singleton instance
    private static VehicleVerifier instance = new VehicleVerifier();

    private VehicleVerifier () {}

    public static VehicleVerifier getInstance(File path) {
        if(instance == null) {
            instance = new VehicleVerifier();
        }
        instance.init(path);
        return instance;
    }

    private void loadExcludes() {
        if(this.mapping == null) {
            excludes = TestUtil.EMPTY_STRING_ARRAY;
        } else {
            excludes = ConfigUtil.stringToArray((String) mapping.remove(EXCLUDE_KEY));
        }
    }

    private void init(File file) {
        if (!loaded) {
            mapping = ConfigUtil.loadPropertiesFor(VEHICLE_PROP_FILE_NAME);
            loadExcludes();
            keys = ConfigUtil.loadKeysFrom(mapping);
            loaded = true;
        }
        if(mapping != null) {
            this.relativeTestDir = TestUtil.getRelativePath(file.getPath());
        }
        //if mapping is null, it means this tck uses no vehicles and vehicle.properties
        //does not exist. So don't bother to convert testDir to relative path.
    }

    private boolean isExcluded() {
        for(int i = 0; i < excludes.length; i++) {
            if(relativeTestDir.startsWith(excludes[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method gets the current set of vehicles to be used for a given
     * directory path.
     *
     * @return	a String array of the vehicles that this test should be
     * 	run in
     */
    public String[] getVehicleSet () {
        if(mapping == null || keys == null) {
            return TestUtil.EMPTY_STRING_ARRAY;
        }
        if(isExcluded()) {
            return TestUtil.EMPTY_STRING_ARRAY;
        }
        String[] result = ConfigUtil.getMappingValue(this.mapping, this.keys, this.relativeTestDir);
        return result;
    }

    public static void main(String args[]) {
        File testDir = null;
        if(args.length == 0) {
            testDir = new File(System.getProperty("user.dir"));
        } else {
            testDir = new File(args[0]);
        }
        VehicleVerifier ver = VehicleVerifier.getInstance(testDir);
        String[] result = ver.getVehicleSet();
        System.out.println(testDir.getPath() + " : " + Arrays.asList(result).toString());
    }
}
