/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/common/tags/TestTag.java $ $LastChangedDate: 2008-01-15 15:33:10 -0500 (Tue, 15 Jan 2008) $
 */

package com.sun.ts.tests.jstl.common.tags;

import java.io.IOException;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

/**
 * TestTag.java
 * Simple tag to write the start, or header, as well 
 * as the end, or footer, of an HTML document. Note,
 * this tag should be the first and last action of the
 * test.
 */

public class TestTag extends TagSupport {

    // Name of the current test
    private String _name = null;

    // JspWriter for the current PageContext
    private JspWriter _out = null;

    /**
     * Creates a new <code>TestTag</code> instance.
     *
     */
    public TestTag() {
        super();
    }

    /**
     * <code>setTestName</code> sets the current
     * testName for this particular test
     *
     * @param name a <code>String</code> value
     */
    public void setTestName(String name) {
        _name = name;
    }

    /**
     * <code>doStartTag</code> will write the beginnings
     * of a simple HTML document (<html>,<title>, and 
     * <body>).  The value of title will be the value
     * passed in by the testName attribute.
     * 
     * @return <code>EVAL_BODY_INCLUDE</code>
     * @exception JspException if an error occurs
     */
    @Override
    public int doStartTag() throws JspException {
        _out = pageContext.getOut();
        StringBuffer sb = new StringBuffer(50);
        sb.append("<html>\n<head><title>");
        sb.append(_name);
        sb.append("</title></head>\n<body>\n");
        try {
            _out.print(sb.toString());
        } catch (IOException ioe) {
            throw new JspException("Unexpected IOException while writing test header: " + ioe.toString());
        } finally {
            sb = null;
        }
        return EVAL_BODY_INCLUDE;   
    }

    /**
     * <code>doEndTag</code> will write the end of the HTML
     * document once the test has concluded (</body>,</html>);
     *
     * @return <code>EVAL_PAGE</code>
     * @exception JspException if an error occurs
     */
    @Override
    public int doEndTag() throws JspException {
        try {
            _out.print("\n</body>\n</html>\n");
        } catch (IOException ioe) {
            throw new JspException("Unexpected IOException while writing test footer: " + ioe.toString());
        } finally {
           _out = null;
        }
        return EVAL_PAGE;
    }

    /**
     * <code>release</code> is called by the tag
     * handler to release state.  This method is
     * invoked by the JSP page implementation object.
     */
    @Override
    public void release() {
        _name = null;
    }

}// TestTag
