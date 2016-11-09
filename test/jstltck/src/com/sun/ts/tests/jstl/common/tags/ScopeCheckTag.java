/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/common/tags/ScopeCheckTag.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.common.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.jstl.core.Config;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Simple tag to interrogate the PageContext for
 * attributes in a specific scope.
 */

public class ScopeCheckTag extends TagSupport {
    
    private static final String PAGE = "page";
    private static final String REQUEST = "request";
    private static final String SESSION = "session";    
    
    /** Scoped variable to search for.
     */
    private String _varName = null;
    
    /** Scope in which the variable should be found.
     */
    private String _inScope = PAGE;
    
    /** 
     * Determines whether or not we use the Config
     * class for lookups.
     */
    private boolean _useConfig = false;

    /** Creates new ScopeCheckTag */
    public ScopeCheckTag() {
        super();
    }

/* 
 * public methods
 * ========================================================================
 */
    
    /**
     * Sets the name of the variable to search for.
     *
     * @param varName variable name
     */
    public void setVarName(String varName) {
        _varName = varName;
    }
    
    /**
     * Sets the scope in which the variable is expected
     * to be found.
     *
     * @param inScope scope to search
     */
    public void setInScope(String inScope) {
        _inScope = inScope;
    }
    
    /**
     * Flag which will, depending on the value,
     * append the scope to the variable name provided.
     *
     * @param useConfig if true, the Config class will
     *        be used for the lookup.
     */
    public void setUseConfig(boolean useConfig) {
        _useConfig = useConfig;
    }
    
    /**
     * When called, the PageContext will be checked for the 
     * specified variable in the specified scope.
     * A message will be written to the current JspWriter
     * indicating if the variable was found or not.
     *
     * @return EVAL_BODY
     */
    public int doEndTag() throws JspException {
        Object attribute = null;
      
        try {
            attribute = getAttribute();      
        
            if (attribute != null) {
                pageContext.getOut().println("<strong>" + _varName + 
                                             "</strong> found in <strong>" + 
                                             _inScope + "</strong> scope.<br>");
            } else {
                pageContext.getOut().println("<strong>" + _varName + 
                                             "</strong> not found in specified " +
                                             "scope:<strong>" + _inScope + 
                                             "</strong>.<br>");
            }
        } catch (IOException ioe) {
            try {
                pageContext.getOut().println("<strong>Error:</strong> " +
                                             "Unexpected Exception: " + 
                                             ioe.toString());
            } catch (Throwable t) {
                ;
            }
        }
        return EVAL_PAGE;
    }
    
    /**
     * <code>release</code> is called by the tag
     * handler to release state.  This method is
     * invoked by the JSP page implementation object.
     */
    public void release() {
        _varName = null;
        _inScope = PAGE;
        _useConfig = false;
    }
    
    //------------------------------------------------------ Private Methods --
    
    private Object getAttribute() {
        int targetScope = getScopeFromName(_inScope);               
        if (_useConfig) {            
            return Config.get(pageContext, _varName, targetScope);
        } else {
            return pageContext.getAttribute(_varName, targetScope);
        }
    }
    
    private int getScopeFromName(String scope) {
        if (scope.equals(PAGE)) {
            return PageContext.PAGE_SCOPE;
        } else if (scope.equals(REQUEST)) {
            return PageContext.REQUEST_SCOPE;
        } else if (scope.equals(SESSION)) {
            return PageContext.SESSION_SCOPE;
        } else {
            return PageContext.APPLICATION_SCOPE;
        }
    }
}
