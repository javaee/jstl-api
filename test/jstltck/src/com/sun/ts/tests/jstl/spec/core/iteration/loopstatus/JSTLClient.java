/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/core/iteration/loopstatus/JSTLClient.java $ $LastChangedDate: 2007-08-02 22:46:26 -0400 (Thu, 02 Aug 2007) $
 */

package com.sun.ts.tests.jstl.spec.core.iteration.loopstatus;

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

        setContextRoot("/jstl_core_iter_lstat_web");
        setGoldenFileDir("/jstl/spec/core/iteration/loopstatus");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveLoopTagStatusTest
     * @assertion_ids: JSTL:SPEC:21.4.1
     * @testStrategy: Validate behavior of LoopStatusTag during
     *                an iteration through an array.
     */
    public void positiveLoopTagStatusTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveLoopTagStatusTest");
        invoke();
    }
}
