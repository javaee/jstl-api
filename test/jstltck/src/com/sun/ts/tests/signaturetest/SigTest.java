/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: SigTest.java 55409 2008-07-22 01:59:38Z kgrucci $
 */

package com.sun.ts.tests.signaturetest;

import java.util.Properties;

import com.sun.ts.lib.harness.EETest;
import com.sun.ts.lib.util.TestUtil;

/**
 * This class should be extended by TCK developers that wish to create a set of
 * signature tests that run outside of any Java EE container.  Developers must
 * implement the getPackages method to specify which packages are to be tested
 * by the signature test framework.
 */
public abstract class SigTest extends EETest {

    protected SignatureTestDriver driver;


    /**
     * <p>Returns a {@link SignatureTestDriver} appropriate for the particular
     * TCK (using API check or the Signature Test Framework).</p>
     *
     * <p>The default implementation of this method will return a
     * {@link SignatureTestDriver} that will use API Check.  TCK developers
     * can override this to return the desired {@link SignatureTestDriver}
     * for their TCK.
     */
    protected SignatureTestDriver getSigTestDriver() {

        if (driver == null) {
            driver = SignatureTestDriverFactory.
                     getInstance(SignatureTestDriverFactory.SIG_TEST);
        }

        return driver;

    } // END getSigTestDriver

    /**
     * Returns the location of the package list file.  This file denotes
     * the valid sub-packages of any package being verified in the signature
     * tests.
     *
     * Sub-classes are free to override this method if they use a different
     * path or filename for their package list file.  Most users should
     * be able to use this default implementation.
     *
     * @return String The path and name of the package list file.
     */
    protected String getPackageFile() {
        return getSigTestDriver().getPackageFileImpl(testInfo.getBinDir());
    }

    /**
     * Returns the path and name of the signature map file that this
     * TCK uses when conducting signature tests.  The signature map
     * file tells the signature test framework which API versions of
     * tested packages to use.  To keep this code platform independent,
     * be sure to use the File.separator string (or the File.separatorChar)
     * to denote path separators.
     *
     * Sub-classes are free to override this method if they use a different
     * path or filename for their signature map file.  Most users should
     * be able to use this default implementation.
     *
     * @return String The path and name of the signature map file.
     */
    protected String getMapFile() {
        return getSigTestDriver().getMapFileImpl(testInfo.getBinDir());
    }

    /**
     * Returns the directory that contains the signature files.
     *
     * Sub-classes are free to override this method if they use a different
     * signature repository directory.  Most users should be able to use this
     * default implementation.
     *
     * @return String The signature repository directory.
     */
    protected String getRepositoryDir() {
        return getSigTestDriver().getRepositoryDirImpl(testInfo.getTSHome());
    }


    /**
     * Returns the list of packages that must be tested by the siganture
     * test framework.  TCK developers must implement this method in their
     * signature test sub-class.
     *
     * @return String A list of packages that the developer wishes to test
     *         using the signature test framework.
     */
    protected abstract String[] getPackages();


    /**
     * Returns an array of individual classes that must be tested by the
     * signature test framwork.  TCK developers may override this method
     * when this functionality is needed.  Most will only need package
     * level granularity.
     *
     * @return an Array of Strings containing the individual classes the
     *  framework should test.  The default implementation of this method
     *  returns a zero-length array.
     */
    protected String[] getClasses() {

        return new String[] { };

    } // END getClasses


    protected SigTestData testInfo; // holds the bin.dir property

    /**
     * Called by the test framework to initialize this test.  The method simply
     * retrieves some state information that is necessary to run the test when
     * when the test framework invokes the run method (actually the test1 method).
     *
     * @param args List of arguments passed to this test.
     * @param p Properties specified by the test user and passed to this
     *        test via the test framework.
     * @throws Fault When an error occurs reading or saving the state information
     *         processed by this method.
     */
    public void setup(String[] args, Properties p) throws Fault {
        try {
            TestUtil.logTrace("$$$ SigTest.setup() called");
            this.testInfo = new SigTestData(p);
            TestUtil.logTrace("$$$ SigTest.setup() complete");
        } catch (Exception e) {
            logErr("Unexpected exception " + e.getMessage());
            throw new Fault("setup failed!", e);
        }
    }

    /**
     * Called by the test framework to run this test.  This method utilizes the
     * state information set in the setup method to run the signature tests.
     * All signature test code resides in the utility class so it can be reused
     * by the signature test framework base classes.
     *
     * @throws Fault When an error occurs executing the signature tests.
     */
    public void signatureTest() throws Fault {
        TestUtil.logTrace("$$$ SigTest.test1() called");
        SigTestResult results = null;
        String mapFile = getMapFile();
        String repositoryDir = getRepositoryDir();
        String[] packages = getPackages();
        String[] classes = getClasses();
        String packageFile = getPackageFile();
        String testClasspath = testInfo.getTestClasspath();
        try {
            results = getSigTestDriver().executeSigTest(packageFile,
                                                        mapFile,
                                                        repositoryDir,
                                                        packages,
                                                        classes,
                                                        testClasspath);
            TestUtil.logMsg(results.toString());
            if (!results.passed()) {
                TestUtil.logTrace("results.passed() returned false");
                throw new Exception();
            }
            TestUtil.logTrace("$$$ SigTest.test1() returning");
        } catch (Exception e) {
            if (results != null && !results.passed()) {
                throw new Fault("SigTest.test1() failed!, diffs found");
            } else {
                TestUtil.logErr("Unexpected exception " + e.getMessage());
                throw new Fault("test1 failed with an unexpected exception", e);
            }
        }
    }

    /**
     * Called by the test framework to cleanup any outstanding state.  This method
     * simply passes the message through to the utility class so the implementation
     * can be used by both framework base classes.
     *
     * @throws Fault When an error occurs cleaning up the state of this test.
     */
    public void cleanup() throws Fault {
        TestUtil.logTrace("$$$ SigTest.cleanup() called");
        try {
            getSigTestDriver().cleanupImpl();
            TestUtil.logTrace("$$$ SigTest.cleanup() returning");
        } catch (Exception e) {
            throw new Fault("Cleanup failed!", e);
        }
    }

} // end class SigTest
