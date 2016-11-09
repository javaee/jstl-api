<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveLoopTagStatusTest">
    <%
        String[] sArray = { "one", "two", "three" };
        pageContext.setAttribute("sArray", sArray);
    %>
    <c:forEach varStatus="status" items="${sArray}"
               begin="0" end="2" step="1">
        <c:out value="${status.current}" default="forEach Test FAILED"/><br>
        <c:out value="${status.index}" default="forEach Test FAILED"/><br>
        <c:out value="${status.count}" default="forEach Test FAILED"/><br>
        <c:out value="${status.first}" default="forEach Test FAILED"/><br>
        <c:out value="${status.last}" default="forEach Test FAILED"/><br>
        <c:out value="${status.begin}" default="forEach Test FAILED"/><br>
        <c:out value="${status.end}" default="forEach Test FAILED"/><br>
        <c:out value="${status.step}" default="forEach Test FAILED"/><br>
    </c:forEach>

    <!-- Validate results when 'begin', 'end', and/or 'step' is not specified -->
    <c:forEach varStatus="status" items="1">
        <c:if test="${status.begin == null}">
            Begin not specified
        </c:if>
        <c:if test="${status.end == null}">
            End not specified
        </c:if>
        <c:if test="${status.step == null}">
            Step not specified
        </c:if>
    </c:forEach>

</tck:test>

