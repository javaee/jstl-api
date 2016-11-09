/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: StandardDeployment14ServerInterface.java 52683 2007-02-12 02:25:42Z lschwenk $
 */

package com.sun.ts.lib.deliverable.cts.deploy;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;
import java.io.*;
import java.net.*;
import com.sun.ts.lib.util.*;
import com.sun.ts.lib.porting.*;


public interface StandardDeployment14ServerInterface extends java.rmi.Remote
{
	public void init(Properties jteProps, Map extraProps) 
	                                          throws java.rmi.RemoteException;
	public String deploy(DeploymentInfo info) throws java.rmi.RemoteException;
	public void undeploy(Properties p) throws java.rmi.RemoteException;
	public boolean isDeployed(Properties p) throws java.rmi.RemoteException;
}




