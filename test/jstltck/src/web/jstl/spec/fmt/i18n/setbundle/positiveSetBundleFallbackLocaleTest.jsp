<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Locale" %>
<tck:test testName="positiveSetBundleFallbackLocaleTest">

    <!-- If unable to find the locale configuration variable and
             no match can be made based on the client's locale, the
             fallback locale will be used.  -->
    fallbackLocale configuration variable as a String:<br>
    <tck:config op="set" configVar="fallback" value="en-US"/>
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"/>
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                   var="reBundle"/>
    <tck:config op="get" var="reConfig" configVar="localectx"/>
    Locale configuration variable type:<br>
    <c:set var="rrb1" value="${reBundle.resourceBundle}"/>
    <tck:isInstance varName="rrb1" type="com.sun.ts.tests.jstl.common.resources.Resources_en"/>
    <br>
    Exported LocalizationContext ResourceBundle type:<br>
    <c:set var="rrb2" value="${reConfig.resourceBundle}"/>
    <tck:isInstance varName="rrb2" type="com.sun.ts.tests.jstl.common.resources.Resources_en"/>
    <br>
    <br>
    fallbackLocale configuration variable as an instance of Locale:<br>
    <tck:config op="set" configVar="fallback" value='<%= new Locale("en", "US") %>'/>
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"/>
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                   var="rrBundle"/>
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"/>
    <tck:config op="get" var="rrConfig" configVar="localectx"/>
    Locale configuration variable type:<br>
    <c:set var="rb1r" value="${rrBundle.resourceBundle}"/>
    <tck:isInstance varName="rb1r" type="com.sun.ts.tests.jstl.common.resources.Resources_en"/>
    <br>
    Exported LocalizationContext ResourceBundle type:<br>
    <c:set var="rb2r" value="${rrConfig.resourceBundle}"/>
    <tck:isInstance varName="rb2r" type="com.sun.ts.tests.jstl.common.resources.Resources_en"/>
</tck:test>
