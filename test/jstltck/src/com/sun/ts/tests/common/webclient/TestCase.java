/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: TestCase.java 53299 2007-04-27 18:01:30Z dougd $
 */

package com.sun.ts.tests.common.webclient;

/**
 * This interface defines a base set of methods required
 * used by a TS test case.
 */
public interface TestCase {

    /**
     * Executes the test case.
     *
     * @throws TestFailureException if the test fails for any reason.
     */
    public void execute() throws TestFailureException;

    /**
     * Sets the name of the test case.
     *
     * @param name of the test case
     */
    public void setName(String name);

    /**
     * Returns the name of this test case.
     *
     * @return test case name
     */
    public String getName();

    /**
     * Sets the state for this test case.  This state
     * will differ from implementation to implementation.
     *
     * @param state test state
     */
    public void setState(Object state);

    /**
     * Returns the state of the test case.  The state returned
     * could possibly differ depending on when this method is
     * called and when the test case has been executed.
     */
    public Object getState();

}
