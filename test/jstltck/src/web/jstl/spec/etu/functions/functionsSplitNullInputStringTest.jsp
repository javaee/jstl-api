<%--
   Copyright 2003 Sun Microsystems, Inc.  All rights reserved.
   SUN PROPRIETARY/CONFIDENTIAL.  Use is subject license terms.
--%>

<%@ page contentType="text/plain" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${'' == fn:join(fn:split(null, '|'), '-')}">
        Test PASSED
    </c:when>
    <c:otherwise>
        Test FAILED.  Expected fn:join(fn:split(null, '|'), '-')
        to return ''.  Received: '${fn:join(fn:split(null, '|'), '-')}'
    </c:otherwise>
</c:choose>
