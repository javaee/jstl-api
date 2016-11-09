/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: JstlTckConstants.java 52684 2007-02-12 04:30:10Z lschwenk $ 
 */

package com.sun.ts.tests.jstl.common;

public interface JstlTckConstants {
    public final String JSTL_DB_URL = "jstl.db.url";
    public final String JSTL_DB_USER = "jstl.db.user";
    public final String JSTL_DB_PASSWORD = "jstl.db.password";
    public final String JSTL_DB_DRIVER = "jstl.db.driver";
    public final String[] JSTL_DB_PROPS = new String[] {
        JSTL_DB_URL, JSTL_DB_USER, JSTL_DB_PASSWORD, JSTL_DB_DRIVER
    };

    /** JSTL TCK DataSource name reference
     */
    public final String JSTLDS = "jstlDS";
    
    /** JSTL TCK Connection wrapped DataSource name reference
     */
    public final String LOGDS = "logDS";
    
    /** SQL Properties name reference
     */
    public final String SQLPROPS = "sqlProps";
    
    /** URI to sql.properties file
     */
    public final String PROPS_URI = "/WEB-INF/jstl-sql.properties";
    
    /** Current number of rows in the table jstl_tab1
     */
    public final String JSTL_TAB1_ROWS = "JSTL_TAB1_ROWS";
}
