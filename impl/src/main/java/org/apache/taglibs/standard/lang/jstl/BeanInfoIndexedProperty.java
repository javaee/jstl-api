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



import java.beans.IndexedPropertyDescriptor;

import java.beans.PropertyDescriptor;

import java.lang.reflect.Method;



/**

 *

 * <p>This contains the information for one indexed property in a

 * BeanInfo - IndexedPropertyDescriptor, read method, and write

 * method.  This class is necessary because the read/write methods in

 * the IndexedPropertyDescriptor may not be accessible if the bean

 * given to the introspector is not a public class.  In this case, a

 * publicly accessible version of the method must be found by

 * searching for a public superclass/interface that declares the

 * method (this searching is done by the BeanInfoManager).

 * 

 * @author Nathan Abramson - Art Technology Group

 * @version $Change: 181181 $$DateTime: 2001/06/26 09:55:09 $$Author: kchung $

 **/



public class BeanInfoIndexedProperty

{

  //-------------------------------------

  // Properties

  //-------------------------------------

  // property readMethod



  Method mReadMethod;

  public Method getReadMethod ()

  { return mReadMethod; }



  //-------------------------------------

  // property writeMethod



  Method mWriteMethod;

  public Method getWriteMethod ()

  { return mWriteMethod; }



  //-------------------------------------

  // property propertyDescriptor



  IndexedPropertyDescriptor mIndexedPropertyDescriptor;

  public IndexedPropertyDescriptor getIndexedPropertyDescriptor ()

  { return mIndexedPropertyDescriptor; }



  //-------------------------------------

  /**

   *

   * Constructor

   **/

  public BeanInfoIndexedProperty 

    (Method pReadMethod,

     Method pWriteMethod,

     IndexedPropertyDescriptor pIndexedPropertyDescriptor)

  {

    mReadMethod = pReadMethod;

    mWriteMethod = pWriteMethod;

    mIndexedPropertyDescriptor = pIndexedPropertyDescriptor;

  }



  //-------------------------------------

}

