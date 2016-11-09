<%--
   Copyright 2003 Sun Microsystems, Inc.  All rights reserved.
   SUN PROPRIETARY/CONFIDENTIAL.  Use is subject license terms.
--%>

<%@ page contentType="text/plain" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- Validate that the xml attribute is still present and can be
     used in JSTL 1.1 based tag libraries. --%>

<%
    String xml = "<root>Test PASSED</root>";
    pageContext.setAttribute("xml", xml);
%>

<x:parse var="doc" xml="${xml}"/>
<x:out select="$doc//root"/>
