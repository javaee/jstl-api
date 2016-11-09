/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */


/*
 *  @(#)sigtest.basic.test.xml	1.17 06/06/15 Serguei L. Ivashin
 * Generated from : api/signaturetest/sigtest.basic.test.xml
 *
 * API Signature verification of the J2SE API (basic)
 */

package javasoft.sqe.tests.api.signaturetest.JCKSigTest;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javasoft.sqe.javatest.Status;
import javasoft.sqe.javatest.lib.MultiTest;


public class basicTests extends MultiTest {

//==========================================================================
	    
    com.sun.javatest.Test sigtest = new com.sun.tdk.signaturetest.Test();
    
    ArrayList opts = new ArrayList();
    static final String sigdir = "sig/";
    

    // Arguments are processed in testcases.
    protected int decodeArg (String[] args, int index) throws SetupException {
        String s = args[index];
        if (s.equalsIgnoreCase("-TestURL") ||
            s.equalsIgnoreCase("-Classpath") ||
            s.equalsIgnoreCase("-ExcludeSig")) {
            opts.add(s);
            opts.add(args[index+1]);
            return 2;
        }
        else if (s.equalsIgnoreCase("-static")) {
            opts.add(s);
            return 1;
        }
        else {
            return super.decodeArg(args, index);
        }
    }
    
    
    protected Status tester (String pack, String params) {
        ArrayList tmp = new ArrayList(opts);

    //  add "-FileName xxx"
        tmp.add("-FileName");
        tmp.add(sigdir + pack);

    //  add "-Package xxx"
        for (StringTokenizer st = new StringTokenizer(params); st.hasMoreTokens();) 
            tmp.add(st.nextToken());
    
    //  pack arguments in array of string
        String[] args = (String[])tmp.toArray(new String[tmp.size()]);
        
    //  run the sigtest
        com.sun.javatest.Status s = sigtest.run(args, super.log, super.ref);
        return new Status(s.getType(), s.getReason());
    }
    
//==========================================================================

    /* standalone interface */
    public static void main(String argv[]) {
        basicTests test = new basicTests();
        test.run(argv, System.err, System.out).exit();
    }

    /**
     * Assertion testing
     * for Basic signature tests,
     * Verifying the package 'javax.script'.
     * <br><b>Expected results</b>: Test should pass
     */
    public Status javax_script() {
        return tester("j2se60_javax_script.sig", "-Package javax.script");

            }
}
