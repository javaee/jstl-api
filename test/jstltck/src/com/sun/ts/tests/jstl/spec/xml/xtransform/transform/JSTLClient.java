/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/xml/xtransform/transform/JSTLClient.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.spec.xml.xtransform.transform;

import java.io.PrintWriter;
import com.sun.javatest.Status;
import com.sun.ts.lib.harness.EETest.Fault;
import com.sun.ts.tests.jstl.common.client.AbstractUrlClient;

public class JSTLClient extends AbstractUrlClient {

    private static String CONTEXT_ROOT = "/jstl_xml_xform_web";
    
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

        setContextRoot(CONTEXT_ROOT);
        setGoldenFileDir("/jstl/spec/xml/xtransform/transform");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveTransformXmlInputTest
     * @assertion_ids:
     * @testStrategy: Validate the transform action is able
     *                to accept XML input from the following sources:
     *                 - String
     *                 - Reader
     *                 - javax.xml.transform.Source
     *                 - Objects exported by:
     *                    + x:parse
     *                    + x:set
     *                    + x:transform
     */
    public void positiveTransformXmlInputTest() throws Fault {
        String testName = "positiveTransformXmlInputTest";
        TEST_PROPS.setProperty(REQUEST, "GET " + CONTEXT_ROOT +
               "/" + testName + ".jsp HTTP/1.1");
        TEST_PROPS.setProperty(SEARCH_STRING, 
                "Input from String:|" +
                "<h4>|Arbitrary Text|</h4>|" + 
                "<h4>|D Text|</h4>|" +
                "Input from Reader:|" +
                "<h4>|Arbitrary Text|</h4>|" + 
                "<h4>|D Text|</h4>|" +
                "Input from javax.xml.transform.Source:|" +
                "<h4>|Arbitrary Text|</h4>|" + 
                "<h4>|D Text|</h4>|" +
                "Input from result of x:parse action:|" +
                "<h4>|Arbitrary Text|</h4>|" + 
                "<h4>|D Text|</h4>|" +
                "Input from result of x:set action:|" +
                "<h4>|D Text|</h4>|" +
                "Input from x:transform action:|" +
                "<h4>|transform one text|</h4>" 
                );
        invoke();
    }

    /*
     * @testName: positiveTransformXsltInputTest
     * @assertion_ids:
     * @testStrategy: Validate the transform action is able to accept
     *                XSL input from the following sources:
     *                 - String
     *                 - Reader
     *                 - javax.xml.transform.Source.
     */
    public void positiveTransformXsltInputTest() throws Fault {
        String testName = "positiveTransformXsltInputTest";
        TEST_PROPS.setProperty(REQUEST, "GET " + CONTEXT_ROOT +
               "/" + testName + ".jsp HTTP/1.1");
        TEST_PROPS.setProperty(SEARCH_STRING, 
                "Input from String:|" +
                "<h4>|Arbitrary Text|</h4>|" + 
                "<h4>|D Text|</h4>|" +
                "Input from Reader:|" +
                "<h4>|Arbitrary Text|</h4>|" + 
                "<h4>|D Text|</h4>|" +
                "Input from javax.xml.transform.Source:|" +
                "<h4>|Arbitrary Text|</h4>|" + 
                "<h4>|D Text|</h4>"
                );
        invoke();
    }

    /*
     * @testName: positiveTransformDocSystemIdTest
     * @assertion_ids:
     * @testStrategy: Validate the transform action is able to properly
     *                resolve external entity references when the
     *                docSystemId attribute is set.  Validate that the
     *                entities can be resolved when parsing both as
     *                as a String provided to the xml attribute and
     *                as body content to the action.
     */
    public void positiveTransformDocSystemIdTest() throws Fault {
        String testName = "positiveTransformDocSystemIdTest";
        TEST_PROPS.setProperty(REQUEST, "GET " + CONTEXT_ROOT +
               "/" + testName + ".jsp HTTP/1.1");
        TEST_PROPS.setProperty(SEARCH_STRING, 
                "<h4>|Entity Resolved|</h4>|<h4>|Entity Resolved|</h4>");
        invoke();
    }

    /*
     * @testName: positiveTransformXsltSystemIdTest
     * @assertion_ids:
     * @testStrategy: Validate the transform action is able to properly
     *                resolve external references within a stylesheet.
     */
    public void positiveTransformXsltSystemIdTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveTransformXsltSystemIdTest");
        invoke();
    }

    /*
     * @testName: positiveTransformVarTest
     * @assertion_ids:
     * @testStrategy: Validate that if var is specified, the variable
     *                name reference by var is available in the PageContext
     *                and is of type org.w3c.dom.Document.
     */
    public void positiveTransformVarTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveTransformVarTest");
        invoke();
    }

    /*
     * @testName: positiveTransformScopeTest
     * @assertion_ids:
     * @testStrategy: Validate that if var is provided and scope is specified,
     *                that var is exported to the specified scope.  If var
     *                is specified and scope is not, validate that var is
     *                exported to the page scope by default.
     */
    public void positiveTransformScopeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveTransformScopeTest");
        invoke();
    }

    /*
     * @testName: positiveTransformResultTest
     * @assertion_ids:
     * @testStrategy: Validate that transform action properly handles
     *                a case where it is passed a javax.xml.transform.Result.
     *                The Result object is in scope before calling the transform
     *                action.  The Result object is passed to the transform action.
     *                The Result object is obtained from scope, and is then
     *                manipulated to display the results of th transformation.
     */
    public void positiveTransformResultTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveTransformResultTest");
        invoke();
    }

    /*
     * @testName: positiveTransformXmlBodyTest
     * @assertion_ids:
     * @testStrategy: Validate the transform action is able to parse
     *                and then transform an XML document provided as
     *                body content to the action.
     */
    public void positiveTransformXmlBodyTest() throws Fault {
        String testName = "positiveTransformXmlBodyTest";
        TEST_PROPS.setProperty(REQUEST, "GET " + CONTEXT_ROOT +
               "/" + testName + ".jsp HTTP/1.1");
        TEST_PROPS.setProperty(SEARCH_STRING, 
                "<h4>|element text|</h4>");
        invoke();
    }

    /*
     * @testName: positiveTransformBodyParamsTest
     * @assertion_ids:
     * @testStrategy: Validate that xsl parameters provided as
     *                x:param subtags to the transform action are
     *                properly passed to the stylesheet.
     */
    public void positiveTransformBodyParamsTest() throws Fault {
        //TEST_PROPS.setProperty(STANDARD, "positiveTransformBodyParamsTest");
        String testName = "positiveTransformBodyParamsTest";
        TEST_PROPS.setProperty(REQUEST, "GET " + CONTEXT_ROOT +
               "/" + testName + ".jsp HTTP/1.1");
        TEST_PROPS.setProperty(SEARCH_STRING, "15pt|RT Parameter properly passed!");
        TEST_PROPS.setProperty(UNEXPECTED_RESPONSE_MATCH, "REPLACE");
        invoke();
    }

    /*
     * @testName: positiveTransformBodyXmlParamsTest
     * @assertion_ids:
     * @testStrategy: Validate that xsl parameters provided as
     *                x:param subtags along with XML provided
     *                as body content to the action, that the
     *                xml will be parsed and transform with the
     *                parameters properly supplied to the stylesheet.
     */
    public void positiveTransformBodyXmlParamsTest() throws Fault {
        //TEST_PROPS.setProperty(STANDARD, "positiveTransformBodyXmlParamsTest");
        String testName = "positiveTransformBodyXmlParamsTest";
        TEST_PROPS.setProperty(REQUEST, "GET " + CONTEXT_ROOT +
                "/" + testName + ".jsp HTTP/1.1");
        TEST_PROPS.setProperty(SEARCH_STRING, "11pt|Paramter properly passed!");
        TEST_PROPS.setProperty(UNEXPECTED_RESPONSE_MATCH, "THIS SHOULD BE REPLACED");
        invoke();
    }

    /*
     * @testName: negativeTransformXmlXsltNullEmptyTest
     * @assertion_ids:
     * @testStrategy: Validate that if either the xml or xslt attributes
     *                are null or empty, that a JspException is thrown.
     */
    public void negativeTransformXmlXsltNullEmptyTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeTransformXmlXsltNullEmptyTest");
        invoke();
    }

    /*
     * @testName: positiveTransformXmlAndXmlSystemIdTest
     * @assertion_ids:
     * @test_Strategy: Validate that the xml and xmlSystemId attributes
     *                 can still be used (deprecated and not removed).
     */
    public void positiveTransformXmlAndXmlSystemIdTest() throws Fault {
        String testName = "positiveTransformXmlAndXmlSystemIdTest";
        TEST_PROPS.setProperty(REQUEST, "GET " + CONTEXT_ROOT +
                "/" + testName + ".jsp HTTP/1.1");
        TEST_PROPS.setProperty(SEARCH_STRING, 
                "<h4>|Entity Resolved|</h4>|<h4>|Entity Resolved|</h4>");
        invoke();
    }

}
