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
 * <p>This is the superclass for all relational operators (except ==
 * or !=)
 * 
 * @author Nathan Abramson - Art Technology Group
 * @version $Change: 181177 $$DateTime: 2001/06/26 08:45:09 $$Author: kchung $
 **/

public abstract class RelationalOperator
  extends BinaryOperator
{
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
    return Coercions.applyRelationalOperator (pLeft, pRight, this, pLogger);
  }

  //-------------------------------------
  /**
   *
   * Applies the operator to the given double values
   **/
  public abstract boolean apply (double pLeft,
				 double pRight,
				 Logger pLogger);
  
  //-------------------------------------
  /**
   *
   * Applies the operator to the given long values
   **/
  public abstract boolean apply (long pLeft,
				 long pRight,
				 Logger pLogger);
  
  //-------------------------------------
  /**
   *
   * Applies the operator to the given String values
   **/
  public abstract boolean apply (String pLeft,
				 String pRight,
				 Logger pLogger);

  //-------------------------------------
}
