<%--
   Copyright 2003 Sun Microsystems, Inc.  All rights reserved.
   SUN PROPRIETARY/CONFIDENTIAL.  Use is subject license terms.
--%>

<%@ page contentType="text/plain" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${'string' == fn:substringAfter('substring', 'sub')}">
        Test PASSED
    </c:when>
    <c:otherwise>
        Test FAILED.  Expected fn:substringAfter('substring', 'sub') to return
        'string'.  Actual return value: ${fn:substringAfter('substring', 'sub')}
    </c:otherwise>
</c:choose>

<c:choose>
    <c:when test="${'' == fn:substringAfter('substring', 'Sub')}">
        Test PASSED
    </c:when>
    <c:otherwise>
        Test FAILED.  Expected fn:substringAfter('substring', 'Sub') to return
        ''.  Actual return value: ${fn:substringAfter('substring', 'Sub')}
    </c:otherwise>
</c:choose>
