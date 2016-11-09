<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveItemsStepTest">
    <%
        int[] iArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int iStep = 2;
    %>

    <!-- support of 'step' attribute with items - step = 2 : dynamic -->
    <c:forEach var="eVar" items='<%= iArray %>' step='<%= iStep %>'>
        <c:out value="${eVar}" default="forEach Test FAILED"/>
    </c:forEach>
    <!-- support of 'step' attribute with items - step = 2 : static -->
    <c:forEach var="eVar" items='<%= iArray %>' step="2">
        <c:out value="${eVar}" default="forEach Test FAILED"/>
    </c:forEach>
</tck:test>
