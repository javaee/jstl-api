/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: ValidationStrategy.java 53299 2007-04-27 18:01:30Z dougd $
 */


package com.sun.ts.tests.common.webclient.validation;

import com.sun.ts.tests.common.webclient.WebTestCase;

/**
 * A ValidationStrategy is used to compare a server response
 * with a configured test case.  How this validation is performed
 * is up to the concrete implementation.
 */
public interface ValidationStrategy {
    public boolean validate(WebTestCase testCase);
}
