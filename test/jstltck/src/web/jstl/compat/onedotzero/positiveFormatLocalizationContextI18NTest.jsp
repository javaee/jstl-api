<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fmt_rt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
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
    <!-- EL: If the javax.servlet.jstl.fmt.localizationContext scoped attribute is available,
             this will be used in preference to the javax.servlet.jstl.fmt.locale
             attribute. -->
    <fmt:parseDate value="${dt}" type="both" var="p1"/>
    <fmt:formatDate value="${p1}" type="both"/>
    <fmt:parseNumber value="1,234"/>
    <fmt:formatNumber value="1234"/>

    <!-- EL: If the javax.servlet.jstl.fmt.localizationContext scoped attribute is available,
             this will be used in preference to the javax.servlet.jstl.fmt.locale
             attribute. -->
    <fmt_rt:parseDate value='<%= (String) pageContext.getAttribute("dt") %>' type="both" var="p2"/>
    <fmt_rt:formatDate value='<%= (Date) pageContext.getAttribute("p2") %>' type="both"/>
    <fmt_rt:parseNumber value="1,234"/>
    <fmt_rt:formatNumber value="1234"/>
</tck:test>
