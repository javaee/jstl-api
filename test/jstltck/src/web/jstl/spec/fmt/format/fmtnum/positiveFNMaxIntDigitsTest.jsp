<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveFNMaxIntDigitsTest">
    <fmt:setLocale value="en_US"/>

    <!-- maxIntegerDigits specifies the maximum number of
             integer digits to be displayed when formatting a value -->
    <fmt:formatNumber value="123456789.1" maxIntegerDigits='<%= 5 %>'/>
    <fmt:formatNumber value="123456789.1" type="percent" maxIntegerDigits="5"/>
    <fmt:formatNumber value="123456789.1" type="currency" maxIntegerDigits="5"/>
</tck:test>
