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
 * <p>This is the superclass for all binary operators
 * 
 * @author Nathan Abramson - Art Technology Group
 * @version $Change: 181177 $$DateTime: 2001/06/26 08:45:09 $$Author: kchung $
 **/

public abstract class BinaryOperator
{
  //-------------------------------------
  /**
   *
   * Constructor
   **/
  public BinaryOperator ()
  {
  }

  //-------------------------------------
  // Expression methods
  //-------------------------------------
  /**
   *
   * Returns the symbol representing the operator
   **/
  public abstract String getOperatorSymbol ();

  //-------------------------------------
  /**
   *
   * Applies the operator to the given pair of values
   **/
  public abstract Object apply (Object pLeft,
				Object pRight,
				Object pContext,
				Logger pLogger)
    throws ELException;

  //-------------------------------------
  /**
   *
   * Returns true if evaluation is necessary given the specified Left
   * value.  The And/OrOperators make use of this
   **/
  public boolean shouldEvaluate (Object pLeft)
  {
    return true;
  }

  //-------------------------------------
  /**
   *
   * Returns true if the operator expects its arguments to be coerced
   * to Booleans.  The And/Or operators set this to true.
   **/
  public boolean shouldCoerceToBoolean ()
  {
    return false;
  }

  //-------------------------------------
}
