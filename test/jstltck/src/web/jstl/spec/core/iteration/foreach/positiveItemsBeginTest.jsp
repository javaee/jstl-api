<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveItemsBeginTest">
    <%
        int[] iArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int iBegin = 5;
    %>

    <!-- support of 'begin' with items - begin = 5 : dynamic -->
    <c:forEach var="eVar" items='<%= iArray %>' begin='<%= iBegin %>'>
        <c:out value="${eVar}" default="forEach Test FAILED"/>
    </c:forEach>
    <!-- support of 'begin' with items - begin = 5 : static-->
    <c:forEach var="eVar" items='<%= iArray %>' begin="5">
        <c:out value="${eVar}" default="forEach Test FAILED"/>
    </c:forEach>

</tck:test>
