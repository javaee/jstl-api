<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positivePNPatternTest">
    <c:set var="pat" value="##0.#####E0"/>
    <fmt:setLocale value="en_US"/>

    <!-- pattern provides a custom formatting pattern to be applied
             when parsing a number. If type is specified, it is ignored. --> 
    Number: <fmt:parseNumber value="12.345E3" pattern='<%= (String) pageContext.getAttribute("pat") %>'/>
    Number: <fmt:parseNumber value="12.345E3" pattern="##0.#####E0"/>
    Number: <fmt:parseNumber value="12.345E3" pattern="##0.#####E0" type="number"/>
    Currency: <fmt:parseNumber value="$12.50" pattern="$#,##0.00;($#.##0.00)" type="percent"/>
    Percent: <fmt:parseNumber value="12.5%" pattern="##.#%" type="currency"/>
</tck:test>
