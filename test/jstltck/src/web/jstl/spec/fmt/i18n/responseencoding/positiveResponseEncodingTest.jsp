<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.servlet.jsp.jstl.fmt.LocalizationContext" %>
<tck:test testName="positiveBundleResponseSettersTest">

    <c:if test="${param.action == 'bundle' and param.type == 'rt'}">
        <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources"/>
    </c:if>

    <c:if test="${param.action == 'locale' and param.type == 'rt'}">
        <fmt:setLocale value="en"/>
    </c:if>

    <c:if test="${param.action == 'setbundle' && param.type == 'rt'}">
        <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                       var="tBundle" scope="application"/>
    </c:if>

    <c:if test="${param.action == 'message' and param.type == 'rt'}">
        <fmt:message key="mkey"
                        bundle='<%= (LocalizationContext) pageContext.getAttribute("tBundle", PageContext.APPLICATION_SCOPE) %>'/>
        <c:remove var="tBundle" scope="application"/>
    </c:if>
</tck:test>
