/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: TSConnectorConnectionInterface.java 52502 2007-01-24 02:50:22Z lschwenk $
 */

package com.sun.ts.lib.porting;


import java.io.*;

import com.sun.ts.lib.deliverable.*;



/**
 * This class acts as a Factory object for creating an implementation specific
 * instance of the TSConnectorConnectionInterface based on the value of the ts.jte
 * property, porting.ts.connectorConnection.class
 *
 * @author	Sun Microsystems
 */
public class TSConnectorConnection 
{
    private static PropertyManagerInterface propMgr = null;


    public static TSConnectorConnectionInterface getConnectorConnectionInstance(
                                      PrintWriter writer,
                                      String sClassName) throws Exception {

        TSConnectorConnectionInterface ctsCtr = null;

        try {
            propMgr = DeliverableFactory.getDeliverableInstance().getPropertyManager();

            System.out.println("TSConnectorConnection:  sClassname = " +sClassName);

            //create and initialize a new instance of the Deployment class
            Class c = Class.forName(sClassName);
            ctsCtr = (TSConnectorConnectionInterface)c.newInstance();
            ctsCtr.init(writer);

        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }

        return ctsCtr;

    }


}
