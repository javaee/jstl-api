<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<c:if test="${param.testparm != null}">
    <c:out value="testparm found! Value is: ${param.testparm}" default="Test FAILED"/>
</c:if>
<c:if test="${param.testparm2 != null}">
    <c:out value="testparm2 found! Value is: ${param.testparm2}" default="Test FAILED"/>
</c:if>

