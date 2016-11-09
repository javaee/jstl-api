<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positivePNValueTest">
    <c:set var="num" value="1,234"/>
    <fmt:setLocale value="en_US"/>

     <!-- Validate the actions behavior with the value attribute.  The
             action/attribute should be able to support both EL and static
             values. -->
    <fmt:parseNumber value='<%= (String) pageContext.getAttribute("num") %>'/>
    <fmt:parseNumber value="1,234"/>
</tck:test>
