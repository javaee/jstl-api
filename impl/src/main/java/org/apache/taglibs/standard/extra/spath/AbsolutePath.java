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
 * <p>Represents an absolute SPath expression.  Essentially a marker
 * class.</p>
 *
 * @author Shawn Bayern
 */
public class AbsolutePath extends Path {

    private boolean all;
    private RelativePath base;

    /**
     * Constructs a new AbsolutePath object based on a RelativePath.
     * An absolute path is the same as a relative path, except that it
     * begins with '/' or '//' (which one, of those two, can be
     * determined by the first Step returned from getSteps()).
     */
    public AbsolutePath(RelativePath base) {
	if (base == null)
	    throw new IllegalArgumentException("non-null base required");
	this.base = base;
    }

    // inherit JavaDoc comment
    public List getSteps() {
	// simply return our base's Step objects
	return base.getSteps();
    }
}
