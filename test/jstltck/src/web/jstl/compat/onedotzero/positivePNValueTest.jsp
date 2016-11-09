<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fmt_rt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positivePNValueTest">
    <c:set var="num" value="1,234"/>
    <fmt:setLocale value="en_US"/>
    <!-- EL: Validate the actions behavior with the value attribute.  The
             action/attribute should be able to support both EL and static
             values. -->
    <fmt:parseNumber value="${num}"/>
    <fmt:parseNumber value="1,234"/>

     <!-- RT: Validate the actions behavior with the value attribute.  The
             action/attribute should be able to support both EL and static
             values. -->
    <fmt_rt:parseNumber value='<%= (String) pageContext.getAttribute("num") %>'/>
    <fmt_rt:parseNumber value="1,234"/>
</tck:test>
