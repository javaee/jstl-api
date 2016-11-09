<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positivePDParseLocaleNullEmptyTest">
    <fmt:setLocale value="en-US"/>
    <fmt:setTimeZone value="EST"/>

    <!-- if parseLocale is null or empty, it is treated as if
             not specified. The locale configuration variable should be used.-->
    <fmt:parseDate value="Nov 21, 2000" parseLocale='<%= null %>' var="r1"/>
    <fmt:parseDate value="Nov 21, 2000" parseLocale="" var="r2"/>
    <fmt:formatDate value="${r1}" timeZone="EST"/><br>
    <fmt:formatDate value="${r2}" timeZone="EST"/><br>

</tck:test>
