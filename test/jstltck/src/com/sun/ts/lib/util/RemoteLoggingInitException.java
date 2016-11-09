/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: RemoteLoggingInitException.java 52683 2007-02-12 02:25:42Z lschwenk $
 */
 
package com.sun.ts.lib.util;

/**
 * This exception is thrown by the init method of the TestUtil class, if
 * anything goes wrong while establishing a socket connection back to
 * the harness host.
 *  
 * @author	Kyle Grucci
 */	
public class RemoteLoggingInitException extends java.lang.Exception
{
	/**
	 * creates a RemoteLoggingInitException
	 */
	public RemoteLoggingInitException()
	{
		super();
	}
	
	/**
	 * creates a RemoteLoggingInitException with a message
	 * 
	 * @param	s	the message
	 */
	public RemoteLoggingInitException(String s)
	{
		super(s);
	}
}



