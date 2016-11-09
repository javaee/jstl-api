<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Date" %>
<tck:test testName="positiveFormatLocalizationContextBundleTest">
    <%  
        Date date = new Date(883192294202L);
        pageContext.setAttribute("dte", date);
    %>
    <fmt:setTimeZone value="EST"/>
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.AlgoResources6"/>
    <c:set var="dt" value="Nov 21, 2000 3:45:02 AM"/>

    <!-- The localization context for formatting actions can
             be provided by wrapping these actions in a fmt:bundle
             action.  The Locale of the selected resource bundle
             will be used as the locale for the formatting action.
             Additionally, if the action is wrapped by the bundle action
             the javax.servlet.jsp.jstl.fmt.localizationContext config variable
             will not be considered. -->
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources1">
        <fmt:parseDate value='<%= (String) pageContext.getAttribute("dt") %>' type="both" var="p2"/>
        <fmt:formatDate value='<%= (Date) pageContext.getAttribute("p2") %>' type="both"/>
        <fmt:parseNumber value="1,234"/>
        <fmt:formatNumber value="1234"/>
    </fmt:bundle>
</tck:test>
