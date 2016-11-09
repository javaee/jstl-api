<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveParamValueTest">
    <c:set var="val1" value="value1"/>
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources">

        <!-- Behvioral test for value -->
        <fmt:message key="pkey">
            <fmt:param value='<%= (String) pageContext.getAttribute("val1") %>'/>
            <fmt:param value="value2"/>
        </fmt:message>
    </fmt:bundle>
</tck:test>
