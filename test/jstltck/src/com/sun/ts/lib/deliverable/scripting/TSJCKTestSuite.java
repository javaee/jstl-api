/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 *  $Id: TSJCKTestSuite.java 51044 2003-04-03 11:41:14Z lschwenk $
 */

package com.sun.ts.lib.deliverable.scripting;

import java.util.*;
import java.io.*;
import com.sun.javatest.*;
import com.sun.interview.Interview;
import com.sun.ts.lib.javatest.*;

public class TSJCKTestSuite extends com.sun.jck.lib.JCKTestSuite {

    public TSJCKTestSuite(File root, Map tsInfo, ClassLoader cl) throws Fault {
        super(root, tsInfo, cl);
    }

    @Override
    public InterviewParameters createInterview() {
        InterviewParameters ctsInterv = null;
        try {
            ctsInterv = new TSLegacyParameters(this);
        } catch (Interview.HelpNotFoundFault f) {
            System.out.println("TS.createInterview() couldn't find help files.");
        } catch (Interview.BadHelpFault bf) {
            System.out.println("TS.createInterview() found invalid help files.");
        } catch (Exception ep) {
            System.out.println("TS.createInterview()" + ep.toString());
            ep.printStackTrace();
        }
        return ctsInterv;
    }

}
