/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: ApiCheckDriver.java 52499 2007-01-24 02:14:03Z lschwenk $
 */
package com.sun.ts.tests.signaturetest;

import java.io.Serializable;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class ApiCheckDriver
    extends SignatureTestDriver
    implements Serializable {


    /* flags for the Diff utility argument list */
    private static final String BASE_FLAG = "-base";
    private static final String TEST_FLAG = "-test";
    private static final String PACKAGE_FLAG = "-package";
    private static final String EXPACKAGE_FLAG = "-expackage";
    private static final String REFLECT_FLAG = "-reflect";
    private static final String CONST_FLAG = "-constvalues";

    // ---------------------------------------- Methods from SignatureTestDriver

    protected String normalizeFileName(File f) {
	return f.getPath();
    }


    protected String[] createTestArguments(String packageListFile,
                                           String mapFile,
                                           String signatureRepositoryDir,
                                           String packageOrClassUnderTest,
                                           String classpath,
                                           boolean bStaticMode) throws Exception {

        Class pkgListClass = Class.forName("javasoft.sqe.apiCheck.PackageList");
        Constructor pkgCtor =
            pkgListClass.getDeclaredConstructor(new Class[] { String.class });
        Object pkgInstance =
            pkgCtor.newInstance(new Object[] { packageListFile });

        Method pkgMethod =
            pkgListClass.getDeclaredMethod("getSubPackagesFormatted",
                                           new Class[] { String.class});

        String excludePkgs = (String)
            pkgMethod.invoke(pkgInstance,
                             new Object[] { packageOrClassUnderTest });

        List sigArgsList = new LinkedList();

        sigArgsList.add(BASE_FLAG);
        sigArgsList.add(getSigFileInfo(
                            packageOrClassUnderTest,
                            mapFile,
                            signatureRepositoryDir).getFile());

        if (classpath != null && classpath.length() > 0) {
            sigArgsList.add(TEST_FLAG);
            sigArgsList.add(classpath);
        }

        sigArgsList.add(REFLECT_FLAG);
        sigArgsList.add(CONST_FLAG);
        sigArgsList.add(PACKAGE_FLAG);
        sigArgsList.add(packageOrClassUnderTest);

        if (excludePkgs != null && excludePkgs.length() > 0) {
            sigArgsList.add(EXPACKAGE_FLAG);
            sigArgsList.add(excludePkgs);
        }

        return (String[]) (sigArgsList.toArray(new String[sigArgsList.size()]));

    } // END createTestArguments


    protected boolean runSignatureTest(String packageOrClassName,
                                    String[] testArguments) throws Exception {

        Class diffClass = Class.forName("javasoft.sqe.apiCheck.Diff");
        Method mainMethod =
            diffClass.getDeclaredMethod("main",
                                        new Class[] { String[].class });
        mainMethod.invoke(null, new Object[] { testArguments });

        Method diffMethod = diffClass.getDeclaredMethod("diffsFound", 
                                                        new Class[] {});
        return (!((Boolean) diffMethod.invoke(null, 
                                              new Object[] {})).booleanValue());        

    } // END runSignatureTest

} // END ApiCheckDriver
