<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveMessageScopeTest">
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources">

        <!-- Validate the export of the message to different scopes, both
             implicit and explicit -->
        <fmt:message key="mkey" var="riPage"/>
        <fmt:message key="mkey" var="rePage" scope="page"/>
        <fmt:message key="mkey" var="reRequest" scope="request"/>
        <fmt:message key="mkey" var="reSession" scope="session"/>
        <fmt:message key="mkey" var="reApplication" scope="application"/>
     </fmt:bundle>

     <tck:checkScope varName="riPage"/>
     <tck:checkScope varName="rePage"/>
     <tck:checkScope varName="reRequest" inScope="request"/>
     <tck:checkScope varName="reSession" inScope="session"/>
     <tck:checkScope varName="reApplication" inScope="application"/>
</tck:test>
