<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveImportRelUrlEnvPropTest">
    <%
        application.setAttribute("app", "available");
        session.setAttribute("sess", "available");
        request.setAttribute("req", "available");
    %>
    <c:import url="/env.jsp"/>
    <%
        application.removeAttribute("app");
        session.removeAttribute("sess");
    %>
</tck:test>
