/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: TestRunException.java 52502 2007-01-24 02:50:22Z lschwenk $
 */

package com.sun.ts.lib.harness;

/**
 * This class defines any exception thrown by the Regression extensions.
 *
 * @author Iris A Garcia
 * @version @(#)TestRunException.java	1.2 99/03/15
 */
public class TestRunException extends RuntimeException
{
    public TestRunException(String msg) {
	super(msg);
    } // TestRunException()

    public TestRunException(Throwable t) {
	super(t.getMessage());
	this.t = t;
    } // TestRunException()

    public Throwable getThrowable() {
	return t;
    } // getThrowable()

    //----------member variables------------------------------------------------

    Throwable t = null;
}
