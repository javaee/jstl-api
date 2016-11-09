<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveImportScopeTest">

    <!-- Test scopes -->
    <!-- Page should be the default... -->
    <c:import url="import.txt" var="rpageDef"/>
    <!-- Explicit scope definitions... -->
    <c:import url="import.txt" var="rexpPage" scope="page"/>
    <c:import url="import.txt" var="rexpRequest" scope="request"/>
    <c:import url="import.txt" var="rexpSession" scope="session"/>
    <c:import url="import.txt" var="rexpApplication" scope="application"/>
    <tck:checkScope varName="rpageDef"/>
    <tck:checkScope varName="rexpPage"/>
    <tck:checkScope varName="rexpRequest" inScope="request"/>
    <tck:checkScope varName="rexpSession" inScope="session"/>
    <tck:checkScope varName="rexpApplication" inScope="application"/>
    <c:remove var="rexpApplication" scope="application"/>
</tck:test>

