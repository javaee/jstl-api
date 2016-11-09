/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: SigLogIntf.java 52683 2007-02-12 02:25:42Z lschwenk $
 */

package com.sun.ts.lib.util;

/**
 * This interface defines the API necessary for a signature verification
 * application to log status messages, errors and debug messages to a
 * common output repository.  This interface will be used by the API
 * check tool to log messages to the CTS output framework (namely the
 * output methods defined in the TestUtil class).  This interface will
 * be implemented by an adapter class that will adapt the API
 * defined in this interface to the logging API used by CTS test code.
 */
public interface SigLogIntf {

    public void println(String msg);

    public void println(Object obj);

    public void println(char c);

    public void println();
 
    public void print(String msg);

    public void print(Object obj);

    public void print(char c);

    public void flush(); // nop

    public void close(); // nop

}
