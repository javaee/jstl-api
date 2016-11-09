<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveEndTest">
    <%
        String tString = "0|1|2|3|4|5|6|7|8|9";
        int iEnd = 3;
    %>

    <!-- support of 'end' with items - end = 3 : dynamic -->
    <c:forTokens var="eVar" items='<%= tString %>' delims="|" end='<%= iEnd %>'>
        <c:out value="${eVar}" default="forEach Test FAILED"/>
    </c:forTokens>
    <!-- support of 'end' with items - end = 3 : static-->
    <c:forTokens var="eVar" items='<%= tString %>' delims="|" end="3">
        <c:out value="${eVar}" default="forEach Test FAILED"/>
    </c:forTokens>

</tck:test>
