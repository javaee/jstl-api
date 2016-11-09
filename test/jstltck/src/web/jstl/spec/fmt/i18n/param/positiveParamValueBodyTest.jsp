<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveParamValueBodyTest">
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources">

        <!-- The value of the param can be specified as body content -->
        <fmt:message key="pkey">
            <fmt:param>
                value1
            </fmt:param>
            <fmt:param>value2</fmt:param>
        </fmt:message>
    </fmt:bundle>
</tck:test>
