<%--
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positivePDBodyValueTest">
    <fmt:setLocale value="en_US"/>
    <fmt:setTimeZone value="EST"/>

    <!-- The date to be parsed can be provided as body content to the
              action. -->
    <fmt:parseDate type="both" var="e2">
        Nov 21, 2000 3:45:02 AM
    </fmt:parseDate>
    <fmt:formatDate value="${e2}" type="both" timeZone="EST"/>

</tck:test>
