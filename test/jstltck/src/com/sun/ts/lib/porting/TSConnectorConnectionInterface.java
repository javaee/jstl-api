/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: TSConnectorConnectionInterface.java 52502 2007-01-24 02:50:22Z lschwenk $
 */

package com.sun.ts.lib.porting;


import java.io.*;



/**
 * This is the TSConnectorConnectionInterface.  An implementation of this interface must
 * be provided by each standalone Connector client implementation, to support their own 
 * connection semantics.
 *  
 * @author	Sun Microsystems
 */
public interface TSConnectorConnectionInterface
{

    /**
     * Initializes a new TSDeployment instance.  All output should be printed
     * to this PrintWriter.  All properties in the ts.jte file are accessible
     * to this porting implementation class only via the TSPropertyManager
     * class.  Please see Sun's implementation of this method for an example.
     *
     * @param       writer   The PrintWriter that should be used to log output.
     */
    public void init(PrintWriter writer);



    /**
     * 
     * This will return an instance from the connection factory for the RAs specified
     * by the RAName.  The instance returned should be an instance item that is
     * contained in the connection factory for the specified RA.  
     *
     * @param  RAName  The resource adapter we are trying to lookup.
     *                 This will correspond to one of the values in the ts.jte
     *                 for the resource adapter JNDI name bindings (eg whitebox-tx,
     *                 whitebox-notx-param, etc)
     *
     * @return Object  The returned object should be a representation of the object type
     *                 corresponding to the ConnectionFactory instances.  As an example,
     *                 for a RAName = whitebox-tx, this lookup would return an Object that
     *                 can be cast to a TSEISDataSource/TSDataSource.
     */
    public Object getRARDataSource(String RAName) throws Exception;

}
