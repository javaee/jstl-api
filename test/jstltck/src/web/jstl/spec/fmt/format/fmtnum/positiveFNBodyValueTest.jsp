<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveFNBodyValueTest">
    <fmt:setLocale value="en_US"/>

    <!-- The value to be formatted can be provided as body
             content to the action -->
    <fmt:formatNumber>
        123456789
    </fmt:formatNumber>
</tck:test>
