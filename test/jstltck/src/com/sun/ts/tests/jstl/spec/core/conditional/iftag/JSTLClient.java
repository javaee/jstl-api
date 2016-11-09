/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/core/conditional/iftag/JSTLClient.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.spec.core.conditional.iftag;

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

        setContextRoot("/jstl_core_cond_if_web");
        setGoldenFileDir("/jstl/spec/core/conditional/iftag");

        return super.run(args, out, err);
    }

    // XXX Add assertion regarding no body and exported var
    /*
     * @testName: positiveIfTest
     * @assertion_ids: JSTL:SPEC:14.2
     * @testStrategy: Verify 'test' and 'var' attribute behavior
     *                of the 'if' action with no content body
     */
    public void positiveIfTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveIfTest");
        invoke();
    }

     /*
      * @testName: positiveIfBodyBehaviorTest
      * @assertion_ids: JSTL:SPEC:14.1.1, JSTL:SPEC:14.1.2
      * @testStrategy: Verify the behavior of the 'if' action
      *                with regards to the result of it's test and
      *                it's body content
      */
    public void positiveIfBodyBehaviorTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveIfBodyBehaviorTest");
        invoke();
    }

    // XXX Add assertion regarding default scope
    /*
     * @testName: positiveIfScopeTest
     * @assertion_ids: JSTL:SPEC:14.3.1, JSTL:SPEC:14.3.2, JSTL:SPEC:14.3.3,
     *                 JSTL:SPEC:14.3.4, JSTL:SPEC:14.3.5
     * @testStrategy: Verify the behavior of the 'if' action when
     *                using the scope attribute.  If scope is not specified,
     *                the exported var should be in the page scope, otherwise
     *                the exported var should be in the designated scope.
     */
    public void positiveIfScopeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveIfScopeTest");
        invoke();
    }

    /*
     * @testName: positiveIfExportedVarTypeTest
     * @assertion_ids: JSTL:SPEC:14.2.1
     * @testStrategy: Validate that the variable exported by the 'if' action
     *                is of type 'java.lang.Boolean'
     */
    public void positiveIfExportedVarTypeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveIfExportedVarTypeTest");
        invoke();
    }

    /*
     * XXX FIX Assertion
     * @testName: negativeIfTestTypeTest
     * @assertion_ids: JSTL:SPEC:14.1.3
     * @testStrategy: Validate that an instance of
     *                javax.servlet.jsp.JspTagException is thrown if the
     *                resulting expression passed ot the 'test' attribute
     *                is not of the expected type (boolean/Boolean for EL, and
     *                boolean for RT).
     */
    public void negativeIfTestTypeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeIfTestTypeTest");
        invoke();
    }

    /*
     * @testName: negativeIfExcBodyContentTest
     * @assertion_ids: JSTL:SPEC:14.7
     * @testStrategy: Validate that exceptions caused by the body content
     *                are propagated.
     */
    public void negativeIfExcBodyContentTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeIfExcBodyContentTest");
        invoke();
    }
}
