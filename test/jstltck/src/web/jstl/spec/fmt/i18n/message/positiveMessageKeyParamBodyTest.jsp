<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveMessageKeyParamBodyTest">
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources">

        <!-- Validate the action can use the key specified in the body
                 with param subtags included -->
        <fmt:message>
            pkey
            <fmt:param value="value1"/>
            <fmt:param value="value2"/>
        </fmt:message>
    </fmt:bundle>
</tck:test>
