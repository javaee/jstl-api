/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * $Id: TSHarnessObserver.java 53026 2007-03-21 19:27:21Z kgrucci $
 */


package  com.sun.ts.lib.harness;

import  com.sun.javatest.*;
import  com.sun.javatest.util.StringArray;
import  com.sun.ts.lib.util.*;
import  com.sun.ts.lib.porting.*;
import  com.sun.ts.lib.deliverable.*;
import  java.io.*;
import  java.net.*;
import  java.util.*;
import  java.util.jar.*;

/**
 * This class is used to capture output from the tests (which goes to the .jtr
 * files) and to also send it to the standard output stream.  This is done
 * so that "gmake runclient" when running Javatest in batch mode, will behave
 * similar to the old "gmake runclient".
 *
 * @author	Kyle Grucci
 */
public class TSHarnessObserver
        implements Harness.Observer, TestResult.Observer {
    private boolean supportsAutoDeploy = true;
    private boolean supportsAutoJMSAdmin = true;
    private static SuiteSynchronizer ss;
    private static int iPassedCount;
    private static int iFailedCount;
    private static int iErrorCount;
    private static int iNotRunCount;
    private static int iFinishedTests;
    private static Vector vTests = new Vector();
    private static boolean jtrOutput;
    private static String sLastTestDirectory = "";
    private static int executionMode;
    private static String keywords = "all";
    private static final String SEP = "*******************************";
    private static final String SEP2 = "********************************************************************************";

    static {
    jtrOutput = Boolean.getBoolean("cts.jtroutput");
    }

    public TSHarnessObserver () {
        try {
            DeliverableInterface deliverable = DeliverableFactory.getDeliverableInstance();
            supportsAutoDeploy = deliverable.supportsAutoDeployment();
            supportsAutoJMSAdmin = deliverable.supportsAutoJMSAdmin();
        } catch (Exception ex) {
            TestUtil.logHarness("Failed to get deliverable instance.");
            ex.printStackTrace();
        }
    }

    //------methods from Harness.Observer----------------------------------------
    public void startingTestRun (com.sun.javatest.Parameters p) {
        
        if(jtrOutput)
            println("Starting tests");
        
        PropertyManagerInterface propMgr = null;
        try {
            //get keywords that are set and add them to the prop mgr
            Parameters.MutableKeywordsParameters mkp = (Parameters.MutableKeywordsParameters)p.getKeywordsParameters();
            keywords = mkp.getMatchKeywordsValue();
            TestUtil.logHarness("keywords set to:  " + keywords);
        
            propMgr = DeliverableFactory.getDeliverableInstance().getPropertyManager();
            propMgr.setProperty("current.keywords", keywords);
        } catch (Exception e) {
            e.printStackTrace();
        }
        executionMode = ExecutionMode.getExecutionMode(propMgr);
    }

    public void stoppingTestRun () {}

    public void finishedTestRun (boolean allOK) {}

    public synchronized void finishedTesting () {
        
        PropertyManagerInterface propMgr = null;
        try {
            propMgr = DeliverableFactory.getDeliverableInstance().getPropertyManager();
            propMgr.setProperty("current.keywords", keywords);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //do common/last apps undeployment here...
        try {
        if(executionMode == ExecutionMode.DEPLOY_RUN_UNDEPLOY
        || executionMode == ExecutionMode.UNDEPLOY) {
                ss = SuiteSynchronizer.getSuiteSynchronizer(new PrintWriter(System.out, true));
                sLastTestDirectory = "";
                if(supportsAutoDeploy) {
                    ss.undeployLastApp();
                    ss.doCommonUnDeployment();
                }
                if(supportsAutoJMSAdmin) {
                    ss.removeJmsConnectionFactories();
                }
            }
        } catch (TSDeploymentException de) {
            TestUtil.logHarness(SEP + "\nAn error occurred during common/last app Undeployment\n" + SEP);
        de.printStackTrace();
    } catch (TSJMSAdminException je) {
            TestUtil.logHarness(SEP + "\nAn error occurred during JMS topic/queue/factory removal\n" + SEP);
            je.printStackTrace();
        }

    if(jtrOutput) {
        int iSize = vTests.size();
        if (iSize == 0) {
        return;
        }
        StringBuffer msg = new StringBuffer(1000);
        msg.append(SEP2).append('\n');
        msg.append("Completed running ").append(iFinishedTests).append(" tests.").append('\n');
        msg.append("Number of Tests Passed      = ").append(iPassedCount).append('\n');
        msg.append("Number of Tests Failed      = " + iFailedCount).append('\n');
        msg.append("Number of Tests with Errors = " + iErrorCount).append('\n');
        msg.append(SEP2).append('\n');
        for (int ii = 0; ii < iSize; ii++) {
        String elem = (String) vTests.get(ii);
        msg.append(elem).append('\n');
        }
        println(msg.toString());

        vTests.removeAllElements();
        iFinishedTests = 0;
        iPassedCount = 0;
        iErrorCount = 0;
        iNotRunCount = 0;
        iFailedCount = 0;
    }

    removeTempPropsFile();
    removeTempJars();
    }

    private void removeTempPropsFile() {
	try {
	    String tempDir = System.getProperty("java.io.tmpdir");
	    String userName = System.getProperty("user.name");
	    String tempFile = tempDir + File.separator + userName + "-cts-props.txt";
	    File tempF = new File(tempFile);
	    tempF.delete();
	} catch (Throwable e) {
	}
    }

    private void removeTempJars() {
	try {
	    String tempDir = System.getProperty("java.io.tmpdir");
	    File tempDirFile = new File(tempDir);
	    String userName = System.getProperty("user.name");
	    File[] tempJars = tempDirFile.listFiles();
	    int numFiles = (tempJars == null) ? 0 : tempJars.length;
	    for (int i = 0; i < numFiles; i++) {
		if (tempJars[i].getName().startsWith(userName + "-ts-deployment-plan") &&
		    tempJars[i].getName().endsWith(".jar")) {
		    try {
			tempJars[i].delete();
		    } catch (Throwable ee) {}
		}
	    }
	} catch (Throwable e) {
	}
    }

    public void error (String s) {
        TestUtil.logHarness(s);
    }

    public synchronized void startingTest (TestResult tr) {
        Properties pTestProps = null;
        String sVehicle = "";
        String sIsServiceTest = "";
        PropertyManagerInterface propMgr = null;
        try {
            propMgr = DeliverableFactory.getDeliverableInstance().getPropertyManager();
            propMgr.setProperty("current.keywords", keywords);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TestDescription td = null;
        try {
            td = tr.getDescription();
        } catch (TestResult.Fault e) {
            e.printStackTrace();
        }

    if(jtrOutput) {
        tr.addObserver(this);
        if(executionMode == ExecutionMode.DEPLOY_RUN_UNDEPLOY
        || executionMode == ExecutionMode.RUN
        || executionMode == ExecutionMode.DEPLOY_RUN) {
        StringBuffer msg = new StringBuffer(300);
        msg.append(SEP2).append('\n');
        msg.append("Beginning Test:  ").append(td.getParameter("classname").replace('.', '/')).append(".java#").append(td.getParameter("id")).append('\n');
        msg.append(SEP2).append('\n');
        println(msg.toString());
        }
    }
        //do deployment here
        if (ss == null)
            ss = SuiteSynchronizer.getSuiteSynchronizer(new PrintWriter(System.out, true));

        //get properties from the test description
        String testPropsInDescp = td.getParameter("testProps");
        String[] sTestPropKeys = TestUtil.EMPTY_STRING_ARRAY;
        if(testPropsInDescp != null) {
            StringTokenizer st = new StringTokenizer(testPropsInDescp.trim());
            sTestPropKeys = new String[st.countTokens()];
            for (int ii = 0; ii < sTestPropKeys.length; ii++) {
                sTestPropKeys[ii] = st.nextToken();
            }
        }
        //construct a properties object with the test specific keys
        //and the values from the jte file
        try {
            pTestProps = propMgr.getTestSpecificProperties(sTestPropKeys);
        } catch (PropertyNotSetException e) {
            e.printStackTrace();
        }
        //get and set which vehicle this test should run in
        String sID = td.getParameter("id");
        sIsServiceTest = td.getParameter("service_eetest");
        sVehicle = null;
        //do we have a service test?
        if (sIsServiceTest.equals("yes")) {
            sVehicle = sID.substring(sID.lastIndexOf("_") + 1);
        }
        else {
            sVehicle = "not a service test";
        }
        //if we are standalone (like JDBC ouside of J2EE, don't deploy)
        //just run!
        if (!sVehicle.equals("standalone") && supportsAutoDeploy) {
            String testDir = "";
            try {
                //ss.setOutputWriter(logOut);
                testDir = TSTestFinder.getAbsolutePath(td.getParameter("test_directory"));
                //just return if we're in the same test directory
                if (sLastTestDirectory.equals(testDir)) {
                    if (ss.getDeploymentStatus().equals("failed"))
                        TestUtil.logHarness("An error ocurred during deployment of apps in this directory:  "
                                + testDir + ".  Thus, all other tests in this directory will fail with the same error.");
                    return;
                }
                sLastTestDirectory = testDir;
                ss.doDeployment(testDir, pTestProps);
            } catch (TSDeploymentException de) {
                //already logged in SuiteSynchronizer
            } catch (TSJMSAdminException je) {
        TestUtil.logHarness(SEP + "\nAn error occurred during JMS topic/queue creation/removal\n" + SEP);
                je.printStackTrace();
            }
        }
    }

    public synchronized void finishedTest (TestResult tr) {
    if(!jtrOutput) {
        return;
    }
        TestDescription td = null;
        String sTestName = "";
        String sClassName = "";
        String sTestNameAndStatus = "";
        try {
            td = tr.getDescription();
        } catch (TestResult.Fault e) {
            e.printStackTrace();
        }
        sTestName = td.getParameter("id");
        sClassName = td.getParameter("classname");
        Status sTestStatus = tr.getStatus();

        if(executionMode == ExecutionMode.DEPLOY_RUN_UNDEPLOY
        || executionMode == ExecutionMode.RUN
        || executionMode == ExecutionMode.DEPLOY_RUN) {
            if (sTestStatus.getType() == Status.PASSED) {
                sTestNameAndStatus = "PASSED........" + sClassName.replace('.', '/') + ".java#" + sTestName;
                iPassedCount++;
            }
            else if (sTestStatus.getType() == Status.ERROR) {
                sTestNameAndStatus = "ERROR........" + sClassName.replace('.', '/') + ".java#" + sTestName;
                iErrorCount++;
            }
            else if (sTestStatus.getType() == Status.NOT_RUN) {
                sTestNameAndStatus = "NOT RUN........" + sClassName.replace('.', '/') + ".java#" + sTestName;
                iNotRunCount++;
            }
            else
            {
                sTestNameAndStatus = "FAILED........" + sClassName.replace('.', '/') + ".java#" + sTestName;
                iFailedCount++;
            }
            vTests.addElement(sTestNameAndStatus);
        iFinishedTests++;

        StringBuffer msg = new StringBuffer(400);
        msg.append(SEP2).append('\n');
        msg.append("Finished Test:  ").append(sTestNameAndStatus).append('\n');
            msg.append(SEP2).append('\n');
            msg.append("Number of tests completed:  ").append(iFinishedTests).append(" (");
        msg.append(iPassedCount).append(" passed, ").append(iFailedCount).append(" failed, ").append(iErrorCount).append(" with errors)");
        println(msg.toString());
        }
        else {
        if(executionMode == ExecutionMode.DEPLOY
        || executionMode == ExecutionMode.UNDEPLOY) {
            if ((sTestStatus.getType() == Status.PASSED) && (sTestStatus.getReason().equals("DEPLOYED"))) {
            iPassedCount++;
            }
            else if (sTestStatus.getType() == Status.ERROR) {
                iErrorCount++;
            }
            else if (sTestStatus.getType() == Status.NOT_RUN) {
                iNotRunCount++;
            }
            else {
                iFailedCount++;
            }
            }
        }
    }

    //------methods from TestResult.Observer----------------------------------
    public void createdSection (TestResult tr, TestResult.Section section) {}

    public void completedSection (TestResult tr, TestResult.Section section) {}

    public void createdOutput (TestResult tr, TestResult.Section section, String outputName) {}

    public void completedOutput (TestResult tr, TestResult.Section section, String outputName) {}

    public void updatedOutput (TestResult tr, TestResult.Section section, String outputName, int start,
            int end, String text) {
        print(text);
    }

    public void updatedProperty (TestResult tr, String name, String value) {}

    public void completed (TestResult tr) {}

    private void println (String msg) {
    if(jtrOutput) {
            System.out.println(msg);
        }
    }

    private void print (String msg) {
        if(jtrOutput) {
            System.out.print(msg);
        }
    }
}



