/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/xml/xmlcore/types/JSTLClient.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.spec.xml.xmlcore.types;

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
        
        setContextRoot("/jstl_xml_types_web");
        setGoldenFileDir("/jstl/spec/xml/xmlcore/types");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveJavaToXPathTypesTest
     * @assertion_ids:
     * @testStrategy: Validate that XPath variables of Java types,
     *                can be properly used in XPath expressions.
     *                The supported type mappings are:
     *                Java                    XPath
     *               java.lang.Boolean       boolean
     *               java.lang.Number        number
     *               java.lang.String        string
     *               Object exported by
     *               parse, set, or forEach  node-set
     */
    public void positiveJavaToXPathTypesTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveJavaToXPathTypesTest");
        invoke();
    }

    /*
     * @testName: positiveXPathToJavaTypesTest
     * @assertion_ids:
     * @testStrategy: Validate that the result of an XPath expression
     *                yeilds the correct type based of the specified
     *                XPath to Java type mapping:
     *                XPath                Java
     *               boolean              java.lang.Boolean
     *               number               java.lang.Number
     *               string               java.lang.String
     *               node-set             Implementation specified
     *                                    (test will check for
     *                                     java.lang.Object)
     */
    public void positiveXPathToJavaTypesTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveXPathToJavaTypesTest");
        invoke();
    }

}
