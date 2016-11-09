/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: TestFailureException.java 53299 2007-04-27 18:01:30Z dougd $
 */

package com.sun.ts.tests.common.webclient;

/**
 * Signifies a failure at some point during a test cycle.
 */
public class TestFailureException extends java.lang.Exception {

    private Throwable throwable = null;

    /**
     * Creates a new instance of <code>TestFailureException</code> 
     * without a detailed message.
     */
    public TestFailureException() {
    }

    /**
     * Creates a new instance of <code>TestFailureException</code>
     * containing the root cause of the test failure.
     * @param t - root cause
     */
    public TestFailureException(Throwable t) {
        throwable = t;
    }

    /**
     * Creates a new instance of <code>TestFailureException</code>
     * with the specified detail message.
     * @param msg - the detail message.
     */
    public TestFailureException(String msg) {
        super(msg);
    }

    /**
     * Creates a new instance of <code>TestFailureException</code>
     * with the specified detail message, and the root cause of the
     * test failure
     * @param msg - the detail message
     * @param t - root cause
     */
    public TestFailureException(String msg, Throwable t) {
        super(msg);
        throwable = t;
    }

    /**
     * Returns, if any, the root cause of this Exception.
     * @return the root cause of this exception, or null
     */
    public Throwable getRootCause() {
        return throwable;
    }
}
