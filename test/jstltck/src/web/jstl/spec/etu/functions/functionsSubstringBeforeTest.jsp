<%--
   Copyright 2003 Sun Microsystems, Inc.  All rights reserved.
   SUN PROPRIETARY/CONFIDENTIAL.  Use is subject license terms.
--%>

<%@ page contentType="text/plain" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${'sub' == fn:substringBefore('substring', 'string')}">
        Test PASSED
    </c:when>
    <c:otherwise>
        Test FAILED.  Expected fn:substringBefore('substring', 'string') to return
        'sub'.  Actual return value: ${fn:substringBefore('substring', 'sub')}
    </c:otherwise>
</c:choose>

<c:choose>
    <c:when test="${'' == fn:substringBefore('substring', 'String')}">
        Test PASSED
    </c:when>
    <c:otherwise>
        Test FAILED.  Expected fn:substringBefore('substring', 'String') to return
        ''.  Actual return value: ${fn:substringBefore('substring', 'String')}
    </c:otherwise>
</c:choose>
