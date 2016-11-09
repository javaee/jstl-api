/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: TSNamingContext.java 55526 2008-07-30 18:11:14Z phendley $
 */

package com.sun.ts.lib.util;

import java.io.Serializable;
import java.rmi.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.PortableRemoteObject;

/**
 * TSNamingContext provides a wrapper for all lookups.
 */
public class TSNamingContext implements TSNamingContextInterface, Serializable
{

    Properties props = null;


    public TSNamingContext() throws Exception
    {
    }

    public TSNamingContext(Properties pp) throws Exception
    {
        if (pp != null) {
            props = pp;
        }
    }

	
    /**
     * Provides lookup of an object.
     *
     * @param s		object name to lookup
     * @param c		object class to narrow to if remote object
     *                  if null no narrow is performed.
     */
    public Object lookup(String s, Class c) throws Exception
    {
       Object o = lookup(s);
       return c == null? o: PortableRemoteObject.narrow(o, c);
    }

    /**
     * Provides lookup of an object.
     *
     * @param s		object name to lookup
     */
    public Object lookup(String s) throws Exception
    {
        if (props != null) {
            return new InitialContext(props).lookup(s);
        } else {
            return new InitialContext().lookup(s);
        }
    }

}
