/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: DogFactory.java 52683 2007-02-12 02:25:42Z lschwenk $
 */

package com.sun.ts.lib.deliverable.cts.resource;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;

/**
 * A simple factory class for creating custom JNDI resource of type 
 * com.sun.ts.lib.deliverable.cts.resource.Dog
 */
public class DogFactory implements ObjectFactory {
    
    public DogFactory() {
    }

    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) 
        throws Exception {
        Dog dog = Dog.getInstance();
        System.out.println("Creating a dog whose name is " + dog.getName()
                + ", and age is " + dog.getAge());
        return dog;
    }
}
