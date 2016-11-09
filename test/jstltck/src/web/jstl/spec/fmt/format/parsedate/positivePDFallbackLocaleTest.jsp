<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Date" %>
<tck:test testName="positivePDFallbackLocaleTest">
    <fmt:setTimeZone value="EST"/>
    <c:set var="dte" value="Nov 21, 2000"/>
    <c:set var="dtim" value="3:45:02 AM"/>
    <c:set var="dt" value="Nov 21, 2000 3:45:02 AM"/> 
    <tck:config op="set" configVar="fallback" value="en-US"/>

    <!-- The fallbackLocale configuration variable will be
             used if no locale match can be determined. -->
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dte") %>' var="r1"/>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dtim") %>' type="time" var="r2"/>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dt") %>' type="both" var="r3"/>
    <fmt:formatDate value="${r1}" timeZone="EST"/><br>
    <fmt:formatDate value="${r2}" timeZone="EST" type="time"/><br>
    <fmt:formatDate value="${r3}" timeZone="EST" type="both"/><br>
</tck:test>
