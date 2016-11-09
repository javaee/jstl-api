/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: JBIDeliverable.java 51067 2002-08-26 16:51:40Z lschwenk $
 */
 
package  com.sun.ts.lib.deliverable.jbi;

import com.sun.ts.lib.deliverable.tck.TCKDeliverable;
import com.sun.ts.lib.deliverable.PropertyManagerInterface;
import com.sun.javatest.TestEnvironment;
import java.util.Properties;
import java.util.Map;

/**
 * This class serves as a default implementation of the Deliverable interface
 * for the JBI TCK. 
 */	
public class JBIDeliverable extends TCKDeliverable
{
	public PropertyManagerInterface createPropertyManager(TestEnvironment te) throws Exception
	{
		return JBIPropertyManager.getJBIPropertyManager(te);
	}
	
	public PropertyManagerInterface createPropertyManager(Properties p) throws Exception
	{
		return JBIPropertyManager.getJBIPropertyManager(p);
	}
	
	public PropertyManagerInterface getPropertyManager() throws Exception
	{
		return JBIPropertyManager.getJBIPropertyManager();
	}
}
