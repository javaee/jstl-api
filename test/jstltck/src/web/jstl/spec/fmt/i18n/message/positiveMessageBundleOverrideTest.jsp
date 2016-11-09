<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.servlet.jsp.jstl.fmt.LocalizationContext" %>
<tck:test testName="positiveMessageBundleOverrideTest">
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                 var="tBundle"/>
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.AlgoResources2">
        <!--  If the bundle attribute is specified, it will be used for
                  for the key lookups as opposed to the parent bundle action -->
        <fmt:message key="pkey" bundle='<%= (LocalizationContext) pageContext.getAttribute("tBundle") %>'>
            <fmt:param value="value1"/>
            <fmt:param value="value2"/>
        </fmt:message>
    </fmt:bundle>
</tck:test>
