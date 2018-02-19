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

package org.apache.taglibs.standard.tag.common.xml;

import org.apache.xpath.jaxp.XPathFactoryImpl;

/**
 * This factory class is added to provide access to our own implementation
 * of XPath, so that we can support a generic Object type in return type
 * arguement for XPath's evaluate instance method. 
 * 
 * @author dhirup
 */
public class JSTLXPathFactory extends XPathFactoryImpl {
    
    public javax.xml.xpath.XPath newXPath() {
        return new org.apache.taglibs.standard.tag.common.xml.JSTLXPathImpl(null, null);
    }    
}
