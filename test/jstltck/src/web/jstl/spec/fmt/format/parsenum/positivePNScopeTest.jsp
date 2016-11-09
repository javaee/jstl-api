<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positivePNScopeTest">
    <fmt:setLocale value="en_US"/>

    <!-- Validate behavior of action with regard to scope.
             If specified, var will be exported to the specified
             scope.  If not specified, var will be exported to the
             page scope -->
    <fmt:parseNumber value="1,234" var="riPage"/>
    <fmt:parseNumber value="1,234" var="rePage" scope="page"/>
    <fmt:parseNumber value="1,234" var="reRequest" scope="request"/>
    <fmt:parseNumber value="1,234" var="reSession" scope="session"/>
    <fmt:parseNumber value="1,234" var="reApplication" scope="application"/>
    <tck:checkScope varName="riPage"/>
    <tck:checkScope varName="rePage"/>
    <tck:checkScope varName="reRequest" inScope="request"/>
    <tck:checkScope varName="reSession" inScope="session"/>
    <tck:checkScope varName="reApplication" inScope="application"/>
    <c:remove var="reApplication" scope="application"/>
</tck:test>
