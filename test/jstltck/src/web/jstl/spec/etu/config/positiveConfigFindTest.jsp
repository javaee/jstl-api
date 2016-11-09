<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.servlet.jsp.jstl.core.Config" %>
<tck:test testName="positiveConfigFindTest">
    <!-- Validate the following methods:
           public static Object find(PageContext pageContext, String name) -->
    <%
        // Set the same variable in diffent scopes, with different values.
        Config.set(application, Config.FMT_LOCALE, "scopedObject");
        
        // Find the value in the PageContext.
        String found  = (String) Config.find(pageContext, Config.FMT_LOCALE);

        
        if (found.equals("scopedObject")) {
            out.println("Expected value returned from find()<br>\n");
        } else {
            out.println("Unexpected value returned from find()<br>\n");
            out.println("Value: " + found + "<br>\n");
        }

        // Remove the value
        Config.remove(application, Config.FMT_LOCALE);

        // If no value found in the PageContext, check for an 
        // context initialialization parameter identified by name.
        String init  = (String) Config.find(pageContext, Config.FMT_LOCALE);
        
        if (init != null && init.equals("en-US")) {
            out.println("Context initialization parameter obtained.\n");
        } else {
            out.println("Unexpected value returned when getting Context initialization parameter.<br>\n");
            out.println("Value: " + init + "<br>\n");
        }
    %>
        
</tck:test>
