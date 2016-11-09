<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Date" %>
<tck:test testName="positiveTimezoneValueNullEmptyTest">
    <%
        Date date = new Date(883192294202L);
        pageContext.setAttribute("dte", date);
    %>

    <!-- If value is null or empty, the default TZ of GMT
             is used -->
    <fmt:setTimeZone value='<%= null %>'/>
    <fmt:formatDate type="both" dateStyle="full" timeStyle="full" value="${dte}"/>

    <fmt:setTimeZone value=""/>
    <fmt:formatDate type="both" dateStyle="full" timeStyle="full" value="${dte}"/>
   
</tck:test>
