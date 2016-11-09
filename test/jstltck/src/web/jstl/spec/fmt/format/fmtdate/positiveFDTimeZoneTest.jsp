<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Date,java.util.TimeZone" %>
<tck:test testName="positiveFDTimeZoneTest">
    <%  
        Date date = new Date(883192294202L);
        pageContext.setAttribute("dte", date);
        pageContext.setAttribute("tz", TimeZone.getTimeZone("PST"));
    %>
    <fmt:setLocale value="en_US"/>
    <fmt:setTimeZone value="EST"/>

    <!-- The time zone to be applied to the formatted value can
             be explicitly provided to the action.  This will effectively
             overried the timezone of the page -->
    <br>Page is using EST for the timezone.  The formatting action will use PST.  Value should be minus 3 hours.<br>
    No timeZone attribute: <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>' type="both"/><br>
    <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                       timeZone='<%= (TimeZone) pageContext.getAttribute("tz") %>' type="both"/><br>
    <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                       timeZone="PST" type="both"/><br>
</tck:test>
