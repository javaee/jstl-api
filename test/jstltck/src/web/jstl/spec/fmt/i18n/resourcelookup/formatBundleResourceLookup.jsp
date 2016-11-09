<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.servlet.jsp.jstl.core.Config" %>
<tck:test testName="formatSetBundleResourceLookup">
    <!-- Lookups are performed in the order of the preferred locales provided
         by the client -->
    <tck:config configVar="fallback" value='<%= request.getParameter("fall") %>'
                op="set"/>
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.${param.res}">
        <fmt:message key="mkey" var="fmessage"/>
        <%
            response.addHeader("message", (String) pageContext.getAttribute("fmessage"));
        %>
    </fmt:bundle>
</tck:test>
