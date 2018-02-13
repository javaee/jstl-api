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

import java.util.List;
import java.util.Map;

/**
 *
 * <p>Represents a dynamic value, which consists of a prefix and an
 * optional set of ValueSuffix elements.  A prefix is something like
 * an identifier, and a suffix is something like a "property of" or
 * "indexed element of" operator.
 * 
 * @author Nathan Abramson - Art Technology Group
 * @author Shawn Bayern
 * @version $Change: 181177 $$DateTime: 2001/06/26 08:45:09 $$Author: kchung $
 **/

public class ComplexValue
  extends Expression
{
  //-------------------------------------
  // Properties
  //-------------------------------------
  // property prefix

  Expression mPrefix;
  public Expression getPrefix ()
  { return mPrefix; }
  public void setPrefix (Expression pPrefix)
  { mPrefix = pPrefix; }

  //-------------------------------------
  // property suffixes

  List mSuffixes;
  public List getSuffixes ()
  { return mSuffixes; }
  public void setSuffixes (List pSuffixes)
  { mSuffixes = pSuffixes; }

  //-------------------------------------
  /**
   *
   * Constructor
   **/
  public ComplexValue (Expression pPrefix,
		       List pSuffixes)
  {
    mPrefix = pPrefix;
    mSuffixes = pSuffixes;
  }

  //-------------------------------------
  // Expression methods
  //-------------------------------------
  /**
   *
   * Returns the expression in the expression language syntax
   **/
  public String getExpressionString ()
  {
    StringBuffer buf = new StringBuffer ();
    buf.append (mPrefix.getExpressionString ());

    for (int i = 0; mSuffixes != null && i < mSuffixes.size (); i++) {
      ValueSuffix suffix = (ValueSuffix) mSuffixes.get (i);
      buf.append (suffix.getExpressionString ());
    }

    return buf.toString ();
  }

  //-------------------------------------
  /**
   *
   * Evaluates by evaluating the prefix, then applying the suffixes
   **/
  public Object evaluate (Object pContext,
			  VariableResolver pResolver,
			  Map functions,
			  String defaultPrefix,
			  Logger pLogger)
    throws ELException
  {
    Object ret = mPrefix.evaluate (pContext, pResolver, functions,
				   defaultPrefix, pLogger);

    // Apply the suffixes
    for (int i = 0; mSuffixes != null && i < mSuffixes.size (); i++) {
      ValueSuffix suffix = (ValueSuffix) mSuffixes.get (i);
      ret = suffix.evaluate (ret, pContext, pResolver, functions,
			     defaultPrefix, pLogger);
    }

    return ret;
  }

  //-------------------------------------
}
