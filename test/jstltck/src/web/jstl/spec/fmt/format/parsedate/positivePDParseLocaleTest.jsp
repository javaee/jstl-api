<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Locale" %>
<tck:test testName="positivePDParseLocaleTest">
    <%
        pageContext.setAttribute("loc", new Locale("en", "US"));
    %>
    <c:set var="dte" value="Nov 21, 2000 3:45:02 AM"/>
    <c:set var="us" value="en_US"/>
    <fmt:setLocale value="de_DE"/>
    <fmt:setTimeZone value="EST"/>

    <!-- parseLocale specifies the locale specific formatting pattern
             to apply when parsing the provided value.  The presence of this
             attribute will override the page locale. Also validate that
             parseLocale attribute can accept both Strings and Locale objects. -->
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dte") %>'
                      parseLocale='<%= (String) pageContext.getAttribute("us") %>' type="both"/><br>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dte") %>'
                      parseLocale='<%= (Locale) pageContext.getAttribute("loc") %>' type="both"/><br>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dte") %>' parseLocale="en_US" type="both"/><br>
</tck:test>
