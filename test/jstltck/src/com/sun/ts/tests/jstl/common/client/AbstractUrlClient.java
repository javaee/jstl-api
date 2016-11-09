/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/common/client/AbstractUrlClient.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.common.client;

import com.sun.ts.tests.common.webclient.BaseUrlClient;
import com.sun.ts.tests.common.webclient.WebTestCase;
import com.sun.ts.tests.common.webclient.http.HttpRequest;

public class AbstractUrlClient extends BaseUrlClient {

    protected static final String STANDARD_COMPAT = "standardCompat";

    /**
     * Sets the test properties for this testCase.
     *
     * @param testCase - the current test case
     */
    protected void setTestProperties(WebTestCase testCase) {
        setStandardProperties(TEST_PROPS.getProperty(STANDARD), testCase);
        setStandardCompatProperties(TEST_PROPS.getProperty(STANDARD_COMPAT), testCase);
        if (testCase.getRequest() == null) {
            String test = TEST_PROPS.getProperty(REQUEST);
            if (test.indexOf("HTTP/") < 0) {
                StringBuffer sb = new StringBuffer(25);
                sb.append(GET).append(_contextRoot);
                sb.append(SL).append(test).append(HTTP11);
                HttpRequest req = new HttpRequest(sb.toString(), _hostname, _port);
                testCase.setRequest(req);
            }
            String gf = TEST_PROPS.getProperty(GOLDENFILE);
            if (gf != null) {
                StringBuffer sb = new StringBuffer(25);
                sb.append(_tsHome).append("/src/web").append(GOLDENFILEDIR);
                sb.append(SL).append(gf);
                testCase.setGoldenFilePath(sb.toString());
                TEST_PROPS.remove(GOLDENFILE);
            }
        }

        super.setTestProperties(testCase);
    }

    /** Sets the goldenfile directory
     * @param goldenDir goldenfile directory based off test directory
     */
    public void setGoldenFileDir(String goldenDir) {
        GOLDENFILEDIR = goldenDir;
    }

    /**
     * Consists of a test name, a request, and a goldenfile.
     * @param testValue - a logical test identifier
     * @param testCase - the current test case
     */
    private void setStandardProperties(String testValue, WebTestCase testCase) {

        if (testValue == null) {
            return;
        }
        // A standard test sets consists of a testname
        // a request, and a goldenfile. The URI is not used
        // in this case since the JSP's are assumed to be located
        // at the top of the contextRoot

        // A standard test sets consists of a testname
        // a request, and a goldenfile
        StringBuffer sb = new StringBuffer(50);

        // set the testname
        _testName = testValue;

        // set the request
        sb.append(GET).append(_contextRoot).append(SL);
        sb.append(testValue).append(JSP_SUFFIX).append(HTTP11);
        //setRequest(sb.toString());
        HttpRequest req = new HttpRequest(sb.toString(), _hostname, _port);
        testCase.setRequest(req);

        // set the goldenfile
        sb = new StringBuffer(50);
        sb.append(_tsHome).append("/src/web").append(GOLDENFILEDIR);
        sb.append(SL);
        sb.append(testValue).append(GF_SUFFIX);
        testCase.setGoldenFilePath(sb.toString());
    }

    /**
     * Consists of a test name, a request, and a goldenfile.
     * @param testValue - a logical test identifier
     * @param testCase - the current test case
     */
    private void setStandardCompatProperties(String testValue, WebTestCase testCase) {

        if (testValue == null) {
            return;
        }
        // A standard test sets consists of a testname
        // a request, and a goldenfile. The URI is not used
        // in this case since the JSP's are assumed to be located
        // at the top of the contextRoot

        // A standard test sets consists of a testname
        // a request, and a goldenfile
        StringBuffer sb = new StringBuffer(50);

        // set the testname
        _testName = testValue;

        // set the request
        sb.append(GET).append(_contextRoot).append(SL);
        sb.append(testValue).append(JSP_SUFFIX).append(HTTP11);
        //setRequest(sb.toString());
        HttpRequest req = new HttpRequest(sb.toString(), _hostname, _port);
        testCase.setRequest(req);

        // set the goldenfile
        sb = new StringBuffer(50);
        sb.append(_tsHome).append(GOLDENFILEDIR);
        sb.append(_generalURI).append(SL);
        sb.append(testValue).append(GF_SUFFIX);
        testCase.setGoldenFilePath(sb.toString());
    }
}
