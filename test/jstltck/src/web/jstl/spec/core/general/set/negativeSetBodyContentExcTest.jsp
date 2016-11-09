<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeSetBodyContentExcTest">
    <!-- Validate that if the body of the set action throws
             an exception it is properly propagated. -->
    <tck:catch var="rex" exception="java.lang.IllegalArgumentException">
        <c:set var="test">
            <tck:throwit/>
        </c:set>
    </tck:catch>
    <c:out value="${rex}" default="Test FAILED" escapeXml="false"/>
</tck:test>
