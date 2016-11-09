<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveSetBodyBehaviorTest">
    <!-- Validate the value to be set can be provided as body
             content to the action.  Also validate that an empty body
             is valid. -->
    <c:set var="var1">
        body value
    </c:set>
    <c:out value="${var1}"/><br>
    <!-- An empty body is valid -->
    <c:set var="var1"></c:set>
</tck:test>
