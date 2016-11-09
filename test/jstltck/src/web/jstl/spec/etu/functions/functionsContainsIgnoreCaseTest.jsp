<%--
   Copyright 2003 Sun Microsystems, Inc.  All rights reserved.
   SUN PROPRIETARY/CONFIDENTIAL.  Use is subject license terms.
--%>

<%@ page contentType="text/plain" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${fn:containsIgnoreCase('some string', 'me str')}">
    Test PASSED
</c:if>

<c:if test="${fn:containsIgnoreCase('soMe StrinG', 'me Str')}">
    Test PASSED
</c:if>

<c:if test="${fn:containsIgnoreCase('S rin G', 'S RIN g')}">
    Test PASSED
</c:if>
