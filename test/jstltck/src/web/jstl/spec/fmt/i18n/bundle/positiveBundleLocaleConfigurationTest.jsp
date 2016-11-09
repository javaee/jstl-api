<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveBundleLocaleConfigurationTest">
    <fmt:setLocale value="en_US"/>

    <!-- If the javax.servlet.jsp.jstl.fmt.locale configuration variable
             is set, the browser locales are ignored and it is used
             to localize a message. -->
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources">
        <fmt:message key="mkey"/>
    </fmt:bundle>
</tck:test>
