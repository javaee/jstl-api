<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positivePNVarTest">
    <fmt:setLocale value="en_US"/>

    <!-- The precence of var will export the parsed result to
             a scoped variable of type java.lang.Number -->
    <fmt:parseNumber value="1,234" var="reNum"/>
    <tck:isInstance varName="reNum" type="java.lang.Number"/>
</tck:test>
