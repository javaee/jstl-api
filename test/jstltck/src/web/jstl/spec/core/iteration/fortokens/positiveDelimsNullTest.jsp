<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveDelimsNullTest">

    <!-- If delims is null, items is treated as on token, so 1 iteration
             should occur -->
    <c:forTokens var="riter" items="1,2" delims='<%= null %>'>
        <c:out value="${riter}"/>
    </c:forTokens>
</tck:test>
