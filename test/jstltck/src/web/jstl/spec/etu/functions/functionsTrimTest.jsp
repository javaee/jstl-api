<%--
   Copyright 2003 Sun Microsystems, Inc.  All rights reserved.
   SUN PROPRIETARY/CONFIDENTIAL.  Use is subject license terms.
--%>

<%@ page contentType="text/plain" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String str = "  \t  trimmed string  \n";
    pageContext.setAttribute("str", str);
%>
<c:choose>
    <c:when test="${'trimmed string' == fn:trim(str)}">
        Test PASSED
    </c:when>
    <c:otherwise>
        Test FAILED.  Expected fn:trim('  \t  trimmed string  \n') to return
        'trimmed string'.  Actual result: '${fn:trim(str)}'
    </c:otherwise>
</c:choose>
