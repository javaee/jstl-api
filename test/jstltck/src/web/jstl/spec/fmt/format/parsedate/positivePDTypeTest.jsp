<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positivePDTypeTest">
    <c:set var="dte" value="Nov 21, 2000"/>
    <c:set var="dtim" value="3:45:02 AM"/>
    <c:set var="dt" value="Nov 21, 2000 3:45:02 AM"/> 
    <c:set var="tim" value="time"/>
    <c:set var="dat" value="date"/>
    <c:set var="bot" value="both"/>
    <fmt:setLocale value="en_US"/>
    <fmt:setTimeZone value="EST"/>

    <!-- the type attribute specifies the the type of date
             information is contained in the value to be parsed. -->
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dte") %>' var="r1"/>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dte") %>'
                             type='<%= (String) pageContext.getAttribute("dat") %>' var="r2"/>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dte") %>'
                             type="date" var="r3"/>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dtim") %>'
                             type='<%= (String) pageContext.getAttribute("tim") %>' var="r4"/>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dtim") %>'
                             type="time" var="r5"/>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dt") %>'
                             type='<%= (String) pageContext.getAttribute("bot") %>' var="r6"/>
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dt") %>'
                             type="both" var="r7"/>
    date: <fmt:formatDate value="${r1}" type="date"/><br>
    date: <fmt:formatDate value="${r2}" type="date"/><br>
    date: <fmt:formatDate value="${r3}" type="date"/><br>
    time: <fmt:formatDate value="${r4}" type="time"/><br>
    time: <fmt:formatDate value="${r5}" type="time"/><br>
    both: <fmt:formatDate value="${r6}" type="both"/><br>
    both: <fmt:formatDate value="${r7}" type="both"/><br>
    
</tck:test>
