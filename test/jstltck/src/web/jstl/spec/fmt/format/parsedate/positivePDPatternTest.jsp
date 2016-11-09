<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tck:test testName="positivePDPatternTest">
    <c:set var="pat" value="yyyy.MM.dd G 'at' HH:mm:ss z"/>
    <c:set var="dte" value="2000.11.21 AD at 03:45:02 EST"/>
    <fmt:setLocale value="en_US"/>
    <fmt:setTimeZone value="EST"/>

    <!-- the pattern attribute specifies a custom pattern
             to be applied when parsing the provided date. -->
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dte") %>'
                       pattern='<%= (String) pageContext.getAttribute("pat") %>' var="r1"/>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dte") %>'
                       pattern="yyyy.MM.dd G 'at' HH:mm:ss z" var="r2"/>
    <fmt:formatDate value="${r1}" timeZone="EST" pattern="${pat}"/><br>
    <fmt:formatDate value="${r2}" timeZone="EST" pattern="${pat}"/><br>
</tck:test>
