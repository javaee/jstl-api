/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/xml/xmlcore/parse/JSTLClient.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.spec.xml.xmlcore.parse;

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

        setContextRoot("/jstl_xml_parse_web");
        setGoldenFileDir("/jstl/spec/xml/xmlcore/parse");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveParseXmlInputTest
     * @assertion_ids:
     * @testStrategy: Validate that parse action is able to parse
     *                various input sources as provided by the xml
     *                attribute:
     *                  - Strings
     *                  - Readers
     *                  - Instances of javax.xml.transform.Source
     *                  - Objects exported by:
     *                      + x:parse
     *                      + x:set
     *                      + x:transform
     *                No validation will be performed against the result.
     *                The test will be considered a success if no parse
     *                exceptions are thrown.
     */
    public void positiveParseXmlInputTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveParseXmlInputTest");
        invoke();
    }

    /*
     * @testName: positiveParseFilterTest
     * @assertion_ids:
     * @testStrategy: Validate that if an instance of org.xml.sax.XMLFilter
     *                is provided to the filter attribute, that it is properly
     *                applied by the action.  This will be verified using a
     *                simple XML filter that will add an attribute ('test')
     *                to the provided elements.  XPath will be used to
     *                verify that the attribute exists.
     */
    public void positiveParseFilterTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveParseFilterTest");
        invoke();
    }

    /*
     * @testName: positiveParseVarTest
     * @assertion_ids:
     * @testStrategy: Validate that if the parse operation is successfull, and
     *                var is specified, the result is available via the
     *                PageContext and is of type java.lang.Object.
     */
    public void positiveParseVarTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveParseVarTest");
        invoke();
    }

    /*
     * @testName: positiveParseVarDomTest
     * @assertion_ids:
     * @testStrategy: Validate that if the parse operation is successfull, and
     *                varDom is specified, the result is available via the
     *                PageContext and is of type org.w3c.dom.Document.
     */
    public void positiveParseVarDomTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveParseVarDomTest");
        invoke();
    }

    /*
     * @testName: positiveParseScopeTest
     * @asseriton_ids:
     * @testStrategy: Validate that the precence of scope propery exports
     *                var to the specified scope.  If var is provided,
     *                but scope is not, verify that var is exported to the
     *                page scope by default.
     */
    public void positiveParseScopeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveParseScopeTest");
        invoke();
    }

    /*
     * @testName: positiveParseScopeDomTest
     * @asseriton_ids:
     * @testStrategy: Validate that the precence of scopeDom propery exports
     *                varDom to the specified scope.  If varDom is provided,
     *                but scopeDom is not, verify that varDom is exported to the
     *                page scope by default.
     */
    public void positiveParseScopeDomTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveParseScopeDomTest");
        invoke();
    }

    /*
     * @testName: positiveParseXmlBodyTest
     * @assertion_ids:
     * @testStrategy: Validate that parse action can properly parse XML
     *                provided as body content to the action.  No exception
     *                should occur, and the result should be available via
     *                an XPath expression.
     */
    public void positiveParseXmlBodyTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveParseXmlBodyTest");
        invoke();
    }

    /*
     * @testName: positiveParseFilterNullTest
     * @assertion_ids:
     * @testStrategy: Validate that if the filter attribute is null, no filtering
     *                takes place and the parse operation proceed normally.
     */
    public void positiveParseFilterNullTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveParseFilterNullTest");
        invoke();
    }

    /*
     * @testName: positiveParseSystemIdTest
     * @assertion_ids:
     * @testStrategy:  Validate that when the the parse action is provided
     *                 the SystemID attribute, it's able to resolve
     *                 external Entitis referenced by the provided XML document.
     */
    public void positiveParseSystemIdTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveParseSystemIdTest");
        invoke();
    }

    /*
     * @testName: positiveParseNoDTDValidationTest
     * @assertion_ids:
     * @testStrategy: Validate that no DTD validation is performed
     *                against a document provided with a DTD.  Confirm by
     *                providing an XML document that goes against the provided
     *                DTD.  No parsing exception should occur.
     */
    public void positiveParseNoDTDValidationTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveParseNoDTDValidationTest");
        invoke();
    }

    /*
     * @testName: negativeParseScopeVarSyntaxTest
     * @assertion_ids:
     * @testStrategy: Validate that if scope is specified, but var is not,
     *                that a fatal translation error occurs.
     */
    public void negativeParseScopeVarSyntaxTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "negativeParseScopeVarSyntaxTest");
        TEST_PROPS.setProperty(REQUEST, "negativeParseScopeVarSyntaxTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }

    /*
     * @testName: negativeParseScopeVarDomSyntaxTest
     * @assertion_ids:
     * @testStrategy: Validate that if scopeDom is specified, but varDom is not,
     *                that a fatal translation error occurs.
     */
    public void negativeParseScopeVarDomSyntaxTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "negativeParseScopeVarDomSyntaxTest");
        TEST_PROPS.setProperty(REQUEST, "negativeParseScopeVarSyntaxTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }

    /*
     * @testName: negativeParseInvalidScopeTest
     * @assertion_ids:
     * @testStrategy: Validate that a fatal translation error occurs if
     *                the scope attribute is provided an invalid value.
     */
    public void negativeParseInvalidScopeTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "negativeParseInvalidScopeTest");
        TEST_PROPS.setProperty(REQUEST, "negativeParseInvalidScopeTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }

    /*
     * @testName: negativeParseDocNullEmptyTest
     * @assertion_ids:
     * @testStrategy: Validate that if doc is null or empty, that an
     *                instance of javax.servlet.jsp.JspException is thrown.
     */
    public void negativeParseDocNullEmptyTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeParseDocNullEmptyTest");
        invoke();
    }

    /*
     * @testName: positiveParseXmlAttrTest
     * @assertion_ids:
     * @test_Strategy: Validate that the xml attribute is still available for
     *                 use (deprecated and not removed).
     */
    public void positiveParseXmlAttrTest() throws Fault {
        TEST_PROPS.setProperty(REQUEST,
            "GET /jstl_xml_parse_web/positiveParseXmlAttrTest.jsp HTTP/1.1");
        TEST_PROPS.setProperty(SEARCH_STRING, "Test PASSED");
        invoke();
    }
}
