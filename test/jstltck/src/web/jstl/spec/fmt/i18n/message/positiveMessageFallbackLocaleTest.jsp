<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Locale" %>
<tck:test testName="positiveMessageFallbackLocaleTest">

    <!-- If the message action is not nested within a bundle action
             it will levarage the default localization context.  In this
             case, setBundle is unable to find the locale configuration variable,
             so it should use the fallback locale to create the localization context. -->
    fallbackLocale configuration variable as a String:<br>
    <tck:config op="set" configVar="fallback" value="en-US"/>
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"/>
    <fmt:message key="mkey"/><br>
    <br>
    fallbackLocale configuration variable as an instance of Locale:<br>
    <tck:config op="set" configVar="fallback" value='<%= new Locale("en", "US") %>'/>
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"/>
    <fmt:message key="mkey"/><br>
</tck:test>
