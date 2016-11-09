/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: TSDeployment.java 55283 2008-07-02 16:30:38Z kgrucci $
 */
 
package com.sun.ts.lib.porting;

import java.io.*;
import com.sun.ts.lib.deliverable.*;

/**
 * This is a factory class for creating instances of TSDeploymentInterface.
 * The implementation classes used are determined by the values of the 
 * porting package properties in TS_HOME/bin/ts.jte.
 *  
 * @author	Kyle Grucci
 */	
public class TSDeployment
{
	private static PropertyManagerInterface propMgr = null;
	public static int iPortingSet = 1;
	
	public static TSDeploymentInterface getDeploymentInstance(PrintWriter writer, String sClassName) throws Exception
	{
		return createInstance(sClassName, writer);
	}
	
	private static TSDeploymentInterface createInstance(String sClassName, PrintWriter writer) throws Exception
	{
		try
		{
			propMgr = DeliverableFactory.getDeliverableInstance().getPropertyManager();
			
			//create and initialize a new instance of the Deployment class
			Class c = Class.forName(propMgr.getProperty(sClassName));
			TSDeploymentInterface ctsDep1 = 
								(TSDeploymentInterface)c.newInstance();
			
			//set static prop so porting impls in the same VM can look it up
			iPortingSet = Integer.parseInt(sClassName.substring(sClassName.lastIndexOf(".")+1));
			
			//tell this 88 class which porting set of props we are using 
			//(1 or 2)
			//if(ctsDep1 instanceof com.sun.ts.lib.deliverable.cts.deploy.StandardDeployment14)
			//{
			    //((com.sun.ts.lib.deliverable.cts.deploy.StandardDeployment14)ctsDep1).setFirstLevelPortingSet(Integer.parseInt(sClassName.substring(sClassName.lastIndexOf(".")+1)));   
			//}
			
			ctsDep1.init(writer);
			
			return ctsDep1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
}
