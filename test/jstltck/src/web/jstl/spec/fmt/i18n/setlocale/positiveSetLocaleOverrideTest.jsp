<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveSetLocaleOverrideTest">

    <!-- Specifying the locale within the page overrides the
             preferred locales from an HTTP client -->
    <fmt:setLocale value="en_US"/>
    <c:set var="javax.servlet.jsp.jstl.fmt.fallbackLocale" value="${param.fall}"/>
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.${param.res}">
        <fmt:message key="mkey"/>
    </fmt:bundle>
</tck:test>
