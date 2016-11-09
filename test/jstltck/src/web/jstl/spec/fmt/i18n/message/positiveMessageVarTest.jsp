<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveMessageVarTest">
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources">
        <!-- validate the action properly associates the message with the
             variable name defined by var -->
        <fmt:message key="mkey" var="rmess"/>
        <c:out value="${rmess}" default="Test FAILED"/>
    </fmt:bundle>
</tck:test>
