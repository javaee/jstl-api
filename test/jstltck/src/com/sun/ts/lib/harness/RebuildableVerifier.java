/*
 * Copyright 2008 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: RebuildableVerifier.java 54269 2008-02-21 00:01:15Z kgrucci $
 */


package  com.sun.ts.lib.harness;

import  com.sun.ts.lib.util.*;
import  java.util.*;
import  java.io.*;


/**
 * This class is used by the TS harness to figure out which test directories
 * contain tests which must be rebuilt using a vendor's tools and then run
 * against the Reference Implementation.
 *
 * A singleton class not intended for concurrent access.
 *
 */
public class RebuildableVerifier {
    public final static String REBUILDABLE_PROP_FILE_NAME = "rebuildable.properties";
    public final static String EXCLUDE_KEY = "exclude.dir";

    private static Properties mapping;
    private static String[] keys;  //sorted ascending
    private static String[] excludes;
    private String relativeTestDir;
    private static boolean loaded;

    //an uninitialized singleton instance
    private static RebuildableVerifier instance = new RebuildableVerifier();

    private RebuildableVerifier() {}

    public static RebuildableVerifier getInstance(File path) {
        if(instance == null) {
            instance = new RebuildableVerifier();
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
            mapping = ConfigUtil.loadPropertiesFor(REBUILDABLE_PROP_FILE_NAME);
            loadExcludes();
            keys = ConfigUtil.loadKeysFrom(mapping);
            loaded = true;
        }
        if(mapping != null) {
            this.relativeTestDir = TestUtil.getRelativePath(file.getPath());
        }
        
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
     * This method tells us if a given directory path is rebuildable of not
     *
     * @return	true if the directory path contains rebuildable tests
     * 	run in
     */
    public boolean isRebuildable() {
        boolean result = false;

        if(mapping == null || keys == null || isExcluded()) {
            result = false;
        }
        else
        {
            for (int i = keys.length - 1; i >= 0; i--) {  //must traverse in reverse order.
                if(("rebuildable." + relativeTestDir).startsWith(keys[i])) {
                result = true;
                break;
                }
            }
        }
        return result;
    }
}
