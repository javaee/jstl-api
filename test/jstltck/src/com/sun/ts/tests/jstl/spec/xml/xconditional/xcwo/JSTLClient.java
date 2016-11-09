/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/xml/xconditional/xcwo/JSTLClient.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.spec.xml.xconditional.xcwo;

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

        setContextRoot("/jstl_xml_xcwo_web");
        setGoldenFileDir("/jstl/spec/xml/xconditional/xcwo");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveCWOTest
     * @assertion_ids:
     * @testStrategy: Validate the following:
     *                 - The first when action that evaluates to true
     *                   will process it's body content.  Subsequent when
     *                   action that evaluate to true will not be processed.
     *                 - Validate that if a when action evaluates to true,
     *                   it's body content is processed and that the body
     *                   content of an otherwise action is not.
     *                 - Validate that if no when action evaluates to true,
     *                   and no otherwise action is present, nothing is written
     *                   to the current JspWriter.
     *                 - Validate that if no when action evaluates to true,
     *                   and an otherwise action is present, the body content
     *                   of the action is processed.
     */
    public void positiveCWOTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveCWOTest");
        invoke();
    }

    /*
     * @testName: positiveCWOWhiteSpaceTest
     * @assertion_ids:
     * @testStrategy: Validate that the CWO action behaves as expected if
     *                whitespace is intermixed with choose's nested when
     *                and otherwise actions.  No tranlsation error should occur.
     */
    public void positiveCWOWhiteSpaceTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveCWOWhiteSpaceTest");
        invoke();
    }

    /*
     * @testName: negativeCWONoWhenActionsTest
     * @assertion_ids:
     * @testStrategy: Validate that a fatal translation error occurs if
     *                the choose action has no nested when actions.
     */
    public void negativeCWONoWhenActionsTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "negativeCWONoWhenActionsTest");
        TEST_PROPS.setProperty(REQUEST, "negativeCWONoWhenActionsTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }

    /*
     * @testName: negativeCWOWhenBeforeOtherwiseTest
     * @assertion_ids:
     * @testStrategy: Validate that a fatal translation error occurs if
     *                otherwise appears before when or if when appears
     *                after otherwise.
     */
    public void negativeCWOWhenBeforeOtherwiseTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "negativeCWOWhenBeforeOtherwiseTest");
        TEST_PROPS.setProperty(REQUEST, "negativeCWOWhenBeforeOtherwiseTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }

    /*
     * @testName: negativeCWOWhenNoParentTest
     * @assertion_ids:
     * @testStrategy: Validate a fatal translation error occurs if
     *                a when action has no choose as an immediate parent.
     */
    public void negativeCWOWhenNoParentTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "negativeCWOWhenNoParentTest");
        TEST_PROPS.setProperty(REQUEST, "negativeCWOWhenNoParentTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }

    /*
     * @testName: negativeCWOOtherwiseNoParentTest
     * @assertion_ids:
     * @testStrategy: Validate a fatal translation error occurs if
     *                an otherwise action has no choose as an immediate parent.
     */
    public void negativeCWOOtherwiseNoParentTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "negativeCWOOtherwiseNoParentTest");
        TEST_PROPS.setProperty(REQUEST, "negativeCWOOtherwiseNoParentTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }

    /*
     * @testName: negativeCWOWhenSelectReqAttrTest
     * @assertion_ids:
     * @testStrategy: Validate that a fatal translation error occurs
     *                if a nested when action has no select attribute.
     */
    public void negativeCWOWhenSelectReqAttrTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "negativeCWOWhenSelectReqAttrTest");
        TEST_PROPS.setProperty(REQUEST, "negativeCWOWhenSelectReqAttrTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }

    /*
     * @testName: negativeCWOWhenSelectFailureTest
     * @assertion_ids:
     * @testStrategy: Validate that if the XPath expression provided
     *                to select of the when action fails to evaluated
     *                an instance of javax.servlet.jsp.JspException is
     *                thrown.
     */
    public void negativeCWOWhenSelectFailureTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeCWOWhenSelectFailureTest");
        invoke();
    }
}
