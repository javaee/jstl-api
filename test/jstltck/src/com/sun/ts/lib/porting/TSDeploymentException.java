/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: TSDeploymentException.java 52502 2007-01-24 02:50:22Z lschwenk $
 */


package com.sun.ts.lib.porting;

public class TSDeploymentException extends java.lang.Exception
{
	public TSDeploymentException()
	{
		super();
	}
	
	public TSDeploymentException(String s)
	{
		super(s);
	}
	
	public TSDeploymentException(String s, Throwable e)
	{
		super(s);
	}
}
