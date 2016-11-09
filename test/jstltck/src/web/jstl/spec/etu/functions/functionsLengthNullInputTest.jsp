<%--
   Copyright 2003 Sun Microsystems, Inc.  All rights reserved.
   SUN PROPRIETARY/CONFIDENTIAL.  Use is subject license terms.
--%>

<%@ page contentType="text/plain" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String str = null;
    pageContext.setAttribute("nullString", str);
%>
<c:choose>
    <c:when test="${0 == fn:length(nullString)}">
        Test PASSED
    </c:when>
    <c:otherwise>
        Test FAILED.  Expected fn:length(null) to return a length of 0.
        Received: ${fn:length(nullString)}
    </c:otherwise>
</c:choose>
