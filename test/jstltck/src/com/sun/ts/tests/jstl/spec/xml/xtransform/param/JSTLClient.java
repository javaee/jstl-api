/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/xml/xtransform/param/JSTLClient.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.spec.xml.xtransform.param;

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

        setContextRoot("/jstl_xml_xformparam_web");
        setGoldenFileDir("/jstl/spec/xml/xtransform/param");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveXParamNameTest
     * @assertion_ids:
     * @testStrategy: Validate the name attribute of the x:param
     *                action is able to accept both static and
     *                dynamic values.
     */
    public void positiveXParamNameTest() throws Fault {
        //TEST_PROPS.setProperty(STANDARD, "positiveXParamNameTest");
        TEST_PROPS.setProperty(REQUEST, 
          "GET /jstl_xml_xformparam_web/positiveXParamNameTest.jsp HTTP/1.1");
        TEST_PROPS.setProperty(SEARCH_STRING, "10pt|Param properly used");
        TEST_PROPS.setProperty(UNEXPECTED_RESPONSE_MATCH, "REPLACE");
        invoke();
    }

    /*
     * @testName: positiveXParamValueTest
     * @assetion_ids:
     * @testStrategy: Validate the value attribute of the x:param
     *                action is able to accept both static and
     *                dynamic values.
     */
    public void positiveXParamValueTest() throws Fault {
        //TEST_PROPS.setProperty(STANDARD, "positiveXParamValueTest");
        TEST_PROPS.setProperty(REQUEST, 
          "GET /jstl_xml_xformparam_web/positiveXParamValueTest.jsp HTTP/1.1");
        TEST_PROPS.setProperty(SEARCH_STRING, "13pt|Param properly used");
        TEST_PROPS.setProperty(UNEXPECTED_RESPONSE_MATCH, "REPLACE");
        invoke();
    }

    /*
     * @testName: positiveXParamBodyValueTest
     * @assertion_ids:
     * @testStrategy: Validate the value of the param can be provided
     *                as body content to the action.
     */
    public void positiveXParamBodyValueTest() throws Fault {
        //TEST_PROPS.setProperty(STANDARD, "positiveXParamBodyValueTest");
        TEST_PROPS.setProperty(REQUEST, 
          "GET /jstl_xml_xformparam_web/positiveXParamBodyValueTest.jsp HTTP/1.1");
        TEST_PROPS.setProperty(SEARCH_STRING, "8pt|Param properly used");
        TEST_PROPS.setProperty(UNEXPECTED_RESPONSE_MATCH, "REPLACE");
        invoke();
    }

}
