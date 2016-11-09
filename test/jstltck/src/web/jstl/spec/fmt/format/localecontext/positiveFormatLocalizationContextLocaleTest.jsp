<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Date" %>
<tck:test testName="positiveFormatLocalizationContextLocaleTest">
    <%  
        Date date = new Date(883192294202L);
        pageContext.setAttribute("dte", date);
    %>
    <fmt:setTimeZone value="EST"/>
    <fmt:setLocale value="en_US"/>
    <c:set var="dt" value="Nov 21, 2000 3:45:02 AM"/>

    <!-- If the javax.servlet.jsp.jstl.fmt.locale attribute
             is present, it will take precedence over the browser
             supplied preferred locales. --> 
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dt") %>' type="both" var="p2"/>
    <fmt:formatDate value='<%= (Date) pageContext.getAttribute("p2") %>' type="both"/>
    <fmt:parseNumber value="1,234"/>
    <fmt:formatNumber value="1234"/>
</tck:test>
