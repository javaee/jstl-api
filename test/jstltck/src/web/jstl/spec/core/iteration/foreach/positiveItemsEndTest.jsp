<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveItemsEndTest">
    <%
        int[] iArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int iEnd = 3;
    %>

    <!-- support of 'end' with items - end = 3 : dynamic -->
    <c:forEach var="eVar" items='<%= iArray %>' end="3">
        <c:out value="${eVar}" default="forEach Test FAILED"/>
    </c:forEach>
    <!-- support of 'end' with items - end = 3 : static -->
    <c:forEach var="eVar" items='<%= iArray %>' end='<%= iEnd %>'>
        <c:out value="${eVar}" default="forEach Test FAILED"/>
    </c:forEach>

</tck:test>
