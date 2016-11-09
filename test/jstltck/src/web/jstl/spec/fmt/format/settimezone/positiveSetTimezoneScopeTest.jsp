<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveTimezoneScopeTest">

    <!-- Validate that that var is exported to the appropriate
             scope as specified by the scope attribute explicitly
             or implicitly. -->
    <fmt:setTimeZone value="PST" var="riPage"/>
    <fmt:setTimeZone value="PST" var="rePage" scope="page"/>
    <fmt:setTimeZone value="PST" var="reRequest" scope="request"/>
    <fmt:setTimeZone value="PST" var="reSession" scope="session"/>
    <fmt:setTimeZone value="PST" var="reApplication" scope="application"/>
    <tck:checkScope varName="riPage"/>
    <tck:checkScope varName="rePage"/>
    <tck:checkScope varName="reRequest" inScope="request"/>
    <tck:checkScope varName="reSession" inScope="session"/>
    <tck:checkScope varName="reApplication" inScope="application"/> 
</tck:test>
