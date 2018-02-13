/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2018 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://oss.oracle.com/licenses/CDDL+GPL-1.1
 * or LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
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
