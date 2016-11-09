<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeCWOOtherwiseExcBodyContentTest">
    <!-- Validate an exception caused by the body content of the otherwise
             action is propagated to the choose action which in turn
             propagates the exception. -->
    <tck:catch var="ex" exception="java.lang.IllegalArgumentException">
        <c:choose>
            <c:when test="${false}">
                Test FAILED<br>
            </c:when>
            <c:otherwise>
                <tck:throwit/>
            </c:otherwise>
        </c:choose>
    </tck:catch>
    <c:out value="${ex}" default="Test FAILED" escapeXml="false"/>

</tck:test>
