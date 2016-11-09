<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveFNCurrencySymbolTest">
    <c:set var="us" value="@"/>
    <fmt:setLocale value="en_US"/>

    <!-- The currencySymbol specifies the symbol to be used when
             formatting currencies.  This will only be applied when
             type is currency -->
    <fmt:formatNumber value="123456" currencySymbol="$"/>
    <fmt:formatNumber value="123456" type="number" currencySymbol="$"/>
    <fmt:formatNumber value="123456" type="percent" currencySymbol="$"/>
    <fmt:formatNumber value="123456" type="currency" currencySymbol='<%= (String) pageContext.getAttribute("us") %>'/>
</tck:test>
