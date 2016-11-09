/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/xml/xconditional/xif/JSTLClient.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.spec.xml.xconditional.xif;

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

        setContextRoot("/jstl_xml_xif_web");
        setGoldenFileDir("/jstl/spec/xml/xconditional/xif");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveIfSelectTest
     * @assertion_ids:
     * @testStrategy: Validate that, providing a valid XPath expression
     *                to the select attribute, will, depending on the result
     *                cause the <x:if> action to process its body content.
     */
    public void positiveIfSelectTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveIfSelectTest");
        invoke();
    }

    /*
     * @testName: positiveIfVarTest
     * @assertion_ids:
     * @testStrategy: Validate that the following:
     *                 - if var is present, the Boolean result of the
     *                   XPath evaluation is exported and available using
     *                   the name provided to var.
     *                 - if var is present, and the action has a body,
     *                   the body is still processed.
     */
    public void positiveIfVarTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveIfVarTest");
        invoke();
    }

    /*
     * @testName: positiveIfScopeTest
     * @assertion_ids:
     * @testStrategy: Validate that var is exported to the scope
     *                as specified by the scope attribute.  If scope
     *                is not specified, var will be exported to the page
     *                scope by default.
     */
    public void positiveIfScopeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveIfScopeTest");
        invoke();
    }

    /*
     * @testName: negativeIfInvalidScopeTest
     * @assertion_ids:
     * @testStrategy: Validate that if scope is provided an invalid
     *                value, a fatal translation error occurs.
     */
    public void negativeIfInvalidScopeTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "negativeIfInvalidScopeTest");
        TEST_PROPS.setProperty(REQUEST, "negativeIfInvalidScopeTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }

    /*
     * @testName: negativeIfSelectReqAttrTest
     * @assertion_ids:
     * @testStrategy: Validate that 'select' is indeed a required attribute
     *                by having an <x:if> action with no select.  A fatal
     *                translation error should occur.
     */
    public void negativeIfSelectReqAttrTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "negativeIfSelectReqAttrTest");
        TEST_PROPS.setProperty(REQUEST, "negativeIfSelectReqAttrTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }

    /*
     * @testName: negativeIfScopeVarTest
     * @assertion_ids:
     * @testStrategy: Validate a fatal translation error occurs if
     *                scope is specified by an action, but var is not.
     */
    public void negativeIfScopeVarTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "negativeIfScopeVarTest");
        TEST_PROPS.setProperty(REQUEST, "negativeIfScopeVarTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }

    /*
     * @testName: negativeIfSelectFailureTest
     * @assertion_ids:
     * @testStrategy: Validate that an instance of javax.servlet.jsp.JspException
     *                is thrown if the XPath expression provided to the
     *                select attribute fails to evaluate.
     */
    public void negativeIfSelectFailureTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeIfSelectFailureTest");
        invoke();
    }
}
