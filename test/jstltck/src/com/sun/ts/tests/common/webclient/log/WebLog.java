/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: WebLog.java 53299 2007-04-27 18:01:30Z dougd $
 */
 
package com.sun.ts.tests.common.webclient.log;

import org.apache.commons.logging.impl.SimpleLog;
import com.sun.ts.lib.util.TestUtil;

public class WebLog extends SimpleLog {

    /**
     * Construct a simple log with given name.
     *
     * @param name log name
     */
    public WebLog(String name) {
        super(name);
    }

    /**
     * <p> Do the actual logging.
     * This method assembles the message
     * and then prints to <code>System.err</code>.</p>
     */
    protected void log(int type, Object message, Throwable t) {
        StringBuffer buf = new StringBuffer(64);
        // append log type
        buf.append("[WIRE] - ");

        // append the message
        buf.append(String.valueOf(message));

        if (t == null) {
            TestUtil.logTrace(buf.toString());
        } else {
            TestUtil.logTrace(buf.toString(), t);
        }
    }
}
