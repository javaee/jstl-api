<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveFNValueTest">
    <c:set var="num" value="123456"/>
    <% 
        Integer number = new Integer("123456");
        pageContext.setAttribute("Num", number);
    %>
    <fmt:setLocale value="en_US"/>

    <!-- The value attribute can accept either a String or a Number
             as the value to format -->
    <fmt:formatNumber value='<%= (String) pageContext.getAttribute("num") %>'/>
    <fmt:formatNumber value='<%= (Number) pageContext.getAttribute("Num") %>'/>
    <fmt:formatNumber value="123456"/>
</tck:test>
