/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * @(#)AlgoResources2_en.java	1.1 03/26/02
 */

package com.sun.ts.tests.jstl.common.resources;

public class Resources_en extends java.util.ListResourceBundle {
    
    private static final Object[][] resources = {
        { "mkey", "en message" },
        { "pkey", "param1: {0}, param2: {1}" }
    };
    
    
    /** Creates new Resources_en */
    public Resources_en() {
    }

/* 
 * public methods
 * ========================================================================
 */
    public java.lang.Object[][] getContents() {
        return resources;
    }    
}
