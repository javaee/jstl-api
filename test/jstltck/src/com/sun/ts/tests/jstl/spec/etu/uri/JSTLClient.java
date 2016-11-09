/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/etu/uri/JSTLClient.java $ $LastChangedDate: 2007-04-19 17:46:50 -0400 (Thu, 19 Apr 2007) $
 */

package com.sun.ts.tests.jstl.spec.etu.uri;

import java.io.PrintWriter;
import com.sun.javatest.Status;
import com.sun.ts.lib.harness.EETest.Fault;
import com.sun.ts.tests.jstl.common.client.AbstractUrlClient;

public class JSTLClient extends AbstractUrlClient {

    /*
     * @class.setup_props: webServerHost; webServerPort; ts_home;
     */

    /** Creates new URLClient */
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

        setContextRoot("/jstl_etu_uri_web");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveJSTLURITest
     * @assertion_ids: JSTL:SPEC:1,JSTL:SPEC:2,JSTL:SPEC:3,JSTL:SPEC:4,
     *                 JSTL:SPEC:16,JSTL:SPEC:17,JSTL:SPEC:18,JSTL:SPEC:19
     * @testStrategy: Import all defined taglib URI definitions for both
     *                EL and RT tags.  If defined correctly, a fatal
     *                translation error should not occur ( per section
     *                7.3.6.2 of the JavaServer Pages 1.2 Specification.
     */
    public void positiveJSTLURITest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "positiveJSTLURITest");
        TEST_PROPS.setProperty(REQUEST, "positiveJSTLURITest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, OK);
	invoke();
    }
}
