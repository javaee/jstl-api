<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%
    if (application.getAttribute("app") != null) {
        out.println("Application: Available<br>");
    } else {
        out.println("Application: Not Available<br>");
    }
    if (session.getAttribute("sess") != null) {
        out.println("Session: Avaliable<br>");
    } else {
        out.println("Session: Not Available<br>");
    }
    if (request.getAttribute("req") != null) {
        out.println("Request: Available<br>");
    } else {
        out.println("Request: Not Available<br>");
    }
    if (request.getParameter("reqpar") != null) {
        out.println("Request Param: Available<br>");
    } else {
        out.println("Request Param: Not Available<br>");
    }
%>
