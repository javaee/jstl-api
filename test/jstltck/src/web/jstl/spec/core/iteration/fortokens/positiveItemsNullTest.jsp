<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveItemsNullTest">

    <!-- If items is null, iteration should not be performed. -->
    <c:forTokens items='<%= null %>' delims=",">
        <c:out value="Iteration performed.  Test FAILED!" default="Test FAILED"/>
    </c:forTokens>
</tck:test>
