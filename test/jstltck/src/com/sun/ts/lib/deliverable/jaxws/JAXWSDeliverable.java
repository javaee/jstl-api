/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: JAXWSDeliverable.java 51048 2003-04-11 11:11:09Z lschwenk $
 */
 
package com.sun.ts.lib.deliverable.jaxws;

import com.sun.ts.lib.deliverable.AbstractDeliverable;
import com.sun.ts.lib.deliverable.PropertyManagerInterface;
import com.sun.javatest.TestEnvironment;

import java.util.Map;
import java.util.Properties;

/**
 * This class serves as a default implementation of the Deliverable interface
 * for the jaxws TCK.  TCKs are free to use this impl if it suits their needs.
 * Otherwise, it should be extended.
 *  
 */	
public class JAXWSDeliverable extends com.sun.ts.lib.deliverable.tck.TCKDeliverable
{
	public PropertyManagerInterface createPropertyManager(TestEnvironment te) throws Exception
	{
		return JAXWSPropertyManager.getJAXWSPropertyManager(te);
	}
	
	public PropertyManagerInterface createPropertyManager(Properties p) throws Exception
	{
		return JAXWSPropertyManager.getJAXWSPropertyManager(p);
	}
	
	public PropertyManagerInterface getPropertyManager() throws Exception
	{
		return JAXWSPropertyManager.getJAXWSPropertyManager();
	}
	
	public boolean supportsInterop()
	{
		return true;
	}
	
}
