/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/common/beans/SimpleBean.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.common.beans;

/**
 * Simple single-valued bean for testing purposes.
 */
public class SimpleBean {

    /** Creates new NullBean */
    public SimpleBean() {
    }
    
    private String _value = null;

/* 
 * public methods
 * ========================================================================
 */
    
    /**
     * Sets a non-descriptive value
     * @param value some value
     */
    public void setValue(String value) {
        _value = value;
    }
    
    /**
     * Returns the current value of the bean
     * @return the current value 
     */
    public String getValue() {
        return _value;
    }
    
    /**
     * Causes a RuntimeException to be thrown when called.
     */
    public String toString() {
        throw new RuntimeException();
    }
}
