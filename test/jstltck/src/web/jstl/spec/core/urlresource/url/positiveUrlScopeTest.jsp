<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveUrlScopeTest">

    <!-- Validate the export of var to various scopes (explicit and
             implicit) -->
    <c:url var="riPage" value="/jstltck-core/jstl"/>
    <c:url var="rePage" value="/jstltck-core/jstl" scope="page"/>
    <c:url var="reRequest" value="/jstltck-core/jstl" scope="request"/>
    <c:url var="reSession" value="/jstltck-core/jstl" scope="session"/>
    <c:url var="reApplication" value="/jstltck-core/jstl" scope="application"/>
    <tck:checkScope varName="riPage"/>
    <tck:checkScope varName="rePage"/>
    <tck:checkScope varName="reRequest" inScope="request"/>
    <tck:checkScope varName="reSession" inScope="session"/>
    <tck:checkScope varName="reApplication" inScope="application"/>
    <c:remove var="reApplication" scope="application"/>
</tck:test>
