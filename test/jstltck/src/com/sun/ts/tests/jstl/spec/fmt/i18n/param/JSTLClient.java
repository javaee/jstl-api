/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/fmt/i18n/param/JSTLClient.java $ $LastChangedDate: 2007-09-20 15:51:00 -0400 (Thu, 20 Sep 2007) $
 */

package com.sun.ts.tests.jstl.spec.fmt.i18n.param;

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

        setContextRoot("/jstl_fmt_param_web");
        setGoldenFileDir("/jstl/spec/fmt/i18n/param");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveParamValueTest
     * @assertion_ids: JSTL:SPEC:25; JSTL:SPEC:25.2; JSTL:SPEC:25.2.1
     * @testStrategy: Validate that parametric replacement occurs
     *                when param subtags are specified with either
     *                dynamic or static values.
     */
    public void positiveParamValueTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "positiveParamValueTest");
        TEST_PROPS.setProperty(GOLDENFILE, "positiveParamValueTest.gf");
        TEST_PROPS.setProperty(REQUEST, "positiveParamValueTest.jsp");
        TEST_PROPS.setProperty(REQUEST_HEADERS, "Accept-Language: en");
        invoke();
    }

    /*
     * @testName: positiveParamValueBodyTest
     * @assertion_ids: JSTL:SPEC:25.5
     * @testStrategy: Validate that the value of the parameter can
     *                be provided as body content to the action.
     */
    public void positiveParamValueBodyTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "positiveParamValueBodyTest");
        TEST_PROPS.setProperty(GOLDENFILE, "positiveParamValueBodyTest.gf");
        TEST_PROPS.setProperty(REQUEST, "positiveParamValueBodyTest.jsp");
        TEST_PROPS.setProperty(REQUEST_HEADERS, "Accept-Language: en");
        invoke();
    }
}
