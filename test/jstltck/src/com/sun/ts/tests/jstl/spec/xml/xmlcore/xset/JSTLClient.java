/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/xml/xmlcore/xset/JSTLClient.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.spec.xml.xmlcore.xset;

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
        
        setContextRoot("/jstl_xml_xset_web");
        setGoldenFileDir("/jstl/spec/xml/xmlcore/xset");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveSetSelectVarTest
     * @assertion_ids:
     * @testStrategy: Validate the action properly sets
     *                a scoped variable when select is provided
     *                a valid XPath expression and the the variable
     *                reference by var is available to another action.
     */
    public void positiveSetSelectVarTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveSetSelectVarTest");
        invoke();
    }

    /*
     * @testName: positiveSetScopeTest
     * @assertions_ids:
     * @testStrategy: Validate that the presense of the scope attribute
     *                properly exports var to the specified scope.  Also
     *                verify that if scope is not specified, that var is
     *                exported to the page scope by default.
     */
    public void positiveSetScopeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveSetScopeTest");
        invoke();
    }

    /*
     * @testName: negativeSetSelectFailureTest
     * @assertion_ids:
     * @testStrategy: Validate that if the XPath expression fails to evaluate
     *                an instance of javax.servet.jsp.JspException is thrown.
     */
    public void negativeSetSelectFailureTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeSetSelectFailureTest");
        invoke();
    }

    /*
     * @testName: negativeSetVarReqAttrTest
     * @assertion_ids:
     * @testStrategy: Validate that a fatal translation error occurs if
     *                the var attribute is not present.
     */
    public void negativeSetVarReqAttrTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "negativeSetVarReqAttrTest");
        TEST_PROPS.setProperty(REQUEST, "negativeSetVarReqAttrTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }

    /*
     * @testName: negativeSetSelectReqAttrTest
     * @assertion_ids:
     * @testStrategy: Validate that a fatal translation error occurs if
     *                the select attribute is not present.
     */
    public void negativeSetSelectReqAttrTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "negativeSetSelectReqAttrTest");
        TEST_PROPS.setProperty(REQUEST, "negativeSetSelectReqAttrTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }

    /*
     * @testName: negativeSetInvalidScopeTest
     * @assertion_ids:
     * @testStrategy: Validate that a fatal translation error occurs if
     *                the select attribute is not present.
     */
    public void negativeSetInvalidScopeTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "negativeSetInvalidScopeTest");
        TEST_PROPS.setProperty(REQUEST, "negativeSetInvalidScopeTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }

}
