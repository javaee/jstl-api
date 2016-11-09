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
    <c:when test="${'one|-|two|-|three' == fn:join(strArray, '|-|')}">
        Test PASSED
    </c:when>
    <c:otherwise>
        Test FAILED.  Expected fn:join(strArray, '|-|') to return
        "one|-|two|-|three".  Received: '${fn:join(strArray, '|-|')}'
    </c:otherwise>
</c:choose>
