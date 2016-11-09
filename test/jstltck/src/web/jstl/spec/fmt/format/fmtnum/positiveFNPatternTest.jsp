<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveFNPatternTest">
    <c:set var="dec" value=".000"/>
    <c:set var="exp" value="0.###E0"/>
    <fmt:setLocale value="en_US"/>

    <!-- The pattern attribute provides a pattern to be applied
             when formatting a value. if type is specified, it will 
             be ignored, thus all the formatted values should be the same. -->
    <fmt:formatNumber value="1234" pattern='<%= (String) pageContext.getAttribute("exp") %>'/>
    <fmt:formatNumber value="1234" type="number" pattern="0.###E0"/>
    <fmt:formatNumber value="1234" type="percent" pattern="0.###E0"/>
    <fmt:formatNumber value="1234" type="currency" pattern="0.###E0"/>
</tck:test>
