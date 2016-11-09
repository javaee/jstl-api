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
    <c:when test="${'' == fn:escapeXml(nullString)}">
        Test PASSED
    </c:when>
    <c:otherwise>
        Test FAILED.  Expected escapeXml(String) to return an empty string
        when provided a null value.  The actual value returned: ${fn:escapeXml(nullString)}
    </c:otherwise>
</c:choose>
