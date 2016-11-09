<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Date" %>
<tck:test testName="positiveFDScopeTest">
     <%  
        Date date = new Date(102142631861L);
        pageContext.setAttribute("dte", date);
    %>
    <fmt:setLocale value="en_US"/>
    <fmt:setTimeZone value="EST"/>

    <!-- The presence of the scope attribute will cause var to be
             exported to the available scopes of the PageContext.
             If scope is not specified, var will be exported to the
             page context by default. -->
    <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>' var="riPage"/>
    <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>' var="rePage" scope="page"/>
    <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>' var="reRequest" scope="request"/>
    <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>' var="reSession" scope="session"/>
    <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>' var="reApplication" scope="application"/>
    <tck:checkScope varName="riPage"/>
    <tck:checkScope varName="rePage"/>
    <tck:checkScope varName="reRequest" inScope="request"/>
    <tck:checkScope varName="reSession" inScope="session"/>
    <tck:checkScope varName="reApplication" inScope="application"/>
    <c:remove var="reApplication" scope="application"/>
</tck:test>
