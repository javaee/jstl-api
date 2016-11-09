<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveOutValueAttributeTest">
    <% 
       pageContext.setAttribute("pageObj", "pageObj");
    %>
    <c:out value="${pageObj}"/><br>
    <c:out value="static"/><br>
</tck:test>
