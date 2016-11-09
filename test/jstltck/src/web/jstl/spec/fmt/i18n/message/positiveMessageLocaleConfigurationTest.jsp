<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveMessageLocaleConfigurationVariableTest">
    <fmt:setLocale value="en_US"/>
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"/>

    <!-- If the javax.servlet.jsp.jstl.fmt.locale configuration variable
             then the setBundle action should select the appropriate bundle
             and export the javax.servlet.jsp.jstl.fmt.localizationContext
             config variable.  -->
    <fmt:message key="mkey"/>
</tck:test>
