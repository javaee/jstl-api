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

package org.apache.taglibs.standard.extra.spath;

import java.util.List;

/**
 * <p>Represents a simple path (SPath) expression.  A path is an ordered
 * list of Steps.
 *
 * @author Shawn Bayern
 */
public abstract class Path {

    /**
     * Retrives an ordered list of Step objects representing this
     * expression.  The result is safely modifiable by the caller and
     * must support List.add(Object) and List.add(int, Object).
     */
    public abstract List getSteps();

}
