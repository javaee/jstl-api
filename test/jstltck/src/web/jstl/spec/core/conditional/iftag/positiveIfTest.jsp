<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveIfTest">
    <% 
        pageContext.setAttribute("bTrue", new Boolean("true"));
        pageContext.setAttribute("bFalse", new Boolean("false"));
        pageContext.setAttribute("iOne", new Integer("1"));
    %>
    <c:if test="${bTrue == true}" var="vTrue"/>
    <c:if test="${bFalse == true}" var="vFalse"/>
    <c:if test="${iOne > 0}" var="iCheckTrue"/>
    <c:if test="${iOne < 0}" var="iCheckFalse"/>

    <c:out value="${vTrue}" default="IF Test FAILED"/><br>
    <c:out value="${vFalse}" default="IF Test FAILED"/><br>
    <c:out value="${iCheckTrue}" default="IF Test FAILED"/><br>
    <c:out value="${iCheckFalse}" default="IF Test FAILED"/><br>

    <c:if test="${bTrue}" var="vTrue2"/>
    <c:if test="${vFalse}" var="vFalse2"/>

    <c:out value="${vTrue}" default="IF Test FAILED"/><br>
    <c:out value="${vFalse}" default="IF Test FAILED"/><br>

    <c:if test='<%= true %>' var="sTrue"/>
    <c:if test='<%= false %>' var="sFalse"/>

    <c:out value="${sTrue}" default="IF Test FAILED"/><br>
    <c:out value="${sFalse}" default="IF Test FAILED"/><br>
</tck:test>
