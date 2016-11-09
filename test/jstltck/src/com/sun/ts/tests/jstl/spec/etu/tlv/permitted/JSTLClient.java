/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/etu/tlv/permitted/JSTLClient.java $ $LastChangedDate: 2007-08-10 18:23:38 -0400 (Fri, 10 Aug 2007) $
 */

package com.sun.ts.tests.jstl.spec.etu.tlv.permitted;

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

        setContextRoot("/jstl_etu_tlv_perm_web");
        setGoldenFileDir("/jstl/spec/etu/tlv/permitted");

        return super.run(args, out, err);
    }

    /*
     * @testName: positivePermittedTlvTest
     * @assertion_ids: JSTL:SPEC:103; JSTL:SPEC:103.1
     * @testStrategy: Validate that if a URI that refers to a specific
     *                set of libraries is specified as a parameter to the
     *                PermittedTaglibsTLV, that the use of this library
     *                doesn't generate a translation error.
     */
    public void positivePermittedTlvTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "positivePermittedTlvTest");
        TEST_PROPS.setProperty(REQUEST, "positivePermittedTlvTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, OK);
        invoke();
    }

    /*
     * @testName: negativePermittedTlvTest
     * @assertion_ids: JSTL:SPEC:103; JSTL:SPEC:103.1
     * @testStrategy: Validate that if a URI that refers to a specific
     *                set of libraries is not specified as a parameter to the
     *                PermittedTaglibsTLV, that the use of this library
     *                generates a translation error.
     */
    public void negativePermittedTlvTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "negativePermittedTlvTest");
        TEST_PROPS.setProperty(REQUEST, "negativePermittedTlvTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }
}
