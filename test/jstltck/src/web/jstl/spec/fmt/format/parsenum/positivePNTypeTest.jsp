<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positivePNTypeTest">
    <c:set var="num" value="number"/>
    <c:set var="cur" value="currency"/>
    <c:set var="per" value="percent"/>
    <fmt:setLocale value="en_US"/>

    <!--  The type attribute specifies how to parse the provided value.
              Test the behavior of the action when specifying different types. 
              If type is not specified, the default value of number is used. -->
    Number: <fmt:parseNumber value="1,234"/><br>
    Number: <fmt:parseNumber value="1,234" type='<%= (String) pageContext.getAttribute("num") %>'/>
    Number: <fmt:parseNumber value="1,234" type="number"/>
    Currency: <fmt:parseNumber value="$1,234.00" type='<%= (String) pageContext.getAttribute("cur") %>'/>
    Currency: <fmt:parseNumber value="$1,234.00" type="currency"/>
    Percent: <fmt:parseNumber value="1.5%" type='<%= (String) pageContext.getAttribute("per") %>'/>
    Percent: <fmt:parseNumber value="1.5%" type="percent"/>
</tck:test>
