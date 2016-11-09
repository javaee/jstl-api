<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fmt_rt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Date" %>
<tck:test testName="positiveFDValueTest">
    <%  
        Date date = new Date(883192294202L);
        pageContext.setAttribute("dte", date);
    %>
    <fmt:setLocale value="en_US"/>
    <fmt:setTimeZone value="EST"/>
    <!-- EL: Validate the the action can properly format a date
             Date -->
    <fmt:formatDate value="${dte}"/><br>

    <!-- RT: Validate the the action can properly format a date
             Date -->
    <fmt_rt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'/><br>
</tck:test>
