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

package org.apache.taglibs.standard.lang.jstl;

import java.util.Map;

/**
 *
 * <p>Represents an operator that obtains the value of another value's
 * property.  This is a specialization of ArraySuffix - a.b is
 * equivalent to a["b"]
 * 
 * @author Nathan Abramson - Art Technology Group
 * @author Shawn Bayern
 * @version $Change: 181177 $$DateTime: 2001/06/26 08:45:09 $$Author: kchung $
 **/

public class PropertySuffix
  extends ArraySuffix
{
  //-------------------------------------
  // Properties
  //-------------------------------------
  // property name

  String mName;
  public String getName ()
  { return mName; }
  public void setName (String pName)
  { mName = pName; }

  //-------------------------------------
  /**
   *
   * Constructor
   **/
  public PropertySuffix (String pName)
  {
    super (null);
    mName = pName;
  }

  //-------------------------------------
  /**
   *
   * Gets the value of the index
   **/
  Object evaluateIndex (Object pContext,
                        VariableResolver pResolver,
                        Map functions,
                        String defaultPrefix,
                        Logger pLogger)
    throws ELException
  {
    return mName;
  }

  //-------------------------------------
  /**
   *
   * Returns the operator symbol
   **/
  String getOperatorSymbol ()
  {
    return ".";
  }

  //-------------------------------------
  // ValueSuffix methods
  //-------------------------------------
  /**
   *
   * Returns the expression in the expression language syntax
   **/
  public String getExpressionString ()
  {
    return "." + StringLiteral.toIdentifierToken (mName);
  }

  //-------------------------------------
}
