<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeIfExcBodyContentTest">
    <!-- Validate exceptions caused by the body content are propagated. -->
    <tck:catch var="rex" exception="java.lang.IllegalArgumentException">
        <c:if test='<%= true %>'>
            <tck:throwit/>
        </c:if>
    </tck:catch>
    <c:out value="${rex}" default="Test FAILED" escapeXml="false"/>
</tck:test>
