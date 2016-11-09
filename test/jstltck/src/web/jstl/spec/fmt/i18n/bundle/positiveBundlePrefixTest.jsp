<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveBundlePrefixTest">
    <c:set var="pre" value="m"/>

    <!-- prefix attribute -->
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                   prefix='<%= (String) pageContext.getAttribute("pre") %>'>
        <fmt:message key="key"/>
    </fmt:bundle>
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                   prefix="m">
        <fmt:message key="key"/>
    </fmt:bundle>
</tck:test>
