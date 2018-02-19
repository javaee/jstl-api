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

package org.apache.taglibs.standard.extra.spath;


/**
 * <p>Represents a predicate expression concerning a single attribute.</p>
 *
 * @author Shawn Bayern
 */
public class AttributePredicate extends Predicate {

    private String attribute, target;

    /**
     * Constructs a new AttributePredicate, given an attribute name
     * and a target literal (with which to test equality).
     */
    public AttributePredicate(String attribute, String target) {
	if (attribute == null)
	    throw new IllegalArgumentException("non-null attribute needed");
	if (attribute.indexOf(":") != -1)
	    throw new IllegalArgumentException(
		"namespace-qualified attribute names are not currently " +
		"supported");
	this.attribute = attribute;

	if (target == null)
	    throw new IllegalArgumentException("non-null target needed");
	// strip quotation marks from target
	this.target = target.substring(1, target.length() - 1);
    }

    /**
     * Returns true if the given SAX AttributeList is suitable, given our
     * attribute name and target; returns false otherwise.
     */
    public boolean isMatchingAttribute(org.xml.sax.Attributes a) {
	String attValue = a.getValue("", attribute);
	return (attValue != null && attValue.equals(target));
    }
} 
