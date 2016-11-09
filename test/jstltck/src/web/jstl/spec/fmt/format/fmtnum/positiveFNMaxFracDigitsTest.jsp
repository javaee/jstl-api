<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveFNMaxFracDigitsTest">
    <fmt:setLocale value="en_US"/>

    <!-- maxFractionDigits specifies the maximum number of
             fractional digits to be displayed when formatting a value -->
    <fmt:formatNumber value="9.123456" maxFractionDigits='<%= 5 %>'/>
    <fmt:formatNumber value=".531111111" type="percent" maxFractionDigits="5"/>
    <fmt:formatNumber value="9.123456" type="currency" maxFractionDigits="5"/>
</tck:test>
