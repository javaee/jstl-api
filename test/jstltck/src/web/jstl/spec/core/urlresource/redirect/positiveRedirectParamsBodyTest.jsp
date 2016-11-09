<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page session="false" %>
<tck:test testName="positiveRedirectParamsBodyTest">

    <!-- Validate redirect can handle param subtags -->
    <c:if test="${param.rt1 != null}">
        <c:redirect url="/urlresource/param/import.jsp">
            <c:param name="testparm" value="testval"/>
        </c:redirect>
    </c:if>
    <!-- Validate redirect with context specified can handle param subtags -->
    <c:if test="${param.rt2 != null}">
        <c:redirect context="/jstl_core_web" url="/urlresource/param/import.jsp">
            <c:param name="testparm" value="testval"/>
        </c:redirect>
    </c:if>
</tck:test>
