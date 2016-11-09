<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveMessagePrefixTest">
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                prefix="m">

        <!-- Validate the message action properly handles the prefix
                 of the enclosing bundle tag -->
        <fmt:message key="key"/>
    </fmt:bundle>
</tck:test>
