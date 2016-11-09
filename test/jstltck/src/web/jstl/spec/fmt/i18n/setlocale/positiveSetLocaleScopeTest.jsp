<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveSetLocaleScopeTest">

    <!-- validation of scopes -->
    <fmt:setLocale value="en"/>
    <tck:checkScope varName="javax.servlet.jsp.jstl.fmt.locale" useConfig="true"/>
    <c:remove var="javax.servlet.jsp.jstl.fmt.locale.page"/>

    <fmt:setLocale value="en" scope="page"/>
    <tck:checkScope varName="javax.servlet.jsp.jstl.fmt.locale" useConfig="true"/>
    <c:remove var="javax.servlet.jsp.jstl.fmt.locale.page"/>

    <fmt:setLocale value="en" scope="request"/>
    <tck:checkScope varName="javax.servlet.jsp.jstl.fmt.locale" inScope="request" useConfig="true"/>
    <c:remove var="javax.servlet.jsp.jstl.fmt.locale.request"/>

    <fmt:setLocale value="en" scope="session"/>
    <tck:checkScope varName="javax.servlet.jsp.jstl.fmt.locale" inScope="session" useConfig="true"/>
    <c:remove var="javax.servlet.jsp.jstl.fmt.locale.session"/>

    <fmt:setLocale value="en" scope="application"/>
    <tck:checkScope varName="javax.servlet.jsp.jstl.fmt.locale" inScope="application" useConfig="true"/>
    <c:remove var="javax.servlet.jsp.jstl.fmt.locale.application"/>
</tck:test>
