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

package javax.servlet.jsp.jstl.core;

import javax.servlet.jsp.tagext.Tag;

/**
 * <p>JSTL allows developers to write custom iteration tags by
 * implementing the LoopTag interface.  This is not to be confused
 * with <tt>javax.servlet.jsp.tagext.IterationTag</tt> as defined in JSP 1.2.
 * LoopTag establishes a mechanism for iteration tags to be recognized
 * and for type-safe implicit collaboration with custom subtags.
 * 
 * <p>In most cases, it will not be necessary to implement this interface
 * manually, for a base support class (<tt>LoopTagSupport</tt>) is provided
 * to facilitate implementation.</p>
 *
 * @author Shawn Bayern
 */

public interface LoopTag extends Tag {

    /**
     * Retrieves the current item in the iteration.  Behaves
     * idempotently; calling getCurrent() repeatedly should return the same
     * Object until the iteration is advanced.  (Specifically, calling
     * getCurrent() does <b>not</b> advance the iteration.)
     *
     * @return the current item as an object
     */
    public Object getCurrent();

    /**
     * Retrieves a 'status' object to provide information about the
     * current round of the iteration.
     *
     * @return The LoopTagStatus for the current <tt>LoopTag</tt>.
     */
    public LoopTagStatus getLoopStatus();
}
