<%--
   Copyright 2003 Sun Microsystems, Inc.  All rights reserved.
   SUN PROPRIETARY/CONFIDENTIAL.  Use is subject license terms.
--%>

<%@ page contentType="text/plain" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${'stnirg' == fn:replace('stnirg', null, 'rin')}">
        Test PASSED
    </c:when>
    <c:otherwise>
        Test FAILED.  Expected fn:replace('stnirg', null, 'rin') to
        return 'stnirg'.  Received: '${fn:replace('stnirg', null, 'b')}'
    </c:otherwise>
</c:choose>
