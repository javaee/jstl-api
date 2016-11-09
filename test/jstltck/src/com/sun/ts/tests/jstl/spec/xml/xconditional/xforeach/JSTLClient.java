/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/xml/xconditional/xforeach/JSTLClient.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.spec.xml.xconditional.xforeach;

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

        setContextRoot("/jstl_xml_xforeach_web");
        setGoldenFileDir("/jstl/spec/xml/xconditional/xforeach");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveForEachSelectTest
     * @assertion_ids:
     * @testStrategy: Validate that the forEach action can properly
     *                iterate through a node-set returned by the
     *                evaluated of the XPath expression provided.
     */
    public void positiveForEachSelectTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveForEachSelectTest");
        invoke();
    }

    /*
     * @testName: positiveForEachVarTest
     * @assertion_ids:
     * @testStrategy: Validate the following:
     *                 - The variable specified by var is treated as nested.
     *                 - The type of var is a node-set therfore validate
     *                   that it is an instance of java.lang.Object.
     *                 - Validate that var is available within the body
     *                   of the forEach action.
     */
    public void positiveForEachVarTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveForEachVarTest");
        invoke();
    }

    /*
     * @testName: negativeForEachSelectReqAttrTest
     * @assertion_ids:
     * @testStrategy: Validate that a fatal translation error occurs if
     *                the select attribute is not present.
     */
    public void negativeForEachSelectReqAttrTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "negativeForEachSelectReqAttrTest");
        TEST_PROPS.setProperty(REQUEST, "negativeForEachSelectReqAttrTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }

    /*
     * @testName: negativeForEachSelectFailureTest
     * @assertion_ids:
     * @testStrategy: Validate that an instance of javax.servlet.jsp.JspException
     *                is thrown if the XPath expression provided to the select
     *                attribute fails to evaluated.
     */
    public void negativeForEachSelectFailureTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeForEachSelectFailureTest");
        invoke();
    }

    /*
     * @testName: positiveForEachBeginTest
     * @assertion_ids:
     * @test_Strategy: Validate the behavior of x:forEach when the begin
     *                 attribute is specified.
     */
    public void positiveForEachBeginTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveForEachBeginTest");
        invoke();
    }

    /*
     * @testName: positiveForEachEndTest
     * @assertion_ids:
     * @test_Strategy: Validate the behavior of x:forEach when the end
     *                 attribute is specified.
     */
    public void positiveForEachEndTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveForEachEndTest");
        invoke();
    }

    /*
     * @testName: positiveForEachStepTest
     * @assertion_ids:
     * @test_Strategy: Validate the behavior of the x:forEach action when
     *                 the step attribute is not specified.
     */
    public void positiveForEachStepTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveForEachStepTest");
        invoke();
    }

    /*
     * @testName: positiveForEachVarStatusTest
     * @assertion_ids:
     * @test_Strategy: Validate the action properly exports a VarStatus
     *                 object on each iteration when the varStatus attribute
     *                 is specified.
     */
    public void positiveForEachVarStatusTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveForEachVarStatusTest");
        invoke();
    }

    /*
     * @testName: positiveForEachEndLTBeginTest
     * @assertion_ids:
     * @test_Strategy: Validate that no iteration occurs of the end attribute
     *                 value is less than the value of the begin attribute.
     */
    public void positiveForEachEndLTBeginTest() throws Fault {
        TEST_PROPS.setProperty(REQUEST, 
            "GET /jstl_xml_xforeach_web/positiveForEachEndLTBeginTest.jsp HTTP/1.1");
        TEST_PROPS.setProperty(UNEXPECTED_RESPONSE_MATCH, "Test FAILED");
        invoke();
    }
}
