<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeOutBodyContentExcTest">
    <!-- If an action's body content causes an exception, it should be
              propagated. -->
    <tck:catch var="ex" exception="java.lang.IllegalArgumentException">
        <c:out value="${null}">
            <tck:throwit/>
        </c:out>
    </tck:catch>
    <c:out value="${ex}" default="Test FAILED" escapeXml="false"/>
</tck:test>
