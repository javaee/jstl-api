<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positivePDValueNullEmptyTest">

    <!-- If value is null or empty, the scoped variable defined by var
             and scope will be removed. -->
    <c:set var="pvalue" value="value" scope="session"/>
    <fmt:parseDate value='<%= null %>' var="pvalue" scope="session"/>
    <tck:checkScope varName="pvalue" inScope="session"/>
    <c:set var="pvalue" value="value" scope="application"/>
    <fmt:parseDate value="" var="pvalue" scope="application"/>
    <tck:checkScope varName="pvalue" inScope="application"/>
</tck:test>
