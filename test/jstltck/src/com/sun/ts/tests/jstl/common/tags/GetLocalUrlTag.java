/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/common/tags/GetLocalUrlTag.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.common.tags;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspException;
import java.net.URL;
import java.net.MalformedURLException;

public class GetLocalUrlTag extends javax.servlet.jsp.tagext.TagSupport {
    
    /**
     * Variable name for the result of the action.
     */
    private String _var = null;
    
    /**
     * Path for requested resource.
     */
    private String _path = null;
    
    /** Creates new GetLocalUrl */
    public GetLocalUrlTag() {
        super();
    }
    
/* 
 * public methods
 * ========================================================================
 */
    
    /**
     * Sets the name of the exported variable.
     *
     * @param var variable name to associate the URL result with.
     */
    public void setVar(String var) {
        _var = var;
    }
    
    /**
     * Sets the path of the requested resource.
     *
     * @param path Path of the requested resource.
     */
    public void setPath(String path) {
        _path = path;
    }
    
    /**
     * Creates a new URL based on the server where the tag is running
     * and the path as specified by the user.
     *
     * @return EVAL_PAGE
     */
    public int doEndTag() throws javax.servlet.jsp.JspException {
        ServletRequest req = pageContext.getRequest();
        if (req != null) {
            StringBuffer sb = new StringBuffer(50);
            sb.append("http://").append(req.getServerName()).append(":");
            sb.append(req.getServerPort()).append(_path);
            
            String url = sb.toString();
          
            // validate the URL built is correct.
            try {
                URL u = new URL(url);
            } catch (MalformedURLException mfe) {
                throw new JspException(mfe);
            }
            pageContext.setAttribute(_var, url);
        }
        return EVAL_PAGE;
    }
    
    /**
     * Resets tag state.
     */
    public void release() {
        _var = null;
        _path = null;
    } 
}
