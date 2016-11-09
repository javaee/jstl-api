<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveFDValueNullEmptyTest">
    <fmt:setLocale value="en_US"/>
    <fmt:setTimeZone value="EST"/>

    <!-- If value is null and var (or scope and var) is specified,
             the scoped variable identified by var is removed.  If 
             var (or scope and var) is not specified, no action will
             occur. -->
    <!-- Var specified -->
    <c:set var="elRemove" value="[Error]: Scoped variable was not removed"/>
    <fmt:formatDate var="elRemove" value='<%= null %>'/>
    <c:out value="${elRemove}" default="Scoped variable properly removed."/><br>
    <!-- Scope and var specified -->
    <c:set var="elRemove" scope="session" value="[Error]: Scoped variable was not removed"/>
    <fmt:formatDate var="elRemove" scope="session" value='<%= null %>'/>
    <c:out value="${sessionScope.elRemove}" default="Scoped variable properly removed."/><br>
    <!-- No var or scope -->
    <c:set var="elKeep" value="Scoped variable not removed."/>
    <fmt:formatDate value='<%= null %>'/>
    <c:out value="${elKeep}" default="[Error]: Scoped variable was improperly removed."/><br>
</tck:test>
