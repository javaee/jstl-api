<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.servlet.jsp.jstl.fmt.LocalizationContext" %>
<tck:test testName="positiveFormatBundleVarTest">

    <!-- If var is specified, the LocalizationContext is exported
             to the pageContext and is of type javax.servlet.jsp.jstl.fmt.LocalizationContext. -->
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                   var="rbundle"/>
    <tck:isInstance varName="rbundle" type="javax.servlet.jsp.jstl.fmt.LocalizationContext"/>
    <fmt:message key="mkey" bundle="${rbundle}"/>
</tck:test>
