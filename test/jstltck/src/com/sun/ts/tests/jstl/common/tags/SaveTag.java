/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.ts.tests.jstl.common.tags;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.util.ArrayList;

public class SaveTag extends SimpleTagSupport {

    private ValueExpression attr; 

    public void setAttr(ValueExpression attr) {
        this.attr = attr;
    }

    public void doTag() throws JspException {

        PageContext pc = (PageContext) getJspContext();
        ELContext elContext = pc.getELContext();
        JspWriter out = pc.getOut();

        try {
            ArrayList list = (ArrayList)
                 pc.getAttribute("alist", PageContext.APPLICATION_SCOPE);
            if (list == null) {
                list = new ArrayList();
                pc.setAttribute("alist", list, PageContext.APPLICATION_SCOPE);
            }
            list.add(attr);
        } catch (Exception ex) {
            throw new JspException(ex);
        }
    }
}
