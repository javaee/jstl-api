<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveXPathVariableBindingsTest">
    <!-- Validate the following bindings 
            foo - pageContext.findAttribute("foo")
            $param.foo - request.getParameter("foo")
            $header:foo - request.getHeader("foo")
            $initParam:foo - application.getInitParamter("foo")
            $cooke:foo - maps to the cookies value for name foo
            $pageScope:foo - pageContext.getAttribute("foo", PageContext.PAGE_SCOPE)
            $requestScope:foo - pageContext.getAttribute("foo", PageContext.REQUEST_SCOPE)
            $sessionScope:foo - pageContext.getAttribute("foo", PageContext.SESSION_SCOPE)
            $applicationScope:foo - pageContext.getAttribute("foo", PageContext.APPLICATION_SCOPE) -->
    <%-- TEST INIT --%>
    <c:set var="findVar" value="foundit" scope="session"/>
    <c:set var="objPage" value="page" scope="page"/>
    <c:set var="objRequest" value="req" scope="request"/>
    <c:set var="objSession" value="sess" scope="session"/>
    <c:set var="objApplication" value="appl" scope="application"/>
    <%-- END TEST INIT --%>
    <%-- removed $header:reqheader  JSTL RI bug 5018764 --%>

    findAttribute: <x:out select="string($findVar)"/><br>
    Page scope: <x:out select="string($pageScope:objPage)"/><br>
    Request scope: <x:out select="string($requestScope:objRequest)"/><br>
    Session scope: <x:out select="string($sessionScope:objSession)"/><br>
    Application scope: <x:out select="string($applicationScope:objApplication)"/><br>
    Init param: <x:out select="string($initParam:initBinding)"/><br>
    Request param: <x:out select="string($param:param1)"/><br>
    Cookie: <x:out select="string($cookie:mycookie)"/><br>
</tck:test>
