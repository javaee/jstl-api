<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveFNScopeTest">
    <fmt:setLocale value="en_US"/>

    <!-- Validate the explicit/implicit behavior of the
             action when scope is and isn't provided -->
    <fmt:formatNumber value="12345" var="riPage"/>
    <fmt:formatNumber value="12345" var="rePage" scope="page"/>
    <fmt:formatNumber value="12345" var="reRequest" scope="request"/>
    <fmt:formatNumber value="12345" var="reSession" scope="session"/>
    <fmt:formatNumber value="12345" var="reApplication" scope="application"/>
    <tck:checkScope varName="riPage"/>
    <tck:checkScope varName="rePage"/>
    <tck:checkScope varName="reRequest" inScope="request"/>
    <tck:checkScope varName="reSession" inScope="session"/>
    <tck:checkScope varName="reApplication" inScope="application"/>
    <c:remove var="reApplication" scope="application"/>
</tck:test>
