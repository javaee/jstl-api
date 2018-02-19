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

package org.apache.taglibs.standard.tag.common.core;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.taglibs.standard.resources.Resources;

/**
 * <p>Tag handler for &lt;choose&gt; in JSTL.</p>
 * 
 * <p>&lt;choose&gt; is a very simple tag that acts primarily as a container;
 * it always includes its body and allows exactly one of its child
 * &lt;when&gt; tags to run.  Since this tag handler doesn't have any
 * attributes, it is common.core to both the rtexprvalue and expression-
 * evaluating versions of the JSTL library.
 *
 * @author Shawn Bayern
 */

public class ChooseTag extends TagSupport {

    //*********************************************************************
    // Constructor and lifecycle management

    // initialize inherited and local state
    public ChooseTag() {
        super();
        init();
    }

    // Releases any resources we may have (or inherit)
    public void release() {
        super.release();
        init();
    }


    //*********************************************************************
    // Private state

    private boolean subtagGateClosed;      // has one subtag already executed?


    //*********************************************************************
    // Public methods implementing exclusivity checks

    /**
     * Returns status indicating whether a subtag should run or not.
     *
     * @return <tt>true</tt> if the subtag should evaluate its condition
     *         and decide whether to run, <tt>false</tt> otherwise.
     */
    public synchronized boolean gainPermission() {
        return (!subtagGateClosed);
    }

    /**
     * Called by a subtag to indicate that it plans to evaluate its
     * body.
     */
    public synchronized void subtagSucceeded() {
        if (subtagGateClosed)
            throw new IllegalStateException(
		Resources.getMessage("CHOOSE_EXCLUSIVITY"));
        subtagGateClosed = true;
    }


    //*********************************************************************
    // Tag logic

    // always include body
    public int doStartTag() throws JspException {
        subtagGateClosed = false;	// when we start, no children have run
        return EVAL_BODY_INCLUDE;
    }


    //*********************************************************************
    // Private utility methods

    private void init() {
        subtagGateClosed = false;                          // reset flag
    }
}
