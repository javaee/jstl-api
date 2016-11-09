/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: TSURLInterface.java 52502 2007-01-24 02:50:22Z lschwenk $
 */


package com.sun.ts.lib.porting;

import java.net.*;

/**
  * An implementation of the TSURLInterface is to be used for J2EE-TS testing.
  * TS tests use this interface to obtain the URL String to use to access a 
  * given web component.  If a given J2EE Server implmentation requires that
  * URLs be created in a different manner, then this implementation can be 
  * replaced. 
  *
  * @author Kyle Grucci
  */
public interface TSURLInterface
{
	/**
	  * This method is called by TS tests to get the URL to use to access a
	  * given web component.
	  *
	  * @param       protocol - the name of the protocol.
	  * @param 		 host - the name of the host.
	  * @param 		 port - the port number.
	  * @param 		 file - the host file.
	  * @return      a valid URL object.
	  */
	public URL getURL(String protocol, String host, int port,
					 String file) throws MalformedURLException;

	/**
	  * This method is called by TS tests to get the URL to use to access a
	  * given web component.
	  *
	  * @param       protocol - the name of the protocol.
	  * @param 		 host - the name of the host.
	  * @param 		 port - the port number.
	  * @param 		 file - the host file.
	  * @return      a valid URL as a String.
	  */
	public String getURLString(String protocol, String host, int port,
					 String file);
					 
	/**
	  * This method is called by TS tests to get the request to use to
	  * access a given web component.
	  *
	  * @param	request - the request file.
	  * @return	a valid String object.
	  */
	public String getRequest(String request);
}




