<%--
   Copyright 2003 Sun Microsystems, Inc.  All rights reserved.
   SUN PROPRIETARY/CONFIDENTIAL.  Use is subject license terms.
--%>

<%@ page contentType="text/plain" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${fn:contains('some string', 'me str')}">
    Test PASSED
</c:if>

<c:if test="${fn:contains('soMe StrinG', 'me Str')}">
    Test FAILED -- fn:contains('soMe StrinG', 'me Str')
</c:if>

<c:if test="${fn:contains(' string', '  stri')}">
    Test FAILED -- fn:contains(' string', '  stri')
</c:if>
