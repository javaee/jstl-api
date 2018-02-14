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
 * Represents any of the exception conditions that arise during the
 * operation evaluation of the evaluator.
 * 
 * @author Nathan Abramson - Art Technology Group
 * @version $Change: 181177 $$DateTime: 2001/06/26 08:45:09 $$Author: kchung $
 **/

public class ELException
  extends Exception
{
  //-------------------------------------
  // Member variables
  //-------------------------------------

  Throwable mRootCause;

  //-------------------------------------
  /**
   *
   * Constructor
   **/
  public ELException ()
  {
    super ();
  }

  //-------------------------------------
  /**
   *
   * Constructor
   **/
  public ELException (String pMessage)
  {
    super (pMessage);
  }

  //-------------------------------------
  /**
   *
   * Constructor
   **/
  public ELException (Throwable pRootCause)
  {
    mRootCause = pRootCause;
  }

  //-------------------------------------
  /**
   *
   * Constructor
   **/
  public ELException (String pMessage,
		      Throwable pRootCause)
  {
    super (pMessage);
    mRootCause = pRootCause;
  }

  //-------------------------------------
  /**
   *
   * Returns the root cause
   **/
  public Throwable getRootCause ()
  {
    return mRootCause;
  }

  //-------------------------------------
  /**
   *
   * String representation
   **/
  public String toString ()
  {
    if (getMessage () == null) {
      return mRootCause.toString ();
    }
    else if (mRootCause == null) {
      return getMessage ();
    }
    else {
      return getMessage () + ": " + mRootCause;
    }
  }

  //-------------------------------------
}
