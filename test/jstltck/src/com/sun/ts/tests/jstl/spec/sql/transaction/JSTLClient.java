/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: JSTLClient.java 53817 2007-09-11 13:23:26Z dougd $
 */

package com.sun.ts.tests.jstl.spec.sql.transaction;

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
        
        setGeneralURI("/jstl/spec/sql/transaction");
        setContextRoot("/jstl_sql_transaction_web");
        setGoldenFileDir("/jstl/spec/sql/transaction");
        
        return super.run(args, out, err);
    }
    
    
    /*
     * @testName: positiveTxDataSourceConfigDataSourceTest
     * @assertion_ids:
     * @testStrategy: Validate sql:transaction, sql:query actions utilizing the
     *                configuration parameter
     *                javax.servlet.jsp.jstl.sql.dataSource.
     *                The query is passed as body content.
     *                - that sql:transaction action uses the configuration
     *                  parameter
     *                - The datasource attribute takes precedence over
     *                  javax.servlet.jsp.jstl.sql.dataSource
     */
    public void positiveTxDataSourceConfigDataSourceTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD,
                "positiveTxDataSourceConfigDataSourceTest");
        invoke();
    }
    
    
    /*
     * @testName: positiveTxDataSourceConfigDriverManagerTest
     * @assertion_ids:
     * @testStrategy: Validate sql:transaction action utilizing the
     *                configuration
     *                parameter javax.servlet.jsp.jstl.sql.dataSource and
     *                setting it to a String representing JDBC DriverManager
     *                parameters.  The query is passed as body content
     */
    public void positiveTxDataSourceConfigDriverManagerTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD,
                "positiveTxDataSourceConfigDriverManagerTest");
        invoke();
    }
    
     /*
      * @testName: positiveTxDataSourceConfigPrecedenceTest
      * @assertion_ids:
      * @testStrategy: Validate sql:transaction action dataSource attribute
      *                takes precedence over the configuration parameter
      *                javax.servlet.jsp.jstl.sql.dataSource.
      */
    public void positiveTxDataSourceConfigPrecedenceTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD,
                "positiveTxDataSourceConfigPrecedenceTest");
        invoke();
    }
    
    /*
     * @testName: positiveTxDataSourceAttributeDataSourceTest
     * @assertion_ids:
     * @testStrategy: Validate sql:transaction action specifying
     *                a DataSource Object for the dataSource attribute.
     *                The query is passed as body content.
     */
    public void positiveTxDataSourceAttributeDataSourceTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD,
                "positiveTxDataSourceAttributeDataSourceTest");
        invoke();
    }
    
    /*
     * @testName: positiveTxDataSourceAttributeDriverManagerTest
     * @assertion_ids:
     * @testStrategy: Validate sql:transaction action specifying
     *                a dataSource attribute  which contains JDBC
     *                DriverManager properties (URL, driver, user, password)
     *                The query is passed as body content.
     */
    public void positiveTxDataSourceAttributeDriverManagerTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD,
                "positiveTxDataSourceAttributeDriverManagerTest");
        invoke();
    }
    
    /*
     * @testName: positiveTxQueryCommitTest
     * @assertion_ids:
     * @testStrategy: Validate sql:transaction  and sql:query actions
     *                allow a query to be successfully executed.
     */
    public void positiveTxQueryCommitTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveTxQueryCommitTest");
        invoke();
    }
    
    
    /*
     * @testName: positiveTxUpdateCommitTest
     * @assertion_ids:
     * @testStrategy: Validate sql:transaction  and sql:update actions
     *                allow a query to be successfully committed.
     */
    public void positiveTxUpdateCommitTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveTxUpdateCommitTest");
        invoke();
    }
    
    /*
     * @testName: positiveTxUpdateRollbackTest
     * @assertion_ids:
     * @testStrategy: Validate sql:transaction  and sql:update actions
     *                allow a query to be successfully rolled back when an
     *                SQLException occurs during the transaction.
     */
    public void positiveTxUpdateRollbackTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "positiveTxUpdateRollbackTest");
        invoke();
    }
    
    /*
     * @testName: positiveTxIsolationAttributeRead_CommittedTest
     * @assertion_ids:
     * @testStrategy: Validate sql:transaction  will set the isolation
     *                attribute to read_committed.
     */
    public void positiveTxIsolationAttributeRead_CommittedTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD,
                "positiveTxIsolationAttributeRead_CommittedTest");
        invoke();
    }
    
    /*
     * @testName: positiveTxIsolationAttributeSerializable
     * @assertion_ids:
     * @testStrategy: Validate sql:transaction  will set the isolation
     *                attribute to serializable.
     */
    public void positiveTxIsolationAttributeSerializable() throws Fault {
        TEST_PROPS.setProperty(STANDARD,
                "positiveTxIsolationAttributeSerializable");
        invoke();
    }
        /*
         * @testName: positiveTxCommitLifeCycleTest
         * @assertion_ids:
         * @testStrategy: Validate sql:transaction  action lifecycle for a
         *                committed transaction.
         */
    public void positiveTxCommitLifeCycleTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD,
                "positiveTxCommitLifeCycleTest");
        invoke();
    }
    
    /*
     * @testName: positiveTxRollbackLifeCycleTest
     * @assertion_ids:
     * @testStrategy: Validate sql:transaction action lifecyle for a
     *                transaction that is rolled back
     */
    public void positiveTxRollbackLifeCycleTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD,
                "positiveTxRollbackLifeCycleTest");
        invoke();
    }
    
    /*
     * @testName: positiveTxQueryParamCommitTest
     * @assertion_ids:
     * @testStrategy: Validate sql:transaction, sql:query and sql:param actions
     *                allow for a query to be executed successfully.
     */
    public void positiveTxQueryParamCommitTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD,
                "positiveTxQueryParamCommitTest");
        invoke();
    }
       /*
        * @testName: positiveTxUpdateParamCommitTest
        * @assertion_ids:
        * @testStrategy: Validate sql:transaction, sql:update and sql:param
        *                actions allow for a query to be executed successfully.
        */
    public void positiveTxUpdateParamCommitTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD,
                "positiveTxUpdateParamCommitTest");
        invoke();
    }
    
   /*
    * @testName: negativeTxDataSourceAttributeTest
    * @assertion_ids:
    * @testStrategy: Validate the sql:transaction action which specifies an
    *                invalid DataType for the dataSource attribute will generate
    *                a JspException.
    */
    public void negativeTxDataSourceAttributeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, "negativeTxDataSourceAttributeTest");
        invoke();
    }
    
   /*
    * @testName: negativeTxDataSourceNullAttributeTest
    * @assertion_ids:
    * @testStrategy: Validate the sql:transaction action which specifies an
    *                DataSource Object which is null for the dataSource
    *                attribute will generate a JspException.
    */
    public void negativeTxDataSourceNullAttributeTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD,
                "negativeTxDataSourceNullAttributeTest");
        invoke();
    }
    
    
   /*
    * @testName: negativeTxDataSourceAttributeEmptyTest
    * @assertion_ids:
    * @testStrategy: Validate the sql:transaction action which specifies an 
    *                DataSource Object which is uninitialized for the dataSource 
    *                attribute will generate a JspException.
    */
    public void negativeTxDataSourceAttributeEmptyTest() throws Fault {
        TEST_PROPS.setProperty(STANDARD, 
                "negativeTxDataSourceAttributeEmptyTest");
        invoke();
    }
    
    /*
     * @testName: negativeTxIsolationLevelAttributeTest
     * @assertion_ids:
     * @testStrategy: Validate that if a sql:transaction utilizes an invalid
     *                isolationLevel attribute, that a translation error
     *                will occur.
     */
    public void negativeTxIsolationLevelAttributeTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, 
                "negativeTxIsolationLevelAttributeTest");
        TEST_PROPS.setProperty(REQUEST, 
                "negativeTxIsolationLevelAttributeTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }
    
    /*
     * @testName: negativeTxQueryDataSourceAttributeTest
     * @assertion_ids:
     * @testStrategy: Validate that if a sql:transaction contains a sql:query
     *                action that specifies a dataSource attribute that a
     *                translation error occurs.
     */
    public void negativeTxQueryDataSourceAttributeTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, 
                "negativeTxQueryDataSourceAttributeTest");
        TEST_PROPS.setProperty(REQUEST, 
                "negativeTxQueryDataSourceAttributeTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }
    
    /*
     * @testName: negativeTxUpdateDataSourceAttributeTest
     * @assertion_ids:
     * @testStrategy: Validate that if a sql:transaction contains a sql:update
     *                action that specifies a dataSource attribute that a
     *                translation error occurs.
     */
    public void negativeTxUpdateDataSourceAttributeTest() throws Fault {
        TEST_PROPS.setProperty(TEST_NAME, 
                "negativeTxUpdateDataSourceAttributeTest");
        TEST_PROPS.setProperty(REQUEST, 
                "negativeTxUpdateDataSourceAttributeTest.jsp");
        TEST_PROPS.setProperty(STATUS_CODE, INTERNAL_SERVER_ERROR);
        invoke();
    }
}
