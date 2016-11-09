/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: TSNamingContextInterface.java 52683 2007-02-12 02:25:42Z lschwenk $
 */

package com.sun.ts.lib.util;

import java.util.*;

/**
 * TSNamingContextInterface provides the interface that must be
 * implemented to provide the implementation specific naming context
 * code needed to obtain the intial naming context and perform object
 * lookups.
 */
public interface TSNamingContextInterface
{
    public Object lookup(String s, Class c) throws Exception;
    public Object lookup(String s) throws Exception;
}
