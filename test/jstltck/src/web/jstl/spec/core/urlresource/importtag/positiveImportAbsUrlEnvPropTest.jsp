<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveImportAbsUrlEnvPropTest">
    <%
        StringBuffer sb = new StringBuffer(75);
        sb.append(request.getScheme()).append("://");
        sb.append(request.getServerName()).append(":");
        sb.append(request.getServerPort());
        sb.append("/jstl_core_url_import_web/env.jsp");
        application.setAttribute("app", "available");
        session.setAttribute("sess", "available");
        request.setAttribute("req", "available");
    %>
    <c:import url="<%= sb.toString() %>"/>
    <%
        application.removeAttribute("app");
        session.removeAttribute("sess");
    %>
</tck:test>
