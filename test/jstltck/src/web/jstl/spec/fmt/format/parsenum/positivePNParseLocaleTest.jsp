<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Locale" %>
<tck:test testName="positivePNParseLocaleTest">
    <% 
        pageContext.setAttribute("loc", new Locale("en","US"));
    %>
    <c:set var="us" value="en_US"/>
    <fmt:setLocale value="fr_FR"/>

    <!-- Validate the behavior of the parseNumber action when using
             the parseLocale attribute.  Pass in both String and Locale 
             objects. This will also validate that the presence of the
             parseLocale attribute will override that of the page. -->
    Number: <fmt:parseNumber value="1,234" parseLocale='<%= (String) pageContext.getAttribute("us") %>'/>
    Number: <fmt:parseNumber value="1,234" parseLocale='<%= (Locale) pageContext.getAttribute("loc") %>' type="number"/>
    Currency: <fmt:parseNumber value="$1,234.00" parseLocale="en_US" type="currency"/>
    Percent: <fmt:parseNumber value="1.5%" parseLocale="en_US" type="percent"/>
</tck:test>
