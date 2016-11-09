/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: TSHttpsURLConnectionInterface.java 52502 2007-01-24 02:50:22Z lschwenk $
 */

/*
 * @(#)TSHttpsURLConnectionInterface.java	1.5 02/06/17
 */

package com.sun.ts.lib.porting;

import java.io.*;
import java.net.*;

/**
 * TSHttpsURLConnection provides the HTTPS specific featurs  
 *
 */
public interface TSHttpsURLConnectionInterface
{
	/**
        *  Sets the value  of the doInput field for this Connection 
 	*
	*  @param doInput - the new value (the default is false)
	*/
	public void setDoInput(boolean doInput) ;

	/**
	*  Sets the value  of the doOutput field for this Connection 
	*
	*  @param doOutput - the new value (the default is false)
	*/
	public void setDoOutput(boolean doOutput) ;

	/**
	*  Sets the value  of the useCaches field for this Connection 
	*  If the UseCaches flag on the connection is true, the connection
	*  is allowed to use whatever caches it can. If false, caches are to
	*  be ignored. The default value is set to true 
	*
	*  @param usecaches - the new value (the default is true)
	*/
	public void setUseCaches(boolean usecaches) ;

	/**
	*  Sets the general request property.
	*  If a property with the key already exists, overwrite its
	*  value with the new value.
	*
	*  @param key   - the keyword by which the request is known 
	*  @param value - the value associated with it
        */
	public void setRequestProperty(String key, String value);

	/**
	*  Returns the value of the named header field.
	*  If called on a connection that sets the same header multiple times
	*  only the last value is returned.
	* 
	*  @param name       - the name of the header field. 
	*  @return String    - the value of the named header field, or null 
	*                      if there is no such field in the header. 
	*/
	public String getHeaderField(String name);


	/**
	*  Returns the value for the nth header field. It returns null 
	*  if there are fewer than n fields
	*  
	*  @param num     - Integer num 
	*  @return String - returns the value of the nth header field
	*/
	public String getHeaderField(int num);

	/**
	*  Disconnect connection
	*/
	public void disconnect();

	/**
	*  Returns an input stream that reads from the open connection
	* 
	*  @return InputStream - inputStream  
	*/
	public InputStream getInputStream() throws IOException;

	/**
	*  Returns an Output stream that writes to the open connection
	* 
	*  @return OutputStream - OutputStream  
	*/
	public OutputStream getOutputStream() throws IOException;


	/**
	*  Initializes HttpsURLConnection 
	*  
	*  @param url  url used to open HttpsURLConnection 
	*/
	public void init(URL url) throws IOException;

}
