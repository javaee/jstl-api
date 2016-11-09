<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positivePDTimeZoneNullEmpytTest">
    <c:set var="dt" value="Nov 21, 2000 3:45 AM"/> 
    <fmt:setLocale value="en_US"/>
    <fmt:setTimeZone value="MST"/>

    <!-- If timeZone is null or empty, it will be treated as
             if it was not present (only type short times is specified
             as any other style has no impact on the result). -->
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dt") %>'
                       timeZone='<%= null %>' type="both" timeStyle="short" var="rn1"/>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dt") %>'
                       timeZone="" type="both" timeStyle="short" var="re1"/>
    <fmt:formatDate value="${rn1}" timeZone="EST" type="both" timeStyle="short"/><br>
    <fmt:formatDate value="${re1}" timeZone="EST" type="both" timeStyle="short"/><br>
</tck:test>
