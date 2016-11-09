/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: JMSDeliverable.java 51081 2003-03-12 12:42:30Z lschwenk $
 */
 
package com.sun.ts.lib.deliverable.jms;

import com.sun.ts.lib.deliverable.AbstractDeliverable;
import com.sun.ts.lib.deliverable.PropertyManagerInterface;
import com.sun.javatest.TestEnvironment;

import java.util.Map;
import java.util.Properties;
import java.util.Hashtable;


/**
 * This class serves as a well known place for harness, util, and porting 
 * classes to retrieve property values.
 *  
 * @author	Dianne Jiao
 */	
public class JMSDeliverable extends AbstractDeliverable
{	
	public PropertyManagerInterface createPropertyManager(TestEnvironment te) throws Exception
	{
		return JMSPropertyManager.getJMSPropertyManager(te);
	}
	
	public PropertyManagerInterface createPropertyManager(Properties p) throws Exception
	{
		return JMSPropertyManager.getJMSPropertyManager(p);
	}
	
	public PropertyManagerInterface getPropertyManager() throws Exception
	{
		return JMSPropertyManager.getJMSPropertyManager();
	}
	
	public boolean supportsAutoDeployment()
	{
		return false;
	}

	public boolean supportsInterop()
	{
		return false;
	}

    public Map getValidVehicles()
    {
       
        if(htTSValidVehicles == null)
        {
            // TS hash table
            htTSValidVehicles = new Hashtable();

            //add default values
            htTSValidVehicles.put("tests.service_eetest.vehicles", new String[]{"standalone"});

        }
        return htTSValidVehicles;
    }


}
