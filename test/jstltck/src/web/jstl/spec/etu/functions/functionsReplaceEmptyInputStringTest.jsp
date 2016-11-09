<%--
   Copyright 2003 Sun Microsystems, Inc.  All rights reserved.
   SUN PROPRIETARY/CONFIDENTIAL.  Use is subject license terms.
--%>

<%@ page contentType="text/plain" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${'' == fn:replace('', 'a', 'b')}">
        Test PASSED
    </c:when>
    <c:otherwise>
        Test FAILED.  Expected fn:replace('', 'a', 'b') to
        return ''.  Received: '${fn:replace('', 'a', 'b')}'
    </c:otherwise>
</c:choose>
