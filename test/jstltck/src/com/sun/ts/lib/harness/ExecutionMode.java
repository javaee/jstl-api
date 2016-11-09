/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * @(#)ExecutionMode.java	1.5   05/09/19
 */

package com.sun.ts.lib.harness;

import com.sun.ts.lib.deliverable.PropertyManagerInterface;
import com.sun.ts.lib.util.TestUtil;
import java.util.*;
import java.io.*;

public class ExecutionMode {
    public final static int DEPLOY_RUN_UNDEPLOY =  0;
    public final static int DEPLOY =  1;
    public final static int RUN =  2;
    public final static int UNDEPLOY = 3;
    public final static int DEPLOY_RUN = 4;
    public final static int DEFAULT = DEPLOY_RUN_UNDEPLOY;

    private ExecutionMode() {}
    
    /**
     * gets the current execution mode from PropertyManagerInterface or
     * from a system property if overridden on the commandline.
     * Note that current execution mode is not cached since harness.executeMode
     * property may change between test executions.
     *
     * @param propMgr an implementation of PropertyManagerInterface.
     * @return an int representing one of the 5 modes
     */
    public static int getExecutionMode(PropertyManagerInterface propMgr) {
	int mode = (Integer.getInteger("harness.executeMode", -1)).intValue();
	
	if(mode == -1)
	{
	    if(propMgr != null)
            {
		String modeS = propMgr.getProperty("harness.executeMode", "");
                try {
                    mode = Integer.parseInt(modeS);
                } catch (Exception e) {
                    mode = DEFAULT;
                }
            }
            else
            {
                throw new Error("PropertyManager is null.  Please pass in a valid PropertyManager");
            }
	
        }

	if(mode < DEPLOY_RUN_UNDEPLOY || mode > DEPLOY_RUN) {
	    TestUtil.logHarness("harness.executeMode in ts.jte: " + mode
     	    + " is not valid. Will use default " + DEFAULT + ".");
	    mode = DEFAULT;
	}

	TestUtil.logHarness("harness.executeMode is set to \"" + mode + "\"");
	return mode;
    }

}
