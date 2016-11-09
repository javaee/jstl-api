/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: TSLoginContextInterface.java 52502 2007-01-24 02:50:22Z lschwenk $
 */

package com.sun.ts.lib.porting;

/**
 * TSLoginContextInterface provides the interface that must be
 * implemented to provide the implementation specific login code
 * to login as a specified user.
 */
public interface TSLoginContextInterface
{
    /**
     * This method is used for login with username and password.
     *
     * @param usr - string username
     * @param pwd - string password
     */
    public void login(String usr, String pwd) throws Exception;
    
    /** This login method is used for Certificate based login
     *
     * Note: This method also uses keystore and keystore password from
     *       the TS configuration file
     *
     * @param alias - alias is used to pick up the certificate from keystore
     */
    public void login(String alias) throws Exception;
    
    /** This login method is used for Certificate based login
     *
     * @param alias - alias is used to pick up the certificate from keystore
     * @param keystore - keystore file
     * @param keyPass - keystore password
     */
    public void login(String alias, String keystore, String keyPass) throws Exception;
    
    /**
     * This method is used for logout
     */
    public Boolean logout();
    
}
