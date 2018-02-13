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

import java.text.MessageFormat;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluator;

/**
 *
 * <p>This is the expression evaluator "adapter" that customizes it
 * for use with the JSP Standard Tag Library.  It uses a
 * VariableResolver implementation that looks up variables from the
 * PageContext and also implements its implicit objects.  It also
 * wraps ELExceptions in JspExceptions that describe the attribute
 * name and value causing the error.
 * 
 * @author Nathan Abramson - Art Technology Group
 * @author Shawn Bayern
 * @version $Change: 181177 $$DateTime: 2001/06/26 08:45:09 $$Author: kchung $
 **/

public class Evaluator
  implements ExpressionEvaluator
{
  //-------------------------------------
  // Properties
  //-------------------------------------

  //-------------------------------------
  // Member variables
  //-------------------------------------

  /** The singleton instance of the evaluator **/
  static ELEvaluator sEvaluator =
    new ELEvaluator
    (new JSTLVariableResolver ());

  //-------------------------------------
  // ExpressionEvaluator methods
  //-------------------------------------
  /** 
   *
   * Translation time validation of an attribute value.  This method
   * will return a null String if the attribute value is valid;
   * otherwise an error message.
   **/ 
  public String validate (String pAttributeName,
			  String pAttributeValue)
  {
    try {
      sEvaluator.parseExpressionString (pAttributeValue);
      return null;
    }
    catch (ELException exc) {
      return
	MessageFormat.format
	(Constants.ATTRIBUTE_PARSE_EXCEPTION,
	 new Object [] {
	   "" + pAttributeName,
	   "" + pAttributeValue,
	   exc.getMessage ()
	 });
    }
  }

  //-------------------------------------
  /**
   *
   * Evaluates the expression at request time
   **/
  public Object evaluate (String pAttributeName,
			  String pAttributeValue,
			  Class pExpectedType,
			  Tag pTag,
			  PageContext pPageContext,
			  Map functions,
			  String defaultPrefix)
    throws JspException
  {
    try {
      return sEvaluator.evaluate
	(pAttributeValue,
	 pPageContext,
	 pExpectedType,
	 functions,
	 defaultPrefix);
    }
    catch (ELException exc) {
      throw new JspException
	(MessageFormat.format
	 (Constants.ATTRIBUTE_EVALUATION_EXCEPTION,
	  new Object [] {
	    "" + pAttributeName,
	    "" + pAttributeValue,
	    exc.getMessage(),
	    exc.getRootCause()
	  }), exc.getRootCause());
    }
  }

  /** Conduit to old-style call for convenience. */
  public Object evaluate (String pAttributeName,
			  String pAttributeValue,
			  Class pExpectedType,
			  Tag pTag,
			  PageContext pPageContext)
    throws JspException
  {
    return evaluate(pAttributeName,
		   pAttributeValue,
		   pExpectedType,
		   pTag,
		   pPageContext,
		   null,
		   null);
  }


  //-------------------------------------
  // Testing methods
  //-------------------------------------
  /**
   *
   * Parses the given attribute value, then converts it back to a
   * String in its canonical form.
   **/
  public static String parseAndRender (String pAttributeValue)
    throws JspException
  {
    try {
      return sEvaluator.parseAndRender (pAttributeValue);
    }
    catch (ELException exc) {
      throw new JspException
	(MessageFormat.format
	 (Constants.ATTRIBUTE_PARSE_EXCEPTION,
	  new Object [] {
	    "test",
	    "" + pAttributeValue,
	    exc.getMessage ()
	  }));
    }
  }

  //-------------------------------------

}
