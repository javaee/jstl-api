<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveItemsNullTest">
    <!-- Noiteration is performed if items is null -->
    <c:forEach items='<%= null %>'>
        <c:out value="Iteration Performed -> Test FAILED" default="Test FAILED"/>
    </c:forEach>
</tck:test>
