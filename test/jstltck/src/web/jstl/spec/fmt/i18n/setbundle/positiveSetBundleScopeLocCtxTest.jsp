<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveSetBundleScopeLocCtxTest">

    <!-- If var is not specified, but scope is, scope will dictate
             which scope the confuration variable 
             javax.servlet.jsp.jstl.fmt.LocalizationContext will be exported
             to. If scope is not specifed, then the configuration variable
             is exported to the page scope by default. -->
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"/>
    <tck:checkScope varName="javax.servlet.jsp.jstl.fmt.localizationContext"
                    useConfig="true"/>
    <tck:config op="remove" configVar="localectx"/>
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                   scope="page"/>
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                   scope="request"/>
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                   scope="session"/>
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                   scope="application"/>
    <tck:checkScope varName="javax.servlet.jsp.jstl.fmt.localizationContext" 
                    inScope="page" useConfig="true"/>
    <tck:checkScope varName="javax.servlet.jsp.jstl.fmt.localizationContext" 
                    inScope="request" useConfig="true"/>
    <tck:checkScope varName="javax.servlet.jsp.jstl.fmt.localizationContext" 
                    inScope="session" useConfig="true"/>
    <tck:checkScope varName="javax.servlet.jsp.jstl.fmt.localizationContext" 
                    inScope="application" useConfig="true"/>
    <tck:config op="remove" configVar="localectx" scope="application"/>
</tck:test>
