<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positivePDVarTest">
    <c:set var="dte" value="Nov 21, 2000 3:45:02 AM"/>
    <fmt:setLocale value="en_US"/>

    <!-- If var is specifed, the result of the parsing action will
             be exported to the PageContext and associated with the value of
             var. The type of the exported var is java.lang.String.-->
    <fmt:parseDate value='<%= (String) pageContext.getAttribute("dte") %>' var="rDate"/>
    <tck:isInstance varName="rDate" type="java.util.Date"/>
</tck:test>
