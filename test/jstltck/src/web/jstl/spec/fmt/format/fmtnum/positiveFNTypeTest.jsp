<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveFNTypeTest">
    <c:set var="num" value="number"/>
    <c:set var="cur" value="currency"/>
    <c:set var="per" value="percent"/>
    <fmt:setLocale value="en_US"/>

    <!-- The type attribute controls how the value is to be
             formatted (number, currency, percent).  If not
             specified, the default is number -->
    <fmt:formatNumber value="123456"/>
    <fmt:formatNumber value="123456" type="number"/>
    <fmt:formatNumber value="123456" type='<%= (String) pageContext.getAttribute("num") %>'/>
    <fmt:formatNumber value="123456" type="currency"/>
    <fmt:formatNumber value="123456" type='<%= (String) pageContext.getAttribute("cur") %>'/>
    <fmt:formatNumber value="123456" type="percent"/>
    <fmt:formatNumber value="123456" type='<%= (String) pageContext.getAttribute("per") %>'/>
</tck:test>
