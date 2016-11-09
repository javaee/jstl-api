/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: StandaloneDeliverable.java 52683 2007-02-12 02:25:42Z lschwenk $
 */
 
package com.sun.ts.lib.deliverable.standalone;

import com.sun.ts.lib.deliverable.AbstractDeliverable;
import com.sun.ts.lib.deliverable.PropertyManagerInterface;
import com.sun.javatest.TestEnvironment;

import java.util.Map;
import java.util.Properties;

/**
 * This class serves as a default implementation of the Deliverable interface
 * for a standalone TCK.  TCKs are free to use this impl if it suits their needs.
 * Otherwise, it should be extended.
 *  
 * @author	Kyle Grucci
 */	
public class StandaloneDeliverable extends AbstractDeliverable
{
	public PropertyManagerInterface createPropertyManager(TestEnvironment te) throws Exception
	{
		return StandalonePropertyManager.getStandalonePropertyManager(te);
	}
	
	public PropertyManagerInterface createPropertyManager(Properties p) throws Exception
	{
		return StandalonePropertyManager.getStandalonePropertyManager(p);
	}
	
	public PropertyManagerInterface getPropertyManager() throws Exception
	{
		return StandalonePropertyManager.getStandalonePropertyManager();
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
