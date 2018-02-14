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
import javax.servlet.jsp.tagext.VariableInfo;

/**
 * <p>An implementation of TagExtraInfo provided for &lt;declare&gt;.
 * We simply set up a scripting variable for the ID and value that
 * &lt;declare&gt; already stored.  For EA2, DefineTEI *always* declares
 * the variable; no option is given via a tag attribute.  Visibility is
 * always AT_END.</p>
 *
 * @author Shawn Bayern
 */
public class DeclareTEI extends TagExtraInfo {

    // purposely inherit JavaDoc and semantics from TagExtraInfo
    public VariableInfo[] getVariableInfo(TagData data) {
        // construct the relevant VariableInfo object
        VariableInfo id = new VariableInfo(
            data.getAttributeString("id"),
            data.getAttributeString("type") == null ?
		"java.lang.Object" : data.getAttributeString("type"),
            true,
            VariableInfo.AT_END);
        return new VariableInfo[] { id };
    }
}
