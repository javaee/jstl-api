<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveSetBundleLocaleConfigurationTest">
    <fmt:setLocale value="en_US"/>

    <!-- The setBundle action will use the locale as specified
             by the javax.servlet.jsp.jstl.fmt.locale configuration
             variable if present.  This will override any browser based
             locales provided. -->
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"/>
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                   var="rBundle"/>
    <tck:config op="get" var="rConfig" configVar="localectx"/>
    Locale configuration variable type:<br>
    <c:set var="rb1" value="${rBundle.resourceBundle}"/>
    <tck:isInstance varName="rb1" type="com.sun.ts.tests.jstl.common.resources.Resources_en"/>
    <br>
    Exported LocalizationContext ResourceBundle type:<br>
    <c:set var="rb2" value="${rConfig.resourceBundle}"/>
    <tck:isInstance varName="rb2" type="com.sun.ts.tests.jstl.common.resources.Resources_en"/>
    
</tck:test>
