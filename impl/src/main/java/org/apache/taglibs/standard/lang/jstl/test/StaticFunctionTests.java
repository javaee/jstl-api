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

package org.apache.taglibs.standard.lang.jstl.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.taglibs.standard.lang.jstl.Evaluator;

/**
 *
 * <p>This class contains some test functions.</p>
 * 
 * @author Shawn Bayern
 */

public class StaticFunctionTests {

  public static void main(String args[]) throws Exception {
    Map m = getSampleMethodMap();
    Evaluator e = new Evaluator();
    Object o;
    o = e.evaluate("", "4", Integer.class, null, null, m, "foo");
    System.out.println(o);
    o = e.evaluate("", "${4}", Integer.class, null, null, m, "foo");
    System.out.println(o);
    o = e.evaluate("", "${2+2}", Integer.class, null, null, m, "foo");
    System.out.println(o);
    o = e.evaluate("", "${foo:add(2, 3)}", Integer.class, null, null, m, "foo");
    System.out.println(o);
    o = e.evaluate("", "${foo:multiply(2, 3)}", Integer.class, null, null, m, "foo");
    System.out.println(o);
    o = e.evaluate("", "${add(2, 3)}", Integer.class, null, null, m, "foo");
    System.out.println(o);
    o = e.evaluate("", "${multiply(2, 3)}", Integer.class, null, null, m, "foo");
    System.out.println(o);
    o = e.evaluate("", "${add(2, 3) + 5}", Integer.class, null, null, m, "foo");
    System.out.println(o);

    System.out.println("---");
    o = e.evaluate("", "${getInt(getInteger(getInt(5)))}", Integer.class, null, null, m, "foo");
    System.out.println(o);
    o = e.evaluate("", "${getInteger(getInt(getInteger(5)))}", Integer.class, null, null, m, "foo");
    System.out.println(o);
    o = e.evaluate("", "${getInt(getInt(getInt(5)))}", Integer.class, null, null, m, "foo");
    System.out.println(o);
    o = e.evaluate("", "${getInteger(getInteger(getInteger(5)))}", Integer.class, null, null, m, "foo");
    System.out.println(o);

  }

  public static int add(int a, int b) {
    return a + b;
  }

  public static int multiply(int a, int b) {
    return a * b;
  }

  public static int getInt(Integer i) {
    return i.intValue();
  }

  public static Integer getInteger(int i) {
    return Integer.valueOf(i);
  }

  public static Map getSampleMethodMap() throws Exception {
    Map m = new HashMap();
    Class c = StaticFunctionTests.class;
    m.put("foo:add",
     c.getMethod("add", new Class[] { Integer.TYPE, Integer.TYPE }));
    m.put("foo:multiply",
     c.getMethod("multiply", new Class[] { Integer.TYPE, Integer.TYPE }));
    m.put("foo:getInt",
     c.getMethod("getInt", new Class[] { Integer.class }));
    m.put("foo:getInteger",
     c.getMethod("getInteger", new Class[] { Integer.TYPE }));
    return m;
  }

}
