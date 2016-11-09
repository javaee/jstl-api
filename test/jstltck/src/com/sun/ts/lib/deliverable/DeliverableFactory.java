/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: DeliverableFactory.java 52683 2007-02-12 02:25:42Z lschwenk $
 */


package  com.sun.ts.lib.deliverable;

import  java.util.*;
import  java.io.*;
import  com.sun.ts.lib.util.*;


/**
 * This is a factory class for creating instances of TSDeploymentInterface.
 * The implementation classes used are determined by the values of the
 * porting package properties in TS_HOME/bin/ts.jte.
 *
 * @author	Kyle Grucci
 */
public class DeliverableFactory {
    private static DeliverableInterface di;

    public static DeliverableInterface getDeliverableInstance () throws Exception {
        if (di == null)
            di = createInstance();
        return  di;
    }

    public static DeliverableInterface getDeliverableInstance (ClassLoader classLoader) throws Exception {
        if (di == null)
            di = createInstance(classLoader);
        return  di;
    }

    private static DeliverableInterface createInstance () throws Exception {
        return  createInstance(null);
    }

    private static DeliverableInterface createInstance (ClassLoader classLoader) throws Exception {
        try {
            //get property value from within the ts specific properties file
            String sClassName = System.getProperty("deliverable.class");
            //create and initialize a new instance of the Deployment class
            Class c = null;
            if (classLoader == null) {
                c = Class.forName(sClassName);
            }
            else {
                c = Class.forName(sClassName, true, classLoader);
            }
            return  (DeliverableInterface)c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw  e;
        }
    }
}



