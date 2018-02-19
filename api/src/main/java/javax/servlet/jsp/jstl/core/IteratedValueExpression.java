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

import javax.el.ELContext;
import javax.el.ValueExpression;

/**
 * @author Kin-man Chung
 * @version $Id: IteratedValueExpression.java,v 1.2 2005/12/08 01:20:43 kchung Exp $
 */
public final class IteratedValueExpression extends ValueExpression {

    private static final long serialVersionUID = 1L;
    protected final int i;
    protected final IteratedExpression iteratedExpression;

    public IteratedValueExpression(IteratedExpression iteratedExpr, int i) {
        this.i = i;
        this.iteratedExpression = iteratedExpr;
    }

    public Object getValue(ELContext context) {
        return iteratedExpression.getItem(context, i);
    }

    public void setValue(ELContext context, Object value) {
    }

    public boolean isReadOnly(ELContext context) {
        return true;
    }

    public Class getType(ELContext context) {
        return null;
    }

    public Class getExpectedType() {
        return Object.class;
    }

    public String getExpressionString() {
        return iteratedExpression.getValueExpression().getExpressionString();
    }

    public boolean equals(Object obj) {
        return iteratedExpression.getValueExpression().equals(obj);
    }

    public int hashCode() {
        return iteratedExpression.getValueExpression().hashCode();
    }

    public boolean isLiteralText() {
        return false;
    }
}

