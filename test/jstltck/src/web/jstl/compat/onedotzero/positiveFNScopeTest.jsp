<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fmt_rt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveFNScopeTest">
    <fmt:setLocale value="en_US"/>
    <!-- EL: Validate the explicit/implicit behavior of the
             action when scope is and isn't provided -->
    <fmt:formatNumber value="12345" var="iPage"/>
    <fmt:formatNumber value="12345" var="ePage" scope="page"/>
    <fmt:formatNumber value="12345" var="eRequest" scope="request"/>
    <fmt:formatNumber value="12345" var="eSession" scope="session"/>
    <fmt:formatNumber value="12345" var="eApplication" scope="application"/>
    <tck:checkScope varName="iPage"/>
    <tck:checkScope varName="ePage"/>
    <tck:checkScope varName="eRequest" inScope="request"/>
    <tck:checkScope varName="eSession" inScope="session"/>
    <tck:checkScope varName="eApplication" inScope="application"/>
    <c:remove var="eApplication" scope="application"/>

    <!-- RT: Validate the explicit/implicit behavior of the
             action when scope is and isn't provided -->
    <fmt_rt:formatNumber value="12345" var="riPage"/>
    <fmt_rt:formatNumber value="12345" var="rePage" scope="page"/>
    <fmt_rt:formatNumber value="12345" var="reRequest" scope="request"/>
    <fmt_rt:formatNumber value="12345" var="reSession" scope="session"/>
    <fmt_rt:formatNumber value="12345" var="reApplication" scope="application"/>
    <tck:checkScope varName="riPage"/>
    <tck:checkScope varName="rePage"/>
    <tck:checkScope varName="reRequest" inScope="request"/>
    <tck:checkScope varName="reSession" inScope="session"/>
    <tck:checkScope varName="reApplication" inScope="application"/>
    <c:remove var="reApplication" scope="application"/>
</tck:test>
