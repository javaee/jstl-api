<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveCatchVarTest">
    <!-- Validate that if var is specified, and an exception is
             thrown, that the exception is stored in var. -->
    <c:catch var="ex">
        <tck:throwit/>
    </c:catch>
    <tck:isInstance varName="ex" type="java.lang.IllegalArgumentException"/>
</tck:test>
