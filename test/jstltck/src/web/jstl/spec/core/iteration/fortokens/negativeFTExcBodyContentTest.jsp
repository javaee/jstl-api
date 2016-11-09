<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeFTExcBodyContentTest">

    <!-- An exception caused by the body content, should be propagated -->
    <tck:catch var="ex" exception="java.lang.IllegalArgumentException">
        <c:forTokens items="1,2" delims=",">
            <tck:throwit/>
        </c:forTokens>
    </tck:catch>
    <c:out value="${ex}" default="Test FAILED" escapeXml="false"/>
</tck:test>
