<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveFNValueNullEmptyTest">

    <!-- If value is null or empty, no action is performed -->
    <fmt:formatNumber value='<%= null %>'/>
    <fmt:formatNumber value=""/>

    <!-- if value is null or empty, the scoped variable specified by
         'var' will be removed -->
    <c:set var="pageVar" value="value"/>
    <fmt:formatNumber value='<%= null %>' var="pageVar" />
    <c:out value="${pageVar}" default="Scoped variable removed"/>
</tck:test>
