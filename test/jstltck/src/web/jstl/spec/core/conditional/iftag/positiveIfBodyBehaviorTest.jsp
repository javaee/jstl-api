<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveIfBodyBehaviorTest">

    <% 
        pageContext.setAttribute("bTrue", new Boolean("true"));
        pageContext.setAttribute("bFalse", new Boolean("false"));
    %>
    <%-- body content with no var attribute --%>
    <c:if test="${bTrue}">
        PASSED<br>
    </c:if>
    <c:if test="${bFalse}">
        FAILED<br>
    </c:if>
    
    <%-- body content with the var attribute --%>
    <c:if test="${bTrue}" var="var0">
        PASSED<br>
    </c:if>
    <c:if test="${bFalse}" var="var1">
        FAILED<br>
    </c:if>
    <c:out value="${var0}" default="If Test FAILED"/><br>
    <c:out value="${var1}" default="If Test PASSED"/><br>
</tck:test>
