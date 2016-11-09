<%--
   Copyright 2003 Sun Microsystems, Inc.  All rights reserved.
   SUN PROPRIETARY/CONFIDENTIAL.  Use is subject license terms.
--%>

<%@ page contentType="text/plain" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${'UPPER' == fn:toUpperCase('uPpEr')}">
        Test PASSED
    </c:when>
    <c:otherwise>
        Test FAILED.  Expected the result of fn:toLowerCase('uPpEr') to be
        'UPPER'.  Actual result received: ${fn:toLowerCase('uPpEr')}
    </c:otherwise>
</c:choose>
