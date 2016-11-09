/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: PropertyManagerInterface.java 52683 2007-02-12 02:25:42Z lschwenk $
 */


package  com.sun.ts.lib.deliverable;

import  com.sun.ts.lib.util.*;
import  java.util.*;
import  java.io.*;


/**
 * This class serves as a well known place for harness, util, and porting
 * classes to retrieve property values.
 *
 * @author	Kyle Grucci
 */
public interface PropertyManagerInterface {

    /**
     * This method swaps all of the following interop values in
     * TSPropertyManager...
     *
     */
    public void swapInteropPropertyValues (String sDirection);



    /**
     * gets a new properties containing all entries in the property manager.
     * Any operation on the returned properties will have no effect on property
     * manager
     */
    public Properties getJteProperties ();


    /**
     * gets property value with default
     *
     * @param	sKey - Property to retrieve
     * @param   default edefault value to use
     * @return	String - property value
     */
    public String getProperty (String sKey, String def);


    /**
     * This method is called to get a property value
     *
     * @param	sKey - Property to retrieve
     * @return	String - property value
     */
    public String getProperty (String sKey) throws PropertyNotSetException;


    /*
     * This method is called to set a property on the property manager
     *
     * @param   skey - key to be used
     * @param   sVal - value to use
     */
     public void setProperty(String sKey, String sVal);


    /**
     * This method is called by the test harness to retrieve all properties
     * needed by a particular test.
     *
     * @param	sPropKeys - Properties to retrieve
     * @return	Properties - property/value pairs
     */
    public Properties getTestSpecificProperties (String[] sPropKeys) throws PropertyNotSetException;
}



