<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveMessageParamBodyTest">
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources">
        <!-- Validate the body can perform parametric replacement
             if param subtags are present and key is compound -->
        <fmt:message key="pkey">
            <fmt:param value="value1"/>
            <fmt:param value="value2"/>
        </fmt:message>
    </fmt:bundle>
</tck:test>
