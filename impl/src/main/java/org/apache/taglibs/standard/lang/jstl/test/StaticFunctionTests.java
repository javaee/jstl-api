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
