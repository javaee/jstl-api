<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveItemsCommaSepStringTest">
    <%
        String comSep = "1,2,3,4";
    %>

    <!-- check iteration over a comma-sepatated string -->
    <c:forEach var="rVar" items='<%= comSep %>'>
        <c:out value="${rVar}" default="forEach Test FAILED"/>
    </c:forEach>

    <!-- Static: check iteration over a static string -->
    <c:forEach var="seVar" items="1,2,3,4">
        <c:out value="${seVar}" default="forEach Test FAILED"/>
    </c:forEach>

</tck:test>
