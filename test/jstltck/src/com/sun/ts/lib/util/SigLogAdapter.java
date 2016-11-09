/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: SigLogAdapter.java 52683 2007-02-12 02:25:42Z lschwenk $
 */

package com.sun.ts.lib.util;

/**
 * This class acts as an adapter between the logging API used in the
 * API check utility and the logginf API available in the CTS harness.
 * The API check utility uses a PrintWriter to log messages.  The parts
 * of the PrintWriter API used by the API check utility will be
 * translated to TestUtil calls in this class.  The SigLogIntf will
 * capture the parts of the PrintWriter API that need to be reimplemented
 * so API check can fit into the CTS test framework.
 */
public class SigLogAdapter implements SigLogIntf {

    private static final String NL = System.getProperty("line.separator", "\n");

    private boolean dumpMessagesToStdErr;

    public SigLogAdapter() {
	String useStdErr = System.getProperty("dump.api.check.stderr", "false");
	if (useStdErr.equalsIgnoreCase("true")) {
	    dumpMessagesToStdErr = true;
	}
    }

    public void println(String msg) {
	print(msg + NL);
    }

    public void println(Object obj) {
	print(obj.toString() + NL);
    }

    public void println(char c) {
	print(c);
	println();
    }

    public void println() {
	print(NL);
    }

    public void print(String msg) {
	if (dumpMessagesToStdErr) {
	    System.err.println(msg);
	} else {
	    TestUtil.logMsg(msg);
	}
    }

    public void print(Object obj) {
	print(obj.toString());
    }

    public void print(char c) {
	char[] chars = new char[] {c};
	print(new String(chars));
    }

    public void flush() {
	// do nothing unless there is an equivalent call in TestUtil
	// to flush the output stream	
    }

    public void close() {
	// do nothing unless there is an equivalent call in TestUtil
	// to close the output stream
    }

}
