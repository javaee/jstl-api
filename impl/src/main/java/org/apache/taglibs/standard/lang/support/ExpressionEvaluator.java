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

package org.apache.taglibs.standard.lang.support;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 * <p>The interface for an expression-language validator and evaluator.
 * Classes that implement an expression language expose their functionality
 * via this interface.</p>
 *
 * <p>The validate() and evaluate() methods must be thread-safe.  That is,
 * multiple threads may call these methods on the same ExpressionEvaluator
 * object simultaneously.  Implementations should synchronize access if
 * they depend on transient state.  Implementations should not, however,
 * assume that only one object of each ExpressionEvaluator type will be
 * instantiated; global caching should therefore be static.  No release()
 * mechanism or robust lifecycle is specified, for language-interpreter
 * pluggability is experimental in EA2.</p>
 *
 * <p><b>WARNING</b>:  This class supports experimentation for the EA2
 * release of JSTL; it is not expected to be part of the final RI or
 * specification.</p>
 *
 * @author Shawn Bayern (based exactly on rev1 draft)
 */
public interface ExpressionEvaluator {

    /** 
     * Translation time validation of an expression. 
     * This method will return a null String if the expression 
     * is valid; otherwise an error message. 
     */ 
    public String validate(String attributeName, 
                           String expression); 

    /** 
     * Evaluates the expression at request time. 
     */ 
    public Object evaluate(String attributeName, 
                           String expression, 
                           Class expectedType, 
                           Tag tag, 
                           PageContext pageContext) 
       throws JspException; 
} 
