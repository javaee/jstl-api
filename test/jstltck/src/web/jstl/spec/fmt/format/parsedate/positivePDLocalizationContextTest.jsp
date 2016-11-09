<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positivePDLocalizationContextTest">
    <fmt:setTimeZone value="EST"/>
    <c:set var="dte" value="Nov 21, 2000"/>
    <c:set var="dtim" value="3:45:02 AM"/>
    <c:set var="dt" value="Nov 21, 2000 3:45:02 AM"/> 
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"/>

    <!-- Validate that the action is able to dermine the
             formatting locale based on the localizationContext configuration
             variable. -->
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dte") %>' var="r1"/>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dtim") %>' type="time" var="r2"/>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dt") %>' type="both" var="r3"/>
    <fmt:formatDate value="${r1}" timeZone="EST"/><br>
    <fmt:formatDate value="${r2}" timeZone="EST" type="time"/><br>
    <fmt:formatDate value="${r3}" timeZone="EST" type="both"/><br>

</tck:test>
