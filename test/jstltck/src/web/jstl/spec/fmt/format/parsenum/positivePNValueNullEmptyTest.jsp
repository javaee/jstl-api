<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positivePNValueNullEmptyTest">
    <fmt:setLocale value="en_US"/>

    <!-- If value is null or empty the scoped variable defined
         by var and scope is removed. -->
    <c:set var="svar" value="value" scope="session"/>
    <fmt:parseNumber var="svar" value='<%= null %>' scope="session"/>
    <tck:checkScope varName="svar" inScope="session"/>
    
    <c:set var="svar" value="value" scope="application"/>
    <fmt:parseNumber var="svar" value="" scope="application"/>
    <tck:checkScope varName="svar" inScope="application"/>
</tck:test>
