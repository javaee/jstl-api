<%--
   Copyright 2003 Sun Microsystems, Inc.  All rights reserved.
   SUN PROPRIETARY/CONFIDENTIAL.  Use is subject license terms.
--%>

<%@ page contentType="text/plain" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${fn:contains(null, 'sub')}">
        Test FAILED.  Expected contains(null, 'sub') to return FALSE.
    </c:when>
    <c:otherwise>
        Test PASSED
    </c:otherwise>
</c:choose>
