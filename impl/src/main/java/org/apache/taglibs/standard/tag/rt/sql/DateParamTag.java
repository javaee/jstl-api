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

import java.util.Date;

import org.apache.taglibs.standard.tag.common.sql.DateParamTagSupport;

/**
 * Subclass for the JSTL library with rtexprvalue support.
 *
 * @author Justyna Horwat
 */
public class DateParamTag extends DateParamTagSupport {
    
    public void setValue(Date value) {
	this.value = value;
    }

    public void setType(String type) {
	this.type = type;
    }
}
