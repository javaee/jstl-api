<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveBeginTest">
    <%
        String tString = "0|1|2|3|4|5|6|7|8|9";
        pageContext.setAttribute("str", tString);
        int iBegin = 5;
    %>

    <!-- support of 'begin' with items - begin = 5 : dynamic -->
    <c:forTokens var="eVar" items='<%= tString %>' delims="|" begin='<%= iBegin %>'>
        <c:out value="${eVar}" default="forEach Test FAILED"/>
    </c:forTokens>
    <!-- support of 'begin' with items - begin = 5 : static-->
    <c:forTokens var="eVar" items='<%= tString %>' delims="|" begin="5">
        <c:out value="${eVar}" default="forEach Test FAILED"/>
    </c:forTokens>

</tck:test>
