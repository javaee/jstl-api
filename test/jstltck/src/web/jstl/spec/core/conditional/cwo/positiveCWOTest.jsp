<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveCWOTest">

    <!-- Simple validation that when's body content is processed
         if the test evaluates to true -->
    <c:choose>
        <c:when test="<%= true %>">
            PASSED<br>
        </c:when>
    </c:choose>

    <!-- Validate that the first when that evaluates to true processes
         its body content -->
    <c:choose>
        <c:when test="<%= false %>">
            FAILED<br>
        </c:when>
        <c:when test="<%= true %>">
            PASSED<br>
        </c:when>
        <c:when test="<%= true %>">
            FAILED<br>
        </c:when>
    </c:choose>

    <!-- Validate otherwise is processed if no when case evaluates to true -->
    <c:choose>
        <c:when test="<%= false %>">
            FAILED<br>
        </c:when>
        <c:when test="<%= false %>">
            FAILED<br>
        </c:when>
        <c:otherwise>
            PASSED<br>
        </c:otherwise>
    </c:choose>
</tck:test>
