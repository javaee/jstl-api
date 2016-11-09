/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/core/general/catchtag/JSTLClient.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.spec.core.general.catchtag;

import java.io.PrintWriter;
import com.sun.javatest.Status;
import com.sun.ts.lib.harness.EETest.Fault;
import com.sun.ts.tests.jstl.common.client.AbstractUrlClient;

public class JSTLClient extends AbstractUrlClient {

    /*
     * @class.setup_props: webServerHost; webServerPort; ts_home;
     */

    /** Creates new JSTLClient */
    public JSTLClient() {
    }

/*
 * public methods
 * ========================================================================
 */

    /**
     * Entry point for different-VM execution.  It should delegate to method
     * run(String[], PrintWriter, PrintWriter), and this method should not
     * contain any test configuration.
     */
    public static void main(String[] args) {
        JSTLClient theTests = new JSTLClient();
        Status s = theTests.run(args, new PrintWriter(System.out), 
                   new PrintWriter(System.err));
        s.exit();
    }

    /**
     * Entry point for same-VM execution. In different-VM execution, the 
     * main method delegates to this method.
     */
    public Status run(String args[], PrintWriter out, PrintWriter err) {

        setContextRoot("/jstl_core_gen_catch_web");
        setGoldenFileDir("/jstl/spec/core/general/catchtag");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveCatchTest
     * @assertion_ids: JSTL:SPEC:42.3
     * @testStrategy: Validate that the catch action, with no var
     *                attribute specified, will catch the Throwable
     *                and allow the page to continue processing.
     */
    public void positiveCatchTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveCatchTest");
        invoke();
    }

    /*
     * @testName: positiveCatchVarTest
     * @assertion_ids: JSTL:SPEC:42.1
     * @testStrategy: Validate that the catch action properly
     *                stores the Throable into the variable name
     *                designated by the var attribute and validate
     *                the type of var as it should be the type of
     *                the Throwable.
     */
    public void positiveCatchVarTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveCatchVarTest");
        invoke();
    }
}
