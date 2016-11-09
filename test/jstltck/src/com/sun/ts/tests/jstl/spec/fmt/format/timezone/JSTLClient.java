/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/fmt/format/timezone/JSTLClient.java $ $LastChangedDate: 2007-09-18 12:31:23 -0400 (Tue, 18 Sep 2007) $
 */

package com.sun.ts.tests.jstl.spec.fmt.format.timezone;

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

        setContextRoot("/jstl_fmt_tz_web");
        setGoldenFileDir("/jstl/spec/fmt/format/timezone");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveTimezoneValueTest
     * @assertion_ids: JSTL:SPEC:54; JSTL:SPEC:54.1; JSTL:SPEC:54.1.1;  
     *                 JSTL:SPEC:54.1.2; JSTL:SPEC:54.1.3
     * @testStrategy: Validate that the value attribute can accept both
     *                static values as well as three letter timezones (ex.
     *                PST) or fully qualified values (ex. America/Los_Angeles).
     */
    public void positiveTimezoneValueTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveTimezoneValueTest");
        TEST_PROPS.setProperty(REQUEST_HEADERS, "Accept-Language: en");
        invoke();
    }

    /*
     * @testName: positiveTimezoneValueNullEmptyTest
     * @assertion_ids: JSTL:SPEC:54.7
     * @testStrategy: Validate that if the value attribute is null or emtpy,
     *                the GMT+0 timezone is used by the formatting actions
     *                that rely on timezone.
     */
    public void positiveTimezoneValueNullEmptyTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveTimezoneValueNullEmptyTest");
        TEST_PROPS.setProperty(REQUEST_HEADERS, "Accept-Language: en");
        invoke();
    }
}
