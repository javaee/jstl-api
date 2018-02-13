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

package org.apache.taglibs.standard.tag.rt.sql;

import org.apache.taglibs.standard.tag.common.sql.SetDataSourceTagSupport;

/**
 * <p>Tag handler for &lt;Driver&gt; in JSTL, used to create
 * a simple DataSource for prototyping.</p>
 * 
 */
public class SetDataSourceTag extends SetDataSourceTagSupport {

    //*********************************************************************
    // Accessor methods

    public void setDataSource(Object dataSource) {
	this.dataSource = dataSource;
	this.dataSourceSpecified = true;
    }

    public void setDriver(String driverClassName) {
	this.driverClassName = driverClassName;
    }

    public void setUrl(String jdbcURL) {
	this.jdbcURL = jdbcURL;
    }

    public void setUser(String userName) {
	this.userName = userName;
    }

    public void setPassword(String password) {
	this.password = password;
    }

}
