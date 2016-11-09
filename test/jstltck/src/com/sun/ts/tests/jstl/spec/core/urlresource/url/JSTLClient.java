/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/spec/core/urlresource/url/JSTLClient.java $ $LastChangedDate: 2007-09-20 15:26:34 -0400 (Thu, 20 Sep 2007) $
 */

package com.sun.ts.tests.jstl.spec.core.urlresource.url;

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

        setContextRoot("/jstl_core_url_web");
        setGoldenFileDir("/jstl/spec/core/urlresource/url");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveUrlDisplayUrlTest
     * @assertion_ids: JSTL:SPEC:24.7
     * @testStrategy: Validate that if var is not specified,
     *                the resulting value of the url action is
     *                written to the current JspWriter.
     */
    public void positiveUrlDisplayUrlTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, "positiveUrlDisplayUrlTest");
        TEST_PROPS.setProperty(REQUEST, "positiveUrlDisplayUrlTest.jsp");
        TEST_PROPS.setProperty(SEARCH_STRING, "/jstl_core_url_web/jstl");
        invoke();
    }

    /*
     * @testName: positiveUrlValueVarTest
     * @assertion_ids: JSTL:SPEC:24.2; JSTL:SPEC:24.6
     * @testStrategy: Validate that the result of encoding the value
     *                of the url attribute is properly associated with
     *                a variable designated by var.  Compare the result
     *                with that returned by response.encodeUrl().
     */
    public void positiveUrlValueVarTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveUrlValueVarTest");
        invoke();
    }

    /*
     * @testName: positiveUrlScopeTest
     * @assertion_ids: JSTL:SPEC:24.3; JSTL:SPEC:24.3.1; JSTL:SPEC:24.3.1;
     *                 JSTL:SPEC:24.3.2; JSTL:SPEC:24.3.3; JSTL:SPEC:24.3.4;
     *                 JSTL:SPEC:24.3.5
     * @testStrategy: Validate the behavior of the scope attribute
     *                with respect to var, both when scope is
     *                explicitly defined and when not defined.
     */
    public void positiveUrlScopeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveUrlScopeTest");
        invoke();
    }

    /*
     * @testName: positiveUrlNoCharEncodingTest
     * @assertion_ids: JSTL:SPEC:24.12
     * @testStrategy: Validate that if the URL to be encoded contains
     *                special characters, that they are not encoded
     *                by the action.
     */
    public void positiveUrlNoCharEncodingTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveUrlNoCharEncodingTest");
        invoke();
    }

    /*
     * @testName: positiveUrlParamsBodyTest
     * @assertion_ids: JSTL:SPEC:25
     * @testStrategy: Validate the URL action can properly interact with
     *                nested param subtags.
     */
    public void positiveUrlParamsBodyTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveUrlParamsBodyTest");
        invoke();
    }

    /*
     * @testName: positiveUrlAbsUrlNotRewrittenTest
     * @assertion_ids: JSTL:SPEC:24.5
     * @testStrategy: Validate that if an absolute URL is provided
     *                to the URL action, the result is not rewritten.
     */
    public void positiveUrlAbsUrlNotRewrittenTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveUrlAbsUrlNotRewrittenTest");
        invoke();
    }

    /*
     * @testName: positiveUrlContextTest
     * @assertion_ids: JSTL:SPEC:24.11;  JSTL:SPEC:24.11.1  
     * @testStrategy: Validate that behavior of the action when the context
     *                attribute is provided.  The resulting URL should be
     *                returned with the foreign context included along with
     *                the path.
     */
    public void positiveUrlContextTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveUrlContextTest");
        invoke();
    }

    /*
     * @testName: positiveUrlRelUrlRewrittenTest
     * @assertion_ids: JSTL:SPEC:24.5
     * @testStrategy: Validate that any page relative or context
     *                relative paths provided to the action are rewitten
     *                if the client doesn't accept cookies.
     */
    public void positiveUrlRelUrlRewrittenTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveUrlRelUrlRewrittenTest");
        invoke();
    }

    /*
     * @testName: negativeUrlExcBodyContentTest
     * @assertion_ids: JSTL:SPEC:24.9
     * @testStrategy: Validate that an Exception is
     *                thrown if the body content of the action causes
     *                an exception.
     */
    public void negativeUrlExcBodyContentTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeUrlExcBodyContentTest");
        invoke();
    }

    /*
     * @testName: negativeUrlContextUrlInvalidValueTest
     * @assertion_ids: JSTL:SPEC:24.11.4; JSTL:SPEC:24.11.5
     * @testStrategy: Validate that an Exception occurs if the value
     *                provided to context or url (when context is specified)
     *                doesn't begin with a leading slash.
     */
    public void negativeUrlContextUrlInvalidValueTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeUrlContextUrlInvalidValueTest");
        invoke();
    }
}
