<%--
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveMessageKeyTest">
    <c:set var="eKey" value="mkey"/>

    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources">

        <!-- Behavioral test for key attribute -->
        <fmt:message key='<%= (String) pageContext.getAttribute("eKey") %>'/>
        <fmt:message key="mkey"/>
    </fmt:bundle>
</tck:test>
