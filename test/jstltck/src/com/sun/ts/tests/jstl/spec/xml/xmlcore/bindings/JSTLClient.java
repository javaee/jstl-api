/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/xml/xmlcore/bindings/JSTLClient.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.spec.xml.xmlcore.bindings;

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

        setContextRoot("/jstl_xml_bindings_web");
        setGoldenFileDir("/jstl/spec/xml/xmlcore/bindings");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveXPathVariableBindingsTest
     * @assertion_ids:
     * @testStrategy: Validate the following bindings are available:
     *
     *       $foo - pageContext.findAttribute("foo")
     *       $param.foo - request.getParameter("foo")
     *       $header:foo - request.getHeader("foo")
     *       $initParam:foo - application.getInitParamter("foo")
     *       $cooke:foo - maps to the cookies value for name foo
     *       $pageScope:foo - pageContext.getAttribute("foo", PageContext.PAGE_SCOPE)
     *       $requestScope:foo - pageContext.getAttribute("foo", PageContext.REQUEST_SCOPE)
     *       $sessionScope:foo - pageContext.getAttribute("foo", PageContext.SESSION_SCOPE)
     *       $applicationScope:foo - pageContext.getAttribute("foo", PageContext.APPLICATION_SCOPE)
     */
    public void positiveXPathVariableBindingsTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "positiveXPathVariableBindingsTest");
        TEST_PROPS.setProperty(REQUEST, "positiveXPathVariableBindingsTest.jsp?param1=RequestParameter1");
        TEST_PROPS.setProperty(REQUEST_HEADERS, "reqheader:RequestHeader|Cookie: $Version=1; mycookie=CookieFound; $Domain=" + _hostname + "; $Path=/jstl_xml_bindings_web");
        TEST_PROPS.setProperty(GOLDENFILE, "positiveXPathVariableBindingsTest.gf");
        invoke();
    }
}
