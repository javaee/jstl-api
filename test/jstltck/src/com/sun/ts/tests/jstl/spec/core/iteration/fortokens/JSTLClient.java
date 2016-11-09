/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/core/iteration/fortokens/JSTLClient.java $ $LastChangedDate: 2007-07-02 16:00:41 -0400 (Mon, 02 Jul 2007) $
 */

package com.sun.ts.tests.jstl.spec.core.iteration.fortokens;

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

        setContextRoot("/jstl_core_iter_fortok_web");
        setGoldenFileDir("/jstl/spec/core/iteration/fortokens");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveForTokensTest
     * @assertion_ids: JSTL:SPEC:22; JSTL:SPEC:22.1; JSTL:SPEC:22.2; JSTL:SPEC:22.3
     * @testStrategy: Validate that forTokens can properly
     *                Iterate over a String provided with
     *                specified delimiters.
     */
    public void positiveForTokensTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveForTokensTest");
        invoke();
    }

    /*
     * @testName: positiveVarStatusTest
     * @assertion_ids: JSTL:SPEC:22.4; JSTL:SPEC:22.4.1 
     * @testStrategy: Validate that when varStatus is specified
     *                that the exported var name is of type
     *                javax.servlet.jsp.jstl.LoopTagStatus
     */
    public void positiveVarStatusTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveVarStatusTest");
        invoke();
    }

    /*
     * @testName: positiveBeginTest
     * @assertion_ids: JSTL:SPEC:22.5
     * @testStrategy: Validate that 'begin' starts in the proper
     *                location of the tokens created from the
     *                passed String.
     */
    public void positiveBeginTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveBeginTest");
        invoke();
    }

    /*
     * @testName: positiveEndTest
     * @assertion_ids: JSTL:SPEC:22.6
     * @testStrategy: Validate that when 'end' is specified, that
     *                the action stops processing once it reaches
     *                the appropriate token in the list.
     */
    public void positiveEndTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveEndTest");
        invoke();
    }

    /*
     * @testName: positiveStepTest
     * @assertion_ids: JSTL:SPEC:22.7
     * @testStrategy: Validate that when 'step' is specified,
     *                the action only processes every 'step'
     *                tokens.
     */
    public void positiveStepTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveStepTest");
        invoke();
    }

    /*
     * @testName: positiveBodyBehaviorTest
     * @assertion_ids: JSTL:SPEC:22.8
     * @testStrategy: Validate that the 'forEach' action can
     *                handle bodies containing content as well
     *                as empty bodies.
     */
    public void positiveBodyBehaviorTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveBodyBehaviorTest");
        invoke();
    }

    /*
     * @testName: positiveItemsNullTest
     * @assertion_ids: JSTL:SPEC:22.15
     * @testStrategy: Validate that if items is null, no iteration
     *                is performed.
     */
    public void positiveItemsNullTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveItemsNullTest");
        invoke();
    }

    /*
     * @testName: positiveDelimsNullTest
     * @assertion_ids: JSTL:SPEC:22.16
     * @testStrategy: Validate that if delims is null, items is treated
     *                as a single token, i.e, only one iteration is
     *                performed.
     */
    public void positiveDelimsNullTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveDelimsNullTest");
        invoke();
    }

    /*
     * @testName: positiveItemsDelimsNullTest
     * @assertion_ids: JSTL:SPEC:22.15
     * @testStrategy: Validate that if both delims and items is null,
     *                no iteration is performed.
     */
    public void positiveItemsDelimsNullTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveItemsDelimsNullTest");
        invoke();
    }

    /*
     * @testName: negativeFTBeginTypeTest
     * @assertion_ids: JSTL:SPEC:22.5.3
     * @testStrategy: Validate that a javax.servlet.jsp.JspException is thrown
     *                if the EL expression passed to begin evaluates to
     *                an incorrect type.
     */
    public void negativeFTBeginTypeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeFTBeginTypeTest");
        invoke();
    }

    /*
     * @testName: negativeFTEndTypeTest
     * @assertion_ids: JSTL:SPEC:22.6.2
     * @testStrategy: Validate that a javax.servlet.jsp.JspException is thrown
     *                if the EL expression passed to end evaluates to
     *                an incorrect type.
     */
    public void negativeFTEndTypeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeFTEndTypeTest");
        invoke();
    }

    /*
     * @testName: negativeFTStepTypeTest
     * @assertion_ids: JSTL:SPEC:22.7.2
     * @testStrategy: Validate that a javax.servlet.jsp.JspException is thrown
     *                if the EL expression passed to step evaluates to
     *                an incorrect type.
     */
    public void negativeFTStepTypeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeFTStepTypeTest");
        invoke();
    }

    /*
     * @testName: negativeFTExcBodyContentTest
     * @assertion_ids: JSTL:SPEC:22.17
     * @testStrategy: Validate that an exception caused by the actions's
     *                body content is properly propagated.
     */
    public void negativeFTExcBodyContentTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeFTExcBodyContentTest");
        invoke();
    }

    /*
     * @testName: positiveForTokensEndLTBeginTest
     * @assertion_ids: JSTL:SPEC:22.18
     * @test_Strategy: Validate an end attribute value that is less than
     *                 the begin attribute value will result in the action
     *                 not being executed.
     */
    public void positiveForTokensEndLTBeginTest() throws Fault {
        TEST_PROPS.setProperty(REQUEST,
            "GET /jstl_core_iter_fortok_web/positiveForTokensEndLTBeginTest.jsp HTTP/1.1");
        TEST_PROPS.setProperty(UNEXPECTED_RESPONSE_MATCH, "Test FAILED");
        invoke();
    }

    /*
     * @testName: positiveForTokensDeferredValueTest
     * @assertion_ids: JSTL:SPEC:22.19
     * @test_Strategy: Create a String containing several tokens.
     *                 In a c:forTokens tag, reference the String as a deferred value 
     *                 in the items attribute.  In the body of the tag, set each 
     *                 item to have application scope. Verify that the items can be 
     *                 retrieved after the execution of the tag.
     */
    public void positiveForTokensDeferredValueTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveForTokensDeferredValueTest");
        invoke();
    }
}
