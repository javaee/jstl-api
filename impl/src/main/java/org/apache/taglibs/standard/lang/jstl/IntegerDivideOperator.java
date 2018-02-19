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

package org.apache.taglibs.standard.lang.jstl;

/**
 *
 * <p>The implementation of the integer divide operator
 * 
 * @author Nathan Abramson - Art Technology Group
 * @version $Change: 181177 $$DateTime: 2001/06/26 08:45:09 $$Author: kchung $
 **/

public class IntegerDivideOperator
  extends BinaryOperator
{
  //-------------------------------------
  // Singleton
  //-------------------------------------

  public static final IntegerDivideOperator SINGLETON =
    new IntegerDivideOperator ();

  //-------------------------------------
  /**
   *
   * Constructor
   **/
  public IntegerDivideOperator ()
  {
  }

  //-------------------------------------
  // Expression methods
  //-------------------------------------
  /**
   *
   * Returns the symbol representing the operator
   **/
  public String getOperatorSymbol ()
  {
    return "idiv";
  }

  //-------------------------------------
  /**
   *
   * Applies the operator to the given value
   **/
  public Object apply (Object pLeft,
		       Object pRight,
		       Object pContext,
		       Logger pLogger)
    throws ELException
  {
    if (pLeft == null &&
	pRight == null) {
      if (pLogger.isLoggingWarning ()) {
	pLogger.logWarning
	  (Constants.ARITH_OP_NULL,
	   getOperatorSymbol ());
      }
      return PrimitiveObjects.getInteger (0);
    }

    long left =
      Coercions.coerceToPrimitiveNumber (pLeft, Long.class, pLogger).
      longValue ();
    long right =
      Coercions.coerceToPrimitiveNumber (pRight, Long.class, pLogger).
      longValue ();

    try {
      return PrimitiveObjects.getLong (left / right);
    }
    catch (Exception exc) {
      if (pLogger.isLoggingError ()) {
	pLogger.logError
	  (Constants.ARITH_ERROR,
	   getOperatorSymbol (),
	   "" + left,
	   "" + right);
      }
      return PrimitiveObjects.getInteger (0);
    }
  }

  //-------------------------------------
}
