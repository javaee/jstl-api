/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * @(#)TCKDeliverable.java	1.7 03/05/16
 */
 
package com.sun.ts.lib.deliverable.jsf;

import com.sun.ts.lib.deliverable.AbstractDeliverable;
import com.sun.ts.lib.deliverable.PropertyManagerInterface;
import com.sun.ts.lib.deliverable.tck.TCKPropertyManager;
import com.sun.javatest.TestEnvironment;

import java.util.Map;
import java.util.Properties;

/**
 * This class serves as a default implementation of the Deliverable interface
 * for a generic TCK.  TCKs are free to use this impl if it suits their needs.
 * Otherwise, it should be extended.
 *  
 * @author	Kyle Grucci
 */	
public class JSFDeliverable extends AbstractDeliverable
{
	public PropertyManagerInterface createPropertyManager(TestEnvironment te) throws Exception
	{
		return JSFPropertyManager.getTCKPropertyManager(te);
	}
	
	public PropertyManagerInterface createPropertyManager(Properties p) throws Exception
	{
		return JSFPropertyManager.getTCKPropertyManager(p);
	}
	
	public PropertyManagerInterface getPropertyManager() throws Exception
	{
		return JSFPropertyManager.getTCKPropertyManager();
	}
	
	public boolean supportsAutoDeployment()
	{
		return false;
	}
	
	public boolean supportsAutoJMSAdmin()
	{
		return false;
	}
	
	public boolean supportsInterop()
	{
		return false;
	}
	
	public Map getValidVehicles()
	{
		super.getValidVehicles();
		
		//add default values	
		htTSValidVehicles.put("tests.service_eetest.vehicles", new String[]{"standalone"});

		return htTSValidVehicles;
	}
}
