<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Date" %>
<tck:test testName="positiveFDTypeTest">
    <%  
        Date date = new Date(883192294202L);
        pageContext.setAttribute("dte", date);
    %>
    <c:set var="tim" value="time"/>
    <c:set var="dat" value="date"/>
    <c:set var="bot" value="both"/>
    <fmt:setLocale value="en_US"/>
    <fmt:setTimeZone value="EST"/>

    <!-- the type attribute specifies if either the time or date
             or both components of the provided date value will
             be formatted. If type is not specified, the default is
             date. -->
    date: <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'/><br>
    date: <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                             type='<%= (String) pageContext.getAttribute("dat") %>'/><br>
    date: <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                             type="date"/><br>
    time: <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                             type='<%= (String) pageContext.getAttribute("tim") %>'/><br>
    time: <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                             type="time"/><br>
    both: <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                             type='<%= (String) pageContext.getAttribute("bot") %>'/><br>
    both: <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                             type="both"/><br>
    
</tck:test>
