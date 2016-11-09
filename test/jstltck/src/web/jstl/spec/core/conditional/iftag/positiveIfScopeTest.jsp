<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveIfScopeTest">

    <%-- check scope behavior of tags --%>
    <c:if test="<%= true %>" var="rVar0"/>
    <c:if test="<%= true %>" var="rVar1" scope="page"/>
    <c:if test="<%= true %>" var="rVar2" scope="request"/>
    <c:if test="<%= true %>" var="rVar3" scope="session"/>
    <c:if test="<%= true %>" var="rVar4" scope="application"/>
    <tck:checkScope varName="rVar0"/>
    <tck:checkScope varName="rVar1" inScope="page" />
    <tck:checkScope varName="rVar2" inScope="request"/>
    <tck:checkScope varName="rVar3" inScope="session"/>
    <tck:checkScope varName="rVar4" inScope="application"/>
    <c:remove var="rVar4" scope="application"/>

</tck:test>
