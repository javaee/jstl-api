<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Date" %>
<tck:test testName="positiveFDTimeZoneNullEmpytTest">
    <%  
        Date date = new Date(883192294202L);
        pageContext.setAttribute("dte", date);
    %>
    <fmt:setLocale value="en_US"/>
    <fmt:setTimeZone value="EST"/>

    <!-- If timeZone is null or empty, it will be treated as
             if it was not present. -->
    <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                       timeZone='<%= null %>' type="both"/><br>
    <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                       timeZone="" type="both"/><br>
</tck:test>
