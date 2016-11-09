<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.servlet.jsp.jstl.fmt.LocalizationContext" %>
<tck:test testName="positiveBundleMessageTest">
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                var="tBundle"/>

    <!-- Bundle attribute -->
    <fmt:message key="mkey" bundle='<%= (LocalizationContext) pageContext.getAttribute("tBundle") %>'/>
</tck:test>
