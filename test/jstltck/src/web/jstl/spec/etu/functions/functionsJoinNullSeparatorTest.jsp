<%--
   Copyright 2003 Sun Microsystems, Inc.  All rights reserved.
   SUN PROPRIETARY/CONFIDENTIAL.  Use is subject license terms.
--%>

<%@ page contentType="text/plain" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String[] strArray = { "one", "two", "three" };
    pageContext.setAttribute("strArray", strArray);
%>

<c:choose>
    <c:when test="${'onetwothree' == fn:join(strArray, null)}">
        Test PASSED
    </c:when>
    <c:otherwise>
        Test FAILED.  Expected fn:join(strArray, null) to return 'onetwothree'.
        Received: '${fn:join(strArray, null)}'
    </c:otherwise>
</c:choose>
