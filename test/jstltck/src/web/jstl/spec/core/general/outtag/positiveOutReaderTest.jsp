<%--
   Copyright 2003 Sun Microsystems, Inc.  All rights reserved.
   SUN PROPRIETARY/CONFIDENTIAL.  Use is subject license terms.
--%>

<%@ page contentType="text/plain" %>
<%@ page import="java.io.StringReader"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    StringReader reader = new StringReader("Test PASSED");
    pageContext.setAttribute("reader", reader);
%>

<c:out value="${reader}" default="Test FAILED" />

