<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positivePDScopeTest">
    <c:set var="dte" value="Nov 21, 2000 3:45:02 AM"/>
    <fmt:setLocale value="en_US"/>

    <!-- The presence of the scope attribute will cause var to be
             exported to the available scopes of the PageContext.
             If scope is not specified, var will be exported to the
             page context by default. -->
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dte") %>' var="riPage"/>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dte") %>' var="rePage" scope="page"/>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dte") %>' var="reRequest" scope="request"/>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dte") %>' var="reSession" scope="session"/>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dte") %>' var="reApplication" scope="application"/>
    <tck:checkScope varName="riPage"/>
    <tck:checkScope varName="rePage"/>
    <tck:checkScope varName="reRequest" inScope="request"/>
    <tck:checkScope varName="reSession" inScope="session"/>
    <tck:checkScope varName="reApplication" inScope="application"/>
    <c:remove var="reApplication" scope="application"/>
</tck:test>
