/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/xml/xmlcore/xout/JSTLClient.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.spec.xml.xmlcore.xout;

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

        setContextRoot("/jstl_xml_xout_web");
        setGoldenFileDir("/jstl/spec/xml/xmlcore/xout");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveOutSelectTest
     * @assertion_ids:
     * @testStrategy: Validate that the action properly displays
     *                the result of an XPath expression provided
     *                to the select attribute.
     */
    public void positiveOutSelectTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveOutSelectTest");
        invoke();
    }

    /*
     * @testName: positiveOutEscXmlTest
     * @assertion_ids:
     * @testStrategy: Validate that the escaping of XML entities (<,>,&,',")
     *                will occur if the escapeXml is not present, or the value
     *                is true.  Also validate that no escaping occurs if the
     *                value is false.
     */
    public void positiveOutEscXmlTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveOutEscXmlTest");
        invoke();
    }

    /*
     * @testName: negativeOutSelectFailureTest
     * @assertions_ids:
     * @testStrategy: Validate that a javax.servlet.jsp.JspException is
     *                thrown if the expression language fails to evaluate
     *                the provided XPath expression.
     */
    public void negativeOutSelectFailureTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeOutSelectFailureTest");
        invoke();
    }

    /*
     * @testName: negativeOutSelectReqAttrTest
     * @assertion_ids:
     * @testStrategy: Validate that a fatal translation error is generated
     *                if the select attribute is not present in the out action.
     */
    public void negativeOutSelectReqAttrTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "negativeOutSelectReqAttrTest");
        TEST_PROPS.setProperty(REQUEST, "negativeOutSelectReqAttrTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }
}
