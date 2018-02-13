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
