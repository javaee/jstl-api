<%--
   Copyright 2003 Sun Microsystems, Inc.  All rights reserved.
   SUN PROPRIETARY/CONFIDENTIAL.  Use is subject license terms.
--%>

<%@ page contentType="text/plain" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${fn:containsIgnoreCase('StRing', 'strInG')}">
        Test PASSED
    </c:when>
    <c:otherwise>
        Test FAILED.  The containsIgnoreCase function did not return TRUE
        when the 'string' and 'substring' arguments were equal.
    </c:otherwise>
</c:choose>
