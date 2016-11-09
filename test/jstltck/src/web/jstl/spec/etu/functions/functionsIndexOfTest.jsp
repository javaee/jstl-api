<%--
   Copyright 2003 Sun Microsystems, Inc.  All rights reserved.
   SUN PROPRIETARY/CONFIDENTIAL.  Use is subject license terms.
--%>

<%@ page contentType="text/plain" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${3 == fn:indexOf('string', 'ing')}">
        Test PASSED
    </c:when>
    <c:otherwise>
        Test FAILED.  Expected fn:indexOf('string', 'ing') to return
        3.  Actual value: ${fn:indexOf('string', 'ing')}
    </c:otherwise>
</c:choose>

<c:choose>
    <c:when test="${-1 == fn:indexOf('string', 'InG')}">
        Test PASSED
    </c:when>
    <c:otherwise>
        Test FAILED.  Expected fn:indexOf('string', 'InG') to return
        -1.  Actual value: ${fn:indexOf('string', 'ing')}
    </c:otherwise>
</c:choose>
