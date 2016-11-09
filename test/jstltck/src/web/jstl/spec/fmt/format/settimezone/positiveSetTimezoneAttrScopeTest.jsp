<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveTimezoneAttrScopeTest">

    <!-- If scope is specified and var is not, the
             javax.servlet.jsp.jstl.fmt.timeZone attribute will
             be set to the scope specified (implicit or explicit). -->
    <fmt:setTimeZone value="PST"/>
    <tck:checkScope varName="javax.servlet.jsp.jstl.fmt.timeZone" useConfig="true"/>
    <c:remove var="javax.serlvet.jsp.jstl.fmt.timeZone.page"/>
    <fmt:setTimeZone value="PST" scope="page"/>
    <tck:checkScope varName="javax.servlet.jsp.jstl.fmt.timeZone" useConfig="true"/>
    <c:remove var="javax.servlet.jsp.jstl.fmt.timeZone.page"/>
    <fmt:setTimeZone value="PST" scope="request"/>
    <tck:checkScope varName="javax.servlet.jsp.jstl.fmt.timeZone" inScope="request" useConfig="true"/>
    <c:remove var="javax.servlet.jsp.jstl.fmt.timeZone.request"/>
    <fmt:setTimeZone value="PST" scope="session"/>
    <tck:checkScope varName="javax.servlet.jsp.jstl.fmt.timeZone" inScope="session" useConfig="true"/>
    <c:remove var="javax.servlet.jsp.jstl.fmt.timeZone.session"/>
    <fmt:setTimeZone value="PST" scope="application"/>
    <tck:checkScope varName="javax.servlet.jsp.jstl.fmt.timeZone" inScope="application" useConfig="true"/>
    <c:remove var="javax.servlet.jsp.jstl.fmt.timeZone.applciation"/>
</tck:test>
