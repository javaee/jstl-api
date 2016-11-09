<%--
   Copyright 2003 Sun Microsystems, Inc.  All rights reserved.
   SUN PROPRIETARY/CONFIDENTIAL.  Use is subject license terms.
--%>

<%@ page contentType="text/plain" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% pageContext.setAttribute("escString", "><&'\""); %>
<c:choose>
    <c:when test="${'&gt;&lt;&amp;&#039;&#034;' == fn:escapeXml(escString)}">
        Test PASSED
    </c:when>
    <c:otherwise>
        Test FAILED.  Expected the return value of escapeXml(String) to be
        '&gt;&lt;&amp;&#039;&#034;'.  Actual value was: ${fn:escapeXml(escString)}
    </c:otherwise>
</c:choose>
