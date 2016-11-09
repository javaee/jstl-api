<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveRemoveScopeTest">
    <!-- Validate that remove will removed the scoped variable
             as specified by scope and var. If scope is not specified,
             var will be removed by pageContext.removeAttribute(attr). -->
    <c:set var="rrea" value="value1" scope="application"/>
    <c:set var="rePage" value="value2" scope="page"/>
    <c:set var="reRequest" value="value3" scope="request"/>
    <c:set var="reSession" value="value4" scope="session"/>
    <c:set var="reApplication" value="value5" scope="application"/>
    <c:remove var="reea"/>
    <c:remove var="rePage" scope="page"/>
    <c:remove var="reRequest" scope="request"/>
    <c:remove var="reSession" scope="session"/>
    <c:remove var="reApplication" scope="application"/>
    <tck:checkScope varName="reaa" inScope="application"/>
    <tck:checkScope varName="rePage"/>
    <tck:checkScope varName="reRequest" inScope="request"/>
    <tck:checkScope varName="reSession" inScope="session"/>
    <tck:checkScope varName="reApplication" inScope="application"/>
</tck:test>
