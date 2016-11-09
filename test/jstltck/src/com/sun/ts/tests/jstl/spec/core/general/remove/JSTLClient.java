/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/core/general/remove/JSTLClient.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.spec.core.general.remove;

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
       
        setContextRoot("/jstl_core_gen_rem_web");
        setGoldenFileDir("/jstl/spec/core/general/remove");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveRemoveScopeVarTest
     * @assertion_ids: JSTL:SPEC:41.1; JSTL:SPEC:41.2; JSTL:SPEC:41.3
     * @testStrategy: Validate that the remove action can properly
     *                remove a scoped attribute by providing only
     *                a value to the var attribute.  This should
     *                remove the attribute no matter the scope in which
     *                it exists.  Also validate that if scope is specified,
     *                the var is properly removed.
     */
    public void positiveRemoveScopeVarTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveRemoveScopeVarTest");
        invoke();
    }
}
