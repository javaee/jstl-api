<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveStepTest">
    <%
        String tString = "0|1|2|3|4|5|6|7|8|9";
        int iStep = 2;
    %>

    <!-- support of 'step' with items - step = 2 : dynamic -->
    <c:forTokens var="eVar" items='<%= tString %>' delims="|" step='<%= iStep %>'>
        <c:out value="${eVar}" default="forEach Test FAILED"/>
    </c:forTokens>
    <!-- support of 'step' with items - step = 2 : static-->
    <c:forTokens var="eVar" items='<%= tString %>' delims="|" step="2">
        <c:out value="${eVar}" default="forEach Test FAILED"/>
    </c:forTokens>

</tck:test>
