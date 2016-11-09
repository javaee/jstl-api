<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.servlet.jsp.jstl.core.Config" %>
<tck:test testName="positiveConfigGetSetRemoveApplicationTest">
    <!-- Validate the following methods:
           public static Object get(ServletContext context, String name)
           public static void set(ServletContext context, String name, Object var)
           public static void remove(ServletContext context, String name) -->
    <%
        // Set the same variable in diffent scopes, with different values.
        Config.set(application, Config.FMT_LOCALE, "applicationScope");
        
        // Get the values from the PageContext.  The values returned should all be different.
        String app  = (String) Config.get(application, Config.FMT_LOCALE);

        
        if (app.equals("applicationScope")) {
            out.println("Expected value returned from APPLICATION_SCOPE<br>\n");
        } else {
            out.println("Unexpected value returned from APPLICATION_SCOPE<br>\n");
            out.println("Value: " + app + "<br>\n");
        }

        // Remove the values
        Config.remove(application, Config.FMT_LOCALE);

        // All the values returned from another get will be null
        String nApp  = (String) Config.get(application, Config.FMT_LOCALE);
        
        if (nApp == null) {
            out.println("Value removed from APPLICATION_SCOPE<br>\n");
        } else {
            out.println("Unexpected value returned from APPLICATION_SCOPE.  Expected Null.<br>\n");
            out.println("Value: " + nApp + "<br>\n");
        }
    %>
        
</tck:test>
