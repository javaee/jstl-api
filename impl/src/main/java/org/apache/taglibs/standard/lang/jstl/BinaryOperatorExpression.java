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
 * <p>An expression representing a binary operator on a value
 * 
 * @author Nathan Abramson - Art Technology Group
 * @author Shawn Bayern
 * @version $Change: 181177 $$DateTime: 2001/06/26 08:45:09 $$Author: kchung $
 **/

public class BinaryOperatorExpression
  extends Expression
{
  //-------------------------------------
  // Properties
  //-------------------------------------
  // property expression

  Expression mExpression;
  public Expression getExpression ()
  { return mExpression; }
  public void setExpression (Expression pExpression)
  { mExpression = pExpression; }

  //-------------------------------------
  // property operators

  List mOperators;
  public List getOperators ()
  { return mOperators; }
  public void setOperators (List pOperators)
  { mOperators = pOperators; }

  //-------------------------------------
  // property expressions

  List mExpressions;
  public List getExpressions ()
  { return mExpressions; }
  public void setExpressions (List pExpressions)
  { mExpressions = pExpressions; }

  //-------------------------------------
  /**
   *
   * Constructor
   **/
  public BinaryOperatorExpression (Expression pExpression,
				   List pOperators,
				   List pExpressions)
  {
    mExpression = pExpression;
    mOperators = pOperators;
    mExpressions = pExpressions;
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
    buf.append ("(");
    buf.append (mExpression.getExpressionString ());
    for (int i = 0; i < mOperators.size (); i++) {
      BinaryOperator operator = (BinaryOperator) mOperators.get (i);
      Expression expression = (Expression) mExpressions.get (i);
      buf.append (" ");
      buf.append (operator.getOperatorSymbol ());
      buf.append (" ");
      buf.append (expression.getExpressionString ());
    }
    buf.append (")");

    return buf.toString ();
  }

  //-------------------------------------
  /**
   *
   * Evaluates to the literal value
   **/
  public Object evaluate (Object pContext,
			  VariableResolver pResolver,
			  Map functions,
			  String defaultPrefix,
			  Logger pLogger)
    throws ELException
  {
    Object value = mExpression.evaluate (pContext, pResolver, functions,
					 defaultPrefix, pLogger);
    for (int i = 0; i < mOperators.size (); i++) {
      BinaryOperator operator = (BinaryOperator) mOperators.get (i);

      // For the And/Or operators, we need to coerce to a boolean
      // before testing if we shouldEvaluate
      if (operator.shouldCoerceToBoolean ()) {
	value = Coercions.coerceToBoolean (value, pLogger);
      }

      if (operator.shouldEvaluate (value)) {
	Expression expression = (Expression) mExpressions.get (i);
	Object nextValue = expression.evaluate (pContext, pResolver,
						functions, defaultPrefix,
						pLogger);

	value = operator.apply (value, nextValue, pContext, pLogger);
      }
    }
    return value;
  }

  //-------------------------------------
}
