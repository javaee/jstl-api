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
import java.util.Vector;

/**
 * <p>Represents a relative SPath expression.</p>
 *
 * @author Shawn Bayern
 */
public class RelativePath extends Path {

    private RelativePath next;
    private Step step;

    /**
     * Constructs a new RelativePath object, based on a Step and another
     * (possibly null) RelativePath.  If 'all' is true, then the path
     * matches all instances of 'next' underneath 'step'; otherwise;
     * 'next' must be an immediate child of 'step'.
     */
    public RelativePath(Step step, RelativePath next) {
	if (step == null)
	    throw new IllegalArgumentException("non-null step required");
	this.step = step;
	this.next = next;
    }

    // inherit JavaDoc comment
    public List getSteps() {
	// simply merge our 'step' with our 'next'
	List l;
	if (next != null)
	    l = next.getSteps();
	else
	    l = new Vector();
	l.add(0, step);
	return l;
    }
}
