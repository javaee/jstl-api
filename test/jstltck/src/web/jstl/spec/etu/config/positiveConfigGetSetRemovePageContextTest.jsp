<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.servlet.jsp.jstl.core.Config" %>
<tck:test testName="positiveConfigGetSetRemovePageContextTest">
    <!-- Validate the following methods:
           public static Object get(PageContext pageContext, String name, int scope)
           public static void set(PageContext pageContext, String name, int scope)
           public static void remove(PageContext pageContext, String name, int scope) -->
    <%
        // Set the same variable in diffent scopes, with different values.
        Config.set(pageContext, Config.FMT_LOCALE, "pageScope", PageContext.PAGE_SCOPE);
        Config.set(pageContext, Config.FMT_LOCALE, "requestScope", PageContext.REQUEST_SCOPE);
        Config.set(pageContext, Config.FMT_LOCALE, "sessionScope", PageContext.SESSION_SCOPE);
        Config.set(pageContext, Config.FMT_LOCALE, "applicationScope", PageContext.APPLICATION_SCOPE);
        
        // Get the values from the PageContext.  The values returned should all be different.
        String ipage = (String) Config.get(pageContext, Config.FMT_LOCALE, PageContext.PAGE_SCOPE);
        String req  = (String) Config.get(pageContext, Config.FMT_LOCALE, PageContext.REQUEST_SCOPE);
        String ses  = (String) Config.get(pageContext, Config.FMT_LOCALE, PageContext.SESSION_SCOPE);
        String app  = (String) Config.get(pageContext, Config.FMT_LOCALE, PageContext.APPLICATION_SCOPE);

        if (ipage.equals("pageScope")) {
            out.println("Expected value returned from PAGE_SCOPE<br>\n");
        } else {
            out.println("Unexpected value returned from PAGE_SCOPE<br>\n");
            out.println("Value: " + ipage + "<br>\n");
        }
        if (req.equals("requestScope")) {
            out.println("Expected value returned from REQUEST_SCOPE<br>\n");
        } else {
            out.println("Unexpected value returned from REQUEST_SCOPE<br>\n");
            out.println("Value: " + req + "<br>\n");
        }
        if (ses.equals("sessionScope")) {
            out.println("Expected value returned from SESSION_SCOPE<br>\n");
        } else {
            out.println("Unexpected value returned from SESSION_SCOPE<br>\n");
            out.println("Value: " + ses + "<br>\n");
        }
        if (app.equals("applicationScope")) {
            out.println("Expected value returned from APPLICATION_SCOPE<br>\n");
        } else {
            out.println("Unexpected value returned from APPLICATION_SCOPE<br>\n");
            out.println("Value: " + app + "<br>\n");
        }

        // Remove the values
        Config.remove(pageContext, Config.FMT_LOCALE, PageContext.PAGE_SCOPE);
        Config.remove(pageContext, Config.FMT_LOCALE, PageContext.REQUEST_SCOPE);
        Config.remove(pageContext, Config.FMT_LOCALE, PageContext.SESSION_SCOPE);
        Config.remove(pageContext, Config.FMT_LOCALE, PageContext.APPLICATION_SCOPE);

        // All the values returned from another get will be null
        String nPage = (String) Config.get(pageContext, Config.FMT_LOCALE, PageContext.PAGE_SCOPE);
        String nReq  = (String) Config.get(pageContext, Config.FMT_LOCALE, PageContext.REQUEST_SCOPE);
        String nSes  = (String) Config.get(pageContext, Config.FMT_LOCALE, PageContext.SESSION_SCOPE);
        String nApp  = (String) Config.get(pageContext, Config.FMT_LOCALE, PageContext.APPLICATION_SCOPE);
        
        if (nPage == null) {
            out.println("Value removed from PAGE_SCOPE<br>\n");
        } else {
            out.println("Unexpected value returned from PAGE_SCOPE.  Expected Null.<br>\n");
            out.println("Value: " + nPage + "<br>\n");
        }
        if (nReq == null) {
            out.println("Value removed from REQUEST_SCOPE<br>\n");
        } else {
            out.println("Unexpected value returned from REQUEST_SCOPE.  Expected Null.<br>\n");
            out.println("Value: " + nReq + "<br>\n");
        }
        if (nSes == null) {
            out.println("Value removed from SESSION_SCOPE<br>\n");
        } else {
            out.println("Unexpected value returned from SESSION_SCOPE.  Expected Null.<br>\n");
            out.println("Value: " + nSes + "<br>\n");
        }
        if (nApp == null) {
            out.println("Value removed from APPLICATION_SCOPE<br>\n");
        } else {
            out.println("Unexpected value returned from APPLICATION_SCOPE.  Expected Null.<br>\n");
            out.println("Value: " + nApp + "<br>\n");
        }
    %>
        
</tck:test>
