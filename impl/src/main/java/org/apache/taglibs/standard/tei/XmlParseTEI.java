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

package org.apache.taglibs.standard.tei;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;

/**
 * <p>An implementation of TagExtraInfo that implements validation for
 * <x:parse>'s attributes</p>
 *
 * @author Shawn Bayern
 */
public class XmlParseTEI extends TagExtraInfo {

    final private static String VAR = "var";
    final private static String VAR_DOM = "varDom";
    final private static String SCOPE = "scope";
    final private static String SCOPE_DOM = "scopeDom";

    public boolean isValid(TagData us) {
	// must have no more than one of VAR and VAR_DOM ...
	if (Util.isSpecified(us, VAR) && Util.isSpecified(us, VAR_DOM))
	    return false;

	// ... and must have no less than one of VAR and VAR_DOM
	if (!(Util.isSpecified(us, VAR) || Util.isSpecified(us, VAR_DOM)))
	    return false;

	// When either 'scope' is specified, its 'var' must be specified
	if (Util.isSpecified(us, SCOPE) && !Util.isSpecified(us, VAR))
	    return false;
	if (Util.isSpecified(us, SCOPE_DOM) && !Util.isSpecified(us, VAR_DOM))
	    return false;

        return true;
    }

}
