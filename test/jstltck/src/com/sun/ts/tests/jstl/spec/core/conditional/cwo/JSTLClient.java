/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/core/conditional/cwo/JSTLClient.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.spec.core.conditional.cwo;

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

        setContextRoot("/jstl_core_cond_cwo_web");
        setGoldenFileDir("/jstl/spec/core/conditional/cwo");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveCWOTest
     * @assertion_ids: JSTL:SPEC:15.1.1, JSTL:SPEC:15.1.1.1, JSTL:SPEC:15.1.1.2,
     *                 JSTL:SPEC:15.2, JSTL:SPEC:15.2.1
     * @testStrategy: Validate the behavior/interaction of 'choose', 'when'
     *                'otherwise' actions.
     *                - single 'when' action evaluating to true
     *                - one 'when' action evaluating to false and
     *                  two 'when' actions evaluating to true.  Only
     *                  the first when that evaluates to true should process
     *                  it's body content
     *                - single 'when' evaluating to false which should cause
     *                  the 'otherwise' action to process its body
     */
    public void positiveCWOTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveCWOTest");
        invoke();
    }

    /*
     * @testName: negativeCWOWhenTypeTest
     * @assertion_ids: JSTL:SPEC:15.1.1.2.1
     * @testStrategy: Validate that the tag throws an instance
     *                of javax.servlet.jsp.JspTagException if the
     *                expression evaluates to a type not expected
     *                by the tag.
     */
    public void negativeCWOWhenTypeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeCWOWhenTypeTest");
        invoke();
    }

    /*
     * @testName: negativeCWOWhenExcBodyContentTest
     * @assertion_ids: JSTL:SPEC:15.2.1.6
     * @testStrategy: Validate that an exception caused by the
     *                body content of a when action is properly
     *                propagated to and by the choose action.
     */
    public void negativeCWOWhenExcBodyContentTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeCWOWhenExcBodyContentTest");
        invoke();
    }

    /*
     * @testName: negativeCWOOtherwiseExcBodyContentTest
     * @assertion_ids: JSTL:SPEC:15.3.4
     * @testStrategy: Validate that an exception caused by the body
     *                content of an otherwise action is properly
     *                propagaged to and by the choose action.
     */
    public void negativeCWOOtherwiseExcBodyContentTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeCWOOtherwiseExcBodyContentTest");
        invoke();
    }

    /*
     * @testName: negativeCWONoWhenActionsTest
     * @assertion_ids: JSTL:SPEC:15.1.1.2
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
     * @assertion_ids: JSTL:SPEC:15.2.1.5
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
     * @assertion_ids: JSTL:SPEC:15.2.1.4
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
     * @assertion_ids: JSTL:SPEC:15.3.2
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
     * @testName: negativeCWOWhenTestReqAttrTest
     * @assertion_ids: JSTL:SPEC:15.2.1.3
     * @testStrategy: Validate that a fatal translation error occurs
     *                if a nested when action has no 'test' attribute.
     */
    public void negativeCWOWhenTestReqAttrTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "negativeCWOWhenTestReqAttrTest");
        TEST_PROPS.setProperty(REQUEST, "negativeCWOWhenTestReqAttrTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }
}
