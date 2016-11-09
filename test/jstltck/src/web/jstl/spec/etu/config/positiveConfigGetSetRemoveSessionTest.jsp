<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.servlet.jsp.jstl.core.Config" %>
<tck:test testName="positiveConfigGetSetRemoveSessionTest">
    <!-- Validate the following methods:
           public static Object get(HttpSession session, String name)
           public static void set(HttpSession session, String name, Object var)
           public static void remove(HttpSession session, String name) -->
    <%
        // Set the same variable in diffent scopes, with different values.
        Config.set(session, Config.FMT_LOCALE, "sessionScope");
        
        // Get the values from the PageContext.  The values returned should all be different.
        String ses  = (String) Config.get(session, Config.FMT_LOCALE);

        
        if (!ses.equals("sessionScope")) {
            out.println("Test FAILED.  Unexpected value returned from SESSION_SCOPE<br>\n");
            out.println("Value: " + ses + "<br>\n");
            return; 
        } 

        // Remove the values
        Config.remove(session, Config.FMT_LOCALE);

        // All the values returned from another get will be null
        ses = (String) Config.get(session, Config.FMT_LOCALE);
        
        if (ses != null) {
            out.println("Test FAILED.  Unexpected value returned from SESSION_SCOPE.  Expected Null.<br>\n");
            out.println("Value: " + ses + "<br>\n");
            return;
        } 

        // Add the value back and invalidate the session
       Config.set(session, Config.FMT_LOCALE, "sessionScope");
       session.invalidate();

       // value must be null
       ses = (String) Config.get(session, Config.FMT_LOCALE);
       if (ses != null) {
          out.println("Test FAILED.  Unexpected value returned from SESSION_SCOPE.  Execpted 'null'.<br>\n");
          out.println("Value: " + ses + "<br>\n");
          return;
       }
       
       // all good, so pass the test
       out.println("Test PASSED");
    %>
        
</tck:test>
