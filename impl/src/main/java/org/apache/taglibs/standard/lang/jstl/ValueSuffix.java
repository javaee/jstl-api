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

import java.util.Map;

/**
 *
 * <p>Represents an element that can appear as a suffix in a complex
 * value, such as a property or index operator, or a method call (should
 * they ever need to be supported).
 * 
 * @author Nathan Abramson - Art Technology Group
 * @author Shawn Bayern
 * @version $Change: 181177 $$DateTime: 2001/06/26 08:45:09 $$Author: kchung $
 **/

public abstract class ValueSuffix
{
  //-------------------------------------
  /**
   *
   * Returns the expression in the expression language syntax
   **/
  public abstract String getExpressionString ();

  //-------------------------------------
  /**
   *
   * Evaluates the expression in the given context, operating on the
   * given value.
   **/
  public abstract Object evaluate (Object pValue,
				   Object pContext,
				   VariableResolver pResolver,
				   Map functions,
				   String defaultPrefix,
				   Logger pLogger)
    throws ELException;

  //-------------------------------------
}
