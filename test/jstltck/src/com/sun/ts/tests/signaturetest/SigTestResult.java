/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: SigTestResult.java 52499 2007-01-24 02:14:03Z lschwenk $
 */
package com.sun.ts.tests.signaturetest;

import java.util.*;
import java.io.Serializable;

public class SigTestResult implements Serializable {

    private static final String NL = System.getProperty("line.separator", "\n");

    private List failedPkgs = new ArrayList();
    private List passedPkgs = new ArrayList();
    private List failedClasses = new ArrayList();
    private List passedClasses = new ArrayList();


    // ---------------------------------------------------------- Public Methods


    public synchronized boolean passed() {

        return (failedPkgs.size() == 0 && failedClasses.size() == 0);

    } // end passed


    public synchronized void addFailedPkg(String pkg) {

        failedPkgs.add(pkg);

    } // END addFailedPkg


    public synchronized void addPassedPkg(String pkg) {

        passedPkgs.add(pkg);

    } // END addPassedPkg


    public synchronized void addFailedClass(String className) {

        failedClasses.add(className);

    } // END addFailedClass


    public synchronized void addPassedClass(String className) {

        passedClasses.add(className);

    } // END addPassedClass


    public String toString() {

        String delim =
            "******************************************************" + NL;
        if (!pkgsTested() && !classesTested()) {
            return (delim
                   + "******** No packages or classes were tested **********"
                   + NL
                   + delim);
        }
        StringBuffer buf = new StringBuffer();
        buf.append(delim);
        buf.append(delim);
        if (passed()) {
            buf.append("All package signatures passed.").append(NL);
        } else {
            buf.append("Some signatures failed.").append(NL);
            if (failedPkgs.size() > 0) {
                buf.append("\tFailed packages listed below: ").append(NL);
                formatList(failedPkgs, buf);
            }
            if (failedClasses.size() > 0) {
                buf.append("\tFailed classes listed below: ").append(NL);
                formatList(failedClasses, buf);
            }
        }
        if (passedPkgs.size() > 0) {
            buf.append("\tPassed packages listed below: ").append(NL);
            formatList(passedPkgs, buf);
        }
        if (passedClasses.size() > 0) {
            buf.append("\tPassed classes listed below: ").append(NL);
            formatList(passedClasses, buf);
        }
        buf.append("\t");
        buf.append(delim);
        buf.append(delim);
        return buf.toString();

    } // END toString


    // --------------------------------------------------------- Private Methods


    private synchronized void formatList(List list, StringBuffer buf) {

        synchronized (this) {
            for (int i = 0; i < list.size(); i++) {
                String pkg = (String) (list.get(i));
                buf.append("\t\t").append(pkg).append(NL);
            }
        }

    } // END formatList


    private synchronized boolean pkgsTested() {

        return (failedPkgs.size() != 0 || passedPkgs.size() != 0);

    } // END pkgsTested


    private synchronized boolean classesTested() {

        return (failedClasses.size() != 0 || passedClasses.size() != 0);

    } // END classesTested


} // end class SigTestResult
