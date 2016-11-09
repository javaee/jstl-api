<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveFNVarTest">
    <fmt:setLocale value="en_US"/>

    <!-- If var is specified, the formatted result is exported
              to the PageContext associated with the variable name specified
              by var. -->
    <fmt:formatNumber value="1234" var="rVar"/>
    <tck:isInstance varName="rVar" type="java.lang.String"/>
    <c:out value="${rVar}" default="Test FAILED"/>
</tck:test>
