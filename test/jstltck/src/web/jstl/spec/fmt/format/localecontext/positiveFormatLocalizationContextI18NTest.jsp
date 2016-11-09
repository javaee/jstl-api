<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Date" %>
<tck:test testName="positiveFormatLocalizationContextI18NTest">
    <%  
        Date date = new Date(883192294202L);
        pageContext.setAttribute("dte", date);
    %>
    <fmt:setTimeZone value="EST"/>
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources1"/>
    <fmt:setLocale value="de_DE"/>
    <c:set var="dt" value="Nov 21, 2000 3:45:02 AM"/>

    <!-- If the javax.servlet.jstl.fmt.localizationContext scoped attribute is available,
             this will be used in preference to the javax.servlet.jstl.fmt.locale
             attribute. -->
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dt") %>' type="both" var="p2"/>
    <fmt:formatDate value='<%= (Date) pageContext.getAttribute("p2") %>' type="both"/>
    <fmt:parseNumber value="1,234"/>
    <fmt:formatNumber value="1234"/>
</tck:test>
