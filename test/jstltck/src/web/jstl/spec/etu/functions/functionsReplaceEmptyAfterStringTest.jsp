<%--
   Copyright 2003 Sun Microsystems, Inc.  All rights reserved.
   SUN PROPRIETARY/CONFIDENTIAL.  Use is subject license terms.
--%>

<%@ page contentType="text/plain" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${'stg' == fn:replace('stnirg', 'nir', '')}">
        Test PASSED
    </c:when>
    <c:otherwise>
        Test FAILED.  Expected fn:replace('stnirg', 'nir', '') to
        return 'stg'.  Received: '${fn:replace('stnirg', 'nir', '')}'
    </c:otherwise>
</c:choose>
