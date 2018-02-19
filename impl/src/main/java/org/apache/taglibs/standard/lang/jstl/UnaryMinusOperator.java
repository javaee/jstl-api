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
 * <p>The implementation of the unary minus operator
 * 
 * @author Nathan Abramson - Art Technology Group
 * @version $Change: 181177 $$DateTime: 2001/06/26 08:45:09 $$Author: kchung $
 **/

public class UnaryMinusOperator
  extends UnaryOperator
{
  //-------------------------------------
  // Singleton
  //-------------------------------------

  public static final UnaryMinusOperator SINGLETON =
    new UnaryMinusOperator ();

  //-------------------------------------
  /**
   *
   * Constructor
   **/
  public UnaryMinusOperator ()
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
    return "-";
  }

  //-------------------------------------
  /**
   *
   * Applies the operator to the given value
   **/
  public Object apply (Object pValue,
		       Object pContext,
		       Logger pLogger)
    throws ELException
  {
    if (pValue == null) {
      /*
      if (pLogger.isLoggingWarning ()) {
	pLogger.logWarning
	  (Constants.ARITH_OP_NULL,
	   getOperatorSymbol ());
      }
      */
      return PrimitiveObjects.getInteger (0);
    }

    else if (pValue instanceof String) {
      if (Coercions.isFloatingPointString (pValue)) {
	double dval =
	  ((Number) 
	   (Coercions.coerceToPrimitiveNumber 
	    (pValue, Double.class, pLogger))).
	  doubleValue ();
	return PrimitiveObjects.getDouble (-dval);
      }
      else {
	long lval =
	  ((Number) 
	   (Coercions.coerceToPrimitiveNumber 
	    (pValue, Long.class, pLogger))).
	  longValue ();
	return PrimitiveObjects.getLong (-lval);
      }
    }

    else if (pValue instanceof Byte) {
      return PrimitiveObjects.getByte 
	((byte) -(((Byte) pValue).byteValue ()));
    }
    else if (pValue instanceof Short) {
      return PrimitiveObjects.getShort 
	((short) -(((Short) pValue).shortValue ()));
    }
    else if (pValue instanceof Integer) {
      return PrimitiveObjects.getInteger 
	((int) -(((Integer) pValue).intValue ()));
    }
    else if (pValue instanceof Long) {
      return PrimitiveObjects.getLong 
	((long) -(((Long) pValue).longValue ()));
    }
    else if (pValue instanceof Float) {
      return PrimitiveObjects.getFloat 
	((float) -(((Float) pValue).floatValue ()));
    }
    else if (pValue instanceof Double) {
      return PrimitiveObjects.getDouble 
	((double) -(((Double) pValue).doubleValue ()));
    }

    else {
      if (pLogger.isLoggingError ()) {
	pLogger.logError
	  (Constants.UNARY_OP_BAD_TYPE,
	   getOperatorSymbol (),
	   pValue.getClass ().getName ());
      }
      return PrimitiveObjects.getInteger (0);
    }
  }

  //-------------------------------------
}
