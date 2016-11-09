<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@page contentType="text/html"%>
<% 
    if (request.getParameter("testparm") != null) {
        out.println("testparm found!<br>");
    } else {
        out.println("testparm was not available!<br>");
    }
%>
