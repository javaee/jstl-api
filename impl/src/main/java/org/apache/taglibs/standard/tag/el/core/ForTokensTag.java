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

package org.apache.taglibs.standard.tag.el.core;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.jstl.core.LoopTag;
import javax.servlet.jsp.tagext.IterationTag;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;
import org.apache.taglibs.standard.tag.common.core.ForTokensSupport;
import org.apache.taglibs.standard.tag.common.core.NullAttributeException;

/**
 * <p>A handler for &lt;forTokens&gt; that accepts attributes as Strings
 * and evaluates them as expressions at runtime.
 *
 * @author Shawn Bayern
 */
public class ForTokensTag
    extends ForTokensSupport
    implements LoopTag, IterationTag
{

    //*********************************************************************
    // 'Private' state (implementation details)

    private String begin_;                      // raw EL-based property
    private String end_;                        // raw EL-based property
    private String step_;                       // raw EL-based property
    private String items_;			// raw EL-based property
    private String delims_;			// raw EL-based property


    //*********************************************************************
    // Constructor

    public ForTokensTag() {
        super();
        init();
    }


    //*********************************************************************
    // Tag logic

    /* Begins iterating by processing the first item. */
    public int doStartTag() throws JspException {

        // evaluate any expressions we were passed, once per invocation
        evaluateExpressions();

	// chain to the parent implementation
	return super.doStartTag();
    }


    // Releases any resources we may have (or inherit)
    public void release() {
        super.release();
        init();
    }


    //*********************************************************************
    // Accessor methods

    // for EL-based attribute
    public void setBegin(String begin_) {
        this.begin_ = begin_;
        this.beginSpecified = true;
    }

    // for EL-based attribute
    public void setEnd(String end_) {
        this.end_ = end_;
        this.endSpecified = true;
    }

    // for EL-based attribute
    public void setStep(String step_) {
        this.step_ = step_;
        this.stepSpecified = true;
    }

    // for EL-based attribute
    public void setItems(String items_) {
        this.items_ = items_;
    }

    // for EL-based attribute
    public void setDelims(String delims_) {
	this.delims_ = delims_;
    }


    //*********************************************************************
    // Private (utility) methods

    // (re)initializes state (during release() or construction)
    private void init() {
        // defaults for interface with page author
        begin_ = null;          // (no expression)
        end_ = null;            // (no expression)
        step_ = null;           // (no expression)
	items_ = null;		// (no expression)
	delims_ = null;		// (no expression)
    }

    /* Evaluates expressions as necessary */
    private void evaluateExpressions() throws JspException {
        /*
         * Note: we don't check for type mismatches here; we assume
         * the expression evaluator will return the expected type
         * (by virtue of knowledge we give it about what that type is).
         * A ClassCastException here is truly unexpected, so we let it
         * propagate up.
         */

       if (begin_ != null) {
            Object r = ExpressionEvaluatorManager.evaluate(
                "begin", begin_, Integer.class, this, pageContext);
            if (r == null)
                throw new NullAttributeException("forTokens", "begin");
            begin = ((Integer) r).intValue();
            validateBegin();
        }

        if (end_ != null) {
            Object r = ExpressionEvaluatorManager.evaluate(
                "end", end_, Integer.class, this, pageContext);
            if (r == null)
                throw new NullAttributeException("forTokens", "end");
            end = ((Integer) r).intValue();
            validateEnd();
        }

        if (step_ != null) {
            Object r = ExpressionEvaluatorManager.evaluate(
                "step", step_, Integer.class, this, pageContext);
            if (r == null)
                throw new NullAttributeException("forTokens", "step");
            step = ((Integer) r).intValue();
            validateStep();
        }

        if (items_ != null) {
            items = (String) ExpressionEvaluatorManager.evaluate(
                "items", items_, String.class, this, pageContext);
	    // use the empty string to indicate "no iteration"
	    if (items == null)
		items = "";
	}

        if (delims_ != null) {
            delims = (String) ExpressionEvaluatorManager.evaluate(
                "delims", delims_, String.class, this, pageContext);
	    // use the empty string to cause monolithic tokenization
	    if (delims == null)
		delims = "";
	}
    }
}
