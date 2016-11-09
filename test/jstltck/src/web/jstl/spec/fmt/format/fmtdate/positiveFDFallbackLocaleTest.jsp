<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Date" %>
<tck:test testName="positiveFDFallbackLocaleTest">
    <%  
        Date date = new Date(883192294202L);
        pageContext.setAttribute("dte", date);
    %>
    <fmt:setTimeZone value="EST"/>
    <tck:config op="set" configVar="fallback" value="en-US"/>
    <!-- The fallbackLocale configuration variable will be
             used if no locale match can be determined. -->
    <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'/>
    <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>' type="time"/>
    <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>' type="both"/>
</tck:test>
