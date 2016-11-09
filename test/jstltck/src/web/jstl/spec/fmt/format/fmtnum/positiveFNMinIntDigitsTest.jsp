<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveFNMinIntDigitsTest">
    <fmt:setLocale value="en_US"/>

    <!-- minIntegerDigits specifies the minimum number of integer digits in
             the formatted value -->
    <fmt:formatNumber value="1234.1" minIntegerDigits='<%= 6 %>'/>
    <fmt:formatNumber value=".53" type="percent" minIntegerDigits="6"/>
    <fmt:formatNumber value="1234.1" type="currency" minIntegerDigits="6"/>
</tck:test>
