<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveBundleBasenameTest">
    <c:set var="bun" value="com.sun.ts.tests.jstl.common.resources.Resources"/>

    <!-- basename attribute -->
    <fmt:bundle basename='<%= (String) pageContext.getAttribute("bun") %>'>
        <fmt:message key="mkey"/>
    </fmt:bundle>
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources">
        <fmt:message key="mkey"/>
    </fmt:bundle>
</tck:test>
