<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveBodyBehaviorTest">
    <!-- Body Content -->
    <c:forEach items="string">
        body has been processed
    </c:forEach>
    <!-- Empty Body -->
    <c:forEach items="string"></c:forEach>

</tck:test>
