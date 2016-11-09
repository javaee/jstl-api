<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveSetTest">
    <%
        pageContext.setAttribute("someVar", new String("someValue"));
    %>
    <!-- validate the value attribute. -->
    <c:set value='<%= (String) pageContext.getAttribute("someVar") %>' var="rexportedVar0"/>
    <c:set value="staticValue" var="rexportedVar1"/>
    <c:out value="${rexportedVar0}"/><br>
    <c:out value="${rexportedVar1}"/><br>
</tck:test>
