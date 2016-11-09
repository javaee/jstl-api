/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/fmt/i18n/responseencoding/JSTLClient.java $ $LastChangedDate: 2007-09-25 16:19:33 -0400 (Tue, 25 Sep 2007) $
 */

package com.sun.ts.tests.jstl.spec.fmt.i18n.responseencoding;

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

        setContextRoot("/jstl_fmt_resenc_web");
        setGoldenFileDir("/jstl/spec/fmt/i18n/responseencoding");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveResponseEncodingTest
     * @assertion_ids: JSTL:SPEC:27 
     * @testStrategy: Validate that actions that establish an I18N
     *                localization context properly call
     *                ServletResponse.setLocale().
     *                Actions that do this are:
     *                   <fmt:setLocale>
     *                   <fmt:message>
     *                   <fmt:bundle>
     *                   <fmt:setBundle>
     */
    public void positiveResponseEncodingTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "positiveResponseEncodingTest");
        TEST_PROPS.setProperty(REQUEST, "positiveResponseEncodingTest.jsp?action=locale&type=rt");
        TEST_PROPS.setProperty(EXPECTED_HEADERS, "setlocale: en");
        invoke();
        TEST_PROPS.setProperty(TEST_NAME, "positiveResponseEncodingTest");
        TEST_PROPS.setProperty(REQUEST, "positiveResponseEncodingTest.jsp?action=bundle&type=rt");
        TEST_PROPS.setProperty(REQUEST_HEADERS, "Accept-Language: en");
        TEST_PROPS.setProperty(EXPECTED_HEADERS, "setlocale: en");
        invoke();
        TEST_PROPS.setProperty(TEST_NAME, "positiveResponseEncodingTest");
        TEST_PROPS.setProperty(REQUEST, "positiveResponseEncodingTest.jsp?action=setbundle&type=rt");
        TEST_PROPS.setProperty(REQUEST_HEADERS, "Accept-Language: en");
        TEST_PROPS.setProperty(EXPECTED_HEADERS, "setlocale: en");
        invoke();
        TEST_PROPS.setProperty(TEST_NAME, "positiveResponseEncodingTest");
        TEST_PROPS.setProperty(REQUEST, "positiveResponseEncodingTest.jsp?action=message&type=rt");
        TEST_PROPS.setProperty(EXPECTED_HEADERS, "setlocale: en");
        invoke();
    }

    /*
     * @testName: positiveResponseSetCharEncodingAttrTest
     * @assertion_ids: JSTL:SPEC:27.1
     * @testStrategy: Validate that the actions that initialize an I18N
     *                localization context properly sets
     *                javax.servlet.jsp.jstl.fmt.request.charset session
     *                attribute.
     *                Actions that do this are:
     *                   <fmt:setLocale>
     *                   <fmt:message>
     *                   <fmt:bundle>
     *                   <fmt:setBundle>
     */
    public void positiveResponseSetCharEncodingAttrTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "positiveResponseSetCharEncodingAttrTest");
        TEST_PROPS.setProperty(REQUEST, "positiveResponseSetCharEncodingAttrTest.jsp?action=locale");
        TEST_PROPS.setProperty(EXPECTED_HEADERS, "charset: attribute set|charencoding: called");
        invoke();
        TEST_PROPS.setProperty(TEST_NAME, "positiveResponseSetCharEncodingAttrTest");
        TEST_PROPS.setProperty(REQUEST, "positiveResponseSetCharEncodingAttrTest.jsp?action=bundle");
        TEST_PROPS.setProperty(REQUEST_HEADERS, "Accept-Language: en");
        TEST_PROPS.setProperty(EXPECTED_HEADERS, "charset: attribute set|charencoding: called");
        invoke();
        TEST_PROPS.setProperty(TEST_NAME, "positiveResponseSetCharEncodingAttrTest");
        TEST_PROPS.setProperty(REQUEST, "positiveResponseSetCharEncodingAttrTest.jsp?action=setbundle");
        TEST_PROPS.setProperty(REQUEST_HEADERS, "Accept-Language: en");
        TEST_PROPS.setProperty(EXPECTED_HEADERS, "charset: attribute set|charencoding: called");
        invoke();
        TEST_PROPS.setProperty(TEST_NAME, "positiveResponseSetCharEncodingAttrTest");
        TEST_PROPS.setProperty(REQUEST, "positiveResponseSetCharEncodingAttrTest.jsp?action=message");
        TEST_PROPS.setProperty(EXPECTED_HEADERS, "charset: attribute set|charencoding: called");
        invoke();
    }
}
