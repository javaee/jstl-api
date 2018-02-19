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


/**
 * <p>Tag handler for &lt;otherwise&gt; in JSTL.</p>
 *
 * @author Shawn Bayern
 */

public class OtherwiseTag extends WhenTagSupport {

    /*
     * <otherwise> is just a <when> that always tries to evaluate its body
     * if it has permission from its parent tag.
     */

    // Don't let the condition stop us... :-)
    protected boolean condition() {
        return true;
    }
}
