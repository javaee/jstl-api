/*
 * Copyright (c) 1997-2018 Oracle and/or its affiliates. All rights reserved.
 * Copyright 2004 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.taglibs.standard.tag.common.sql;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.taglibs.standard.resources.Resources;


/**
 * <p>A simple <code>DataSource</code> wrapper for the standard
 * <code>DriverManager</code> class.
 * 
 * @author Hans Bergsten
 */
public class DataSourceWrapper implements DataSource {
    private Driver driver;
    private String jdbcURL;
    private String userName;
    private String password;

    public void setDriverClassName(String driverClassName) 
	throws ClassNotFoundException, InstantiationException, 
	       IllegalAccessException {

        Object instance = Class.forName(driverClassName, true, 
            Thread.currentThread().getContextClassLoader()).newInstance();
        if (instance instanceof Driver) {
            driver = (Driver) instance;
        }
    }

    public void setJdbcURL(String jdbcURL) {
	this.jdbcURL = jdbcURL;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    /**
     * Returns a Connection using the DriverManager and all
     * set properties.
     */
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        if (driver != null) {
            Properties props = new Properties();
            if (userName != null) {
                props.put("user", userName);
            }
            if (password != null) {
                props.put("password", password);
            }
            conn = driver.connect(jdbcURL, props);
        }
        if (conn == null) {
            if (userName != null) {
                conn = DriverManager.getConnection(jdbcURL, userName, password);
            } else {
                conn = DriverManager.getConnection(jdbcURL);
            }
        }
        return conn;
    }

    /**
     * Always throws a SQLException. Username and password are set
     * in the constructor and can not be changed.
     */
    public Connection getConnection(String username, String password) 
            throws SQLException {
        throw new SQLException(Resources.getMessage("NOT_SUPPORTED"));
    }
    
    /**
     * Always throws a SQLException. Not supported.
     */
    public int getLoginTimeout() throws SQLException {
        throw new SQLException(Resources.getMessage("NOT_SUPPORTED"));
    }
    
    /**
     * Always throws a SQLException. Not supported.
     */
    public PrintWriter getLogWriter() throws SQLException {
        throw new SQLException(Resources.getMessage("NOT_SUPPORTED"));
    }
    
    /**
     * Always throws a SQLException. Not supported.
     */
    public void setLoginTimeout(int seconds) throws SQLException {
        throw new SQLException(Resources.getMessage("NOT_SUPPORTED"));
    }
    
    /**
     * Always throws a SQLException. Not supported.
     */
    public synchronized void setLogWriter(PrintWriter out) throws SQLException {
        throw new SQLException(Resources.getMessage("NOT_SUPPORTED"));
    }

    /**
     * Always return false.
     */
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    /**
     * Always throws a SQLException. Not supported.
     */
    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new SQLException(Resources.getMessage("NOT_SUPPORTED"));
    }
    
    /**
     * Always throws a SQLFeatureNotSupportedException. Not supported.
     * @since jdk1.7
     */
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException(
                Resources.getMessage("NOT_SUPPORTED"));
    }

}
