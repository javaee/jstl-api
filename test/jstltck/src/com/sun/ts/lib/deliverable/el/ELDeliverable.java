/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id$
 */
 
package com.sun.ts.lib.deliverable.el;

import com.sun.ts.lib.deliverable.AbstractDeliverable;
import com.sun.ts.lib.deliverable.PropertyManagerInterface;
import com.sun.ts.lib.deliverable.el.ELPropertyManager;
import com.sun.javatest.TestEnvironment;

import java.util.Map;
import java.util.Properties;


public class ELDeliverable extends AbstractDeliverable
{
	public PropertyManagerInterface createPropertyManager(TestEnvironment te) throws Exception
	{
		return ELPropertyManager.getTCKPropertyManager(te);
	}
	
	public PropertyManagerInterface createPropertyManager(Properties p) throws Exception
	{
		return ELPropertyManager.getTCKPropertyManager(p);
	}
	
	public PropertyManagerInterface getPropertyManager() throws Exception
	{
		return ELPropertyManager.getTCKPropertyManager();
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
