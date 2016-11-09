/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: TSJMSAdminException.java 52502 2007-01-24 02:50:22Z lschwenk $
 */

package com.sun.ts.lib.porting;

public class TSJMSAdminException extends java.lang.Exception
{
	public TSJMSAdminException()
	{
		super();
	}
	
	public TSJMSAdminException(String s)
	{
		super(s);
		System.out.println(s);
	}
	
	public TSJMSAdminException(String s, Throwable e)
	{
		super(s);
		System.out.println(s);
		e.printStackTrace();
	}
}
