<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveIfScopeTest">
    <%-- check scope behavior of EL tags --%>
    <%
        pageContext.setAttribute("bTrue", new Boolean("true"));
    %>
    <c:if test="${bTrue}" var="eVar0"/>
    <c:if test="${bTrue}" var="eVar1" scope="page"/>
    <c:if test="${bTrue}" var="eVar2" scope="request"/>
    <c:if test="${bTrue}" var="eVar3" scope="session"/>
    <c:if test="${bTrue}" var="eVar4" scope="application"/>
    <tck:checkScope varName="eVar0"/>
    <tck:checkScope varName="eVar1"/>
    <tck:checkScope varName="eVar2" inScope="request"/>
    <tck:checkScope varName="eVar3" inScope="session"/>
    <tck:checkScope varName="eVar4" inScope="application"/>
    <c:remove var="eVar4" scope="application"/>


    <%-- check scope behavior of RT tags --%>
    <c_rt:if test="<%= true %>" var="rVar0"/>
    <c_rt:if test="<%= true %>" var="rVar1" scope="page"/>
    <c_rt:if test="<%= true %>" var="rVar2" scope="request"/>
    <c_rt:if test="<%= true %>" var="rVar3" scope="session"/>
    <c_rt:if test="<%= true %>" var="rVar4" scope="application"/>
    <tck:checkScope varName="rVar0"/>
    <tck:checkScope varName="rVar1"/>
    <tck:checkScope varName="rVar2" inScope="request"/>
    <tck:checkScope varName="rVar3" inScope="session"/>
    <tck:checkScope varName="rVar4" inScope="application"/>
    <c:remove var="rVar4" scope="application"/>

</tck:test>
