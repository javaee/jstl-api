/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: ValidationFactory.java 53299 2007-04-27 18:01:30Z dougd $
 */

package com.sun.ts.tests.common.webclient.validation;

import com.sun.ts.lib.util.TestUtil;

/**
 * Returns a ValidationStrategy instance used to validate a response
 * against a particular WebTestCase
 *
 * @author Ryan Lubke
 * @version %I%
 */
public class ValidationFactory {


    /**
     * Private constructor as all interaction with the
     * class is through the getInstance() method.
     */
    private ValidationFactory() {
    }

/*
 * public methods
 * ========================================================================
 */

    /**
     * Returns a ValidationStrategy instance based on the available
     * factory types.
     *
     * @param validator Validator instance to obtain
     * @return a ValidationStrategy instance or null
     *         if the instance could not be obtained.
     */
    public static ValidationStrategy getInstance(String validator) {
	try {
	    Object o = Thread.currentThread().getContextClassLoader().
		           loadClass(validator).newInstance();
	    if (o instanceof ValidationStrategy) {
		return (ValidationStrategy) o;
	    }
	} catch (Throwable t) {
	    TestUtil.logMsg("[ValidationFactory] Unable to obtain " +
			    "ValidationStrategy instance: " + validator);
	}
	return null;
    }
}
