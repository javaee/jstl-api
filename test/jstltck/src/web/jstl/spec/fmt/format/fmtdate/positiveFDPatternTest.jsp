<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %>
<tck:test testName="positiveFDPatternTest">
    <%  
        Date date = new Date(883192294202L);
        pageContext.setAttribute("dte", date);
    %>
    <c:set var="pat" value="yyyy.MM.dd G 'at' HH:mm:ss z"/>
    <fmt:setLocale value="en_US"/>
    <fmt:setTimeZone value="EST"/>

    <!-- the pattern attribute specifies a custom pattern
             to be applied when formatting the provided date. -->
    <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                       pattern='<%= (String) pageContext.getAttribute("pat") %>'/><br>
    <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                       pattern="yyyy.MM.dd G 'at' HH:mm:ss z"/><br>
</tck:test>
