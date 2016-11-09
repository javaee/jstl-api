/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * @(#)JSTLClient.java	1.2 03/19/02
 */

package com.sun.ts.tests.jstl.spec.sql.param;

import java.io.PrintWriter;
import com.sun.javatest.Status;
import com.sun.ts.lib.harness.EETest.Fault;
import com.sun.ts.tests.jstl.common.client.SqlUrlClient;

public class JSTLClient extends SqlUrlClient {

    /*
     * @class.setup_props: webServerHost; webServerPort; ts_home;
     * jstl.db.url; jstl.db.user; jstl.db.password; jstl.db.driver;
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

        setGeneralURI("/jstl/spec/sql/param");
        setContextRoot("/jstl_sql_param_web");
        setGoldenFileDir("/jstl/spec/sql/param");

        return super.run(args, out, err);
    }

    /*
     * @testName: positiveParamQuerySQLAttributeTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:query action
     *                - That a query can be executed using sql attribute
     *                  and sql:param action
     *                - Validate that you get the expected number of rows back.
     */
    public void positiveParamQuerySQLAttributeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveParamQuerySQLAttributeTest");
        invoke();
    }

    /*
     * @testName: positiveParamQueryBodyContentTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:query action
     *                - That a query can be executed using sql:param action
     *                  and passing the query as body content.
     *                - Validate that you get the expected number of rows back.
     */
    public void positiveParamQueryBodyContentTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveParamQueryBodyContentTest");
        invoke();
    }

   /*
     * @testName: positiveParamQueryMultiSQLAttributeTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:query action
     *                - That a query can be executed using sql attribute
     *                  and multiple sql:param actions
     *                - Validate that you get the expected number of rows back.
     *                - That the order of the sql:params action is the order
     *                  the placeholders in the query are filled in.
     */
    public void positiveParamQueryMultiSQLAttributeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveParamQueryMultiSQLAttributeTest");
        invoke();
    }

    /*
     * @testName: positiveParamQueryMultiBodyContentTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:query action
     *                - That a query can be executed using mutiple sql:param
     *                  actions and passing the query as body content.
     *                - Validate that you get the expected number of rows back.
     *                - That the order of the sql:params action is the order
     *                  the placeholders in the query are filled in.
     */
    public void positiveParamQueryMultiBodyContentTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveParamQueryMultiBodyContentTest");
        invoke();
    }

    /*
     * @testName: positiveParamUpdateMultiSQLAttributeTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:update action
     *                - That a query can be executed using sql attribute
     *                  and multiple sql:param actions
     *                - Validate that you get the expected number of rows back.
     */
    public void positiveParamUpdateMultiSQLAttributeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveParamUpdateMultiSQLAttributeTest");
        invoke();
    }

    /*
     * @testName: positiveParamUpdateMultiBodyContentTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:update action
     *                - That a query can be executed using mutiple sql:param
     *                  actions and passing the query as body content.
     *                - Validate that you get the expected number of rows back.
     */
    public void positiveParamUpdateMultiBodyContentTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveParamUpdateMultiBodyContentTest");
        invoke();
    }

    /*
     * @testName: positiveDateParamQueryDateTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:query action
     *                - That a query can be executed using sql:dateParam action
     *                  specifying a type of 'date'
     *                - Validate that you get the expected number of rows back.
     */
    public void positiveDateParamQueryDateTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveDateParamQueryDateTest");
        invoke();
    }


    /*
     * @testName: positiveDateParamQueryTimeTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:query action
     *                - That a query can be executed using sql:dateParam action
     *                  specifying a type of 'time'
     *                - Validate that you get the expected number of rows back.
     */
    public void positiveDateParamQueryTimeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveDateParamQueryTimeTest");
        invoke();
    }

    /*
     * @testName: positiveDateParamQueryTimestampTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:query action
     *                - That a query can be executed using sql:dateParam action
     *                  specifying a type of 'timestamp'
     *                - Validate that you get the expected number of rows back.
     */
    public void positiveDateParamQueryTimestampTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveDateParamQueryTimestampTest");
        invoke();
    }

    /*
     * @testName: positiveDateParamQueryNoTypeTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:query action
     *                - That a query can be executed using sql:dateParam action
     *                  without specifying a type defaults to 'timestamp'
     *                - Validate that you get the expected number of rows back.
     */
    public void positiveDateParamQueryNoTypeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveDateParamQueryNoTypeTest");
        invoke();
    }

    /*
     * @testName: positiveDateParamUpdateDateTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:update action
     *                - That a query can be executed using sql:dateParam action
     *                  specifying a type of 'date'.
     */
    public void positiveDateParamUpdateDateTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveDateParamUpdateDateTest");
        invoke();
    }


    /*
     * @testName: positiveDateParamUpdateTimeTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:update action
     *                - That a query can be executed using sql:dateParam action
     *                  specifying a type of 'time'.
     */
    public void positiveDateParamUpdateTimeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveDateParamUpdateTimeTest");
        invoke();
    }

    /*
     * @testName: positiveDateParamUpdateTimestampTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:update action
     *                - That a query can be executed using sql:dateParam action
     *                  specifying a type of 'timestamp'.
     */
    public void positiveDateParamUpdateTimestampTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveDateParamUpdateTimestampTest");
        invoke();
    }
    /*
     * @testName: positiveDateParamUpdateNoTypeTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:update action
     *                - That a query can be executed using sql:dateParam action
     *                  without specifying a type defaults to 'timestamp'
     *                - Validate that you get the expected number of rows back.
     */
    public void positiveDateParamUpdateNoTypeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveDateParamUpdateNoTypeTest");
        invoke();
    }

    /*
     * @testName: positiveParamUpdateBodyContentTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:update action
     *                - That a query can be executed by specifying a
     *                paramater via sql:param action
     */
    public void positiveParamUpdateBodyContentTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveParamUpdateBodyContentTest");
        invoke();
    }

    /*
     * @testName: positiveParamUpdateSQLAttributeTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:update action using
     *                the sql attribute
     *                - That a query can be executed by specifying a
     *                paramater via sql:param action
     */
    public void positiveParamUpdateSQLAttributeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveParamUpdateSQLAttributeTest");
        invoke();
    }

    /*
     * @testName: positiveParamBodyContentQueryTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:query action
     *                - That a query can be executed by specifying a
     *                paramater via sql:param action which passes the
     *                parameter value as a String.
     */
    public void positiveParamBodyContentQueryTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveParamBodyContentQueryTest");
        invoke();
    }
        /*
     * @testName: positiveParamBodyContentUpdateTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:update action
     *                - That a query can be executed by specifying a
     *                paramater via sql:param action which passes the
     *                parameter value as a String.
     */
    public void positiveParamBodyContentUpdateTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveParamBodyContentUpdateTest");
        invoke();
    }

    /*
     * @testName: negativeParamQuerySQLAttributeTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:query action
     *                - That a query which specifies place holders
     *                  using sql attribute, requires a sql:param action
     *                - Validate that a JspException is thrown when the
     *                  sql:param action is omitted
     */
    public void negativeParamQuerySQLAttributeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeParamQuerySQLAttributeTest");
        invoke();
    }

    /*
     * @testName: negativeParamQueryBodyContentTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:query action
     *                - That a query which specifies place holders
     *                  and specifies the query as body content,
     *                  requires a sql:param action
     *                - Validate that a JspException is thrown when the
     *                  sql:param action is omitted
     */
    public void negativeParamQueryBodyContentTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeParamQueryBodyContentTest");
        invoke();
    }

    /*
     * @testName: negativeDateParamTypeAttributeTest
     * @assertion_ids:
     * @testStrategy: Validate the behavior of the sql:dateParam action
     *                - Validate that a JspException is thrown when an
     *                  invalid value is provided for the type attribute.
     */
    public void negativeDateParamTypeAttributeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeDateParamTypeAttributeTest");
        invoke();
    }
}
