<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveTimezoneSetAttrTest">

    <!-- timezone action with no var will set the
             javax.servlet.jsp.jstl.fmt.timeZone scoped
             attribute -->
    <fmt:setTimeZone value="PST"/>
    <tck:config op="get" configVar="timezone" var="rtz"/>
    <tck:isInstance varName="rtz" type="java.util.TimeZone"/>
    <c:remove var="javax.servlet.jsp.jstl.fmt.timeZone.page"/>
</tck:test>

