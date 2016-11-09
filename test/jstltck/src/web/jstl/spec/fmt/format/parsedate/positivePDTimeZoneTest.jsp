<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.TimeZone" %>
<tck:test testName="positivePDTimeZoneTest">
    <%
        pageContext.setAttribute("tz", TimeZone.getTimeZone("PST"));
    %>
    <c:set var="dte" value="Nov 21, 2000 3:45 AM"/>
    <fmt:setLocale value="en_US"/>
    <fmt:setTimeZone value="EST"/>

    <!-- The time zone to be applied to the formatted value can
             be explicitly provided to the action.  This will effectively
             overried the timezone of the page -->
    <br>Page is using EST for the timezone.  The formatting action will use PST.  Value should be offset 3 hours.<br>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dte") %>' type="both" timeStyle="short" var="rdef"/>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dte") %>'
                       timeZone='<%= (TimeZone) pageContext.getAttribute("tz") %>' type="both" timeStyle="short" var="rpst1"/>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dte") %>'
                       timeZone="PST" type="both" timeStyle="short" var="rpst2"/>
    No timeZone attribute: <fmt:formatDate value="${rdef}" timeZone="EST" type="both" timeStyle="short"/><br>
    <fmt:formatDate value="${rpst1}" timeZone="EST" type="both" timeStyle="short"/><br>
    <fmt:formatDate value="${rpst2}" timeZone="EST" type="both" timeStyle="short"/><br>
</tck:test>
