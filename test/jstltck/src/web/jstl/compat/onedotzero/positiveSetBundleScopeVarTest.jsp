<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fmt_rt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveSetBundleScopeVarTest">
    <!-- EL: If scope is specified, var will be exported to that scope.
             If not specified, var will be exported to the page scope
             by default. -->
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                   var="iPage"/>
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                   var="ePage" scope="page"/>
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                   var="eRequest" scope="request"/>
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                   var="eSession" scope="session"/>
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                   var="eApplication" scope="application"/>
    <tck:checkScope varName="iPage"/>
    <tck:checkScope varName="ePage"/>
    <tck:checkScope varName="eRequest" inScope="request"/>
    <tck:checkScope varName="eSession" inScope="session"/>
    <tck:checkScope varName="eApplication" inScope="application"/>
    <c:remove var="eApplication" scope="application"/>

    <!-- RT: If scope is specified, var will be exported to that scope.
             If not specified, var will be exported to the page scope
             by default. -->
    <fmt_rt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                   var="riPage"/>
    <fmt_rt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                   var="rePage" scope="page"/>
    <fmt_rt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                   var="reRequest" scope="request"/>
    <fmt_rt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                   var="reSession" scope="session"/>
    <fmt_rt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                   var="reApplication" scope="application"/>
    <tck:checkScope varName="riPage"/>
    <tck:checkScope varName="rePage"/>
    <tck:checkScope varName="reRequest" inScope="request"/>
    <tck:checkScope varName="reSession" inScope="session"/>
    <tck:checkScope varName="reApplication" inScope="application"/>
    <c:remove var="reApplication" scope="application"/>
</tck:test>
