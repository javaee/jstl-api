<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveCatchTest">
    <!-- validate that the exception is caught.  No exception
             should be thrown and the Exception Caught message
             will be displayed. -->
    <c:catch>
        <tck:throwit/>
    </c:catch>
    <c:out value="Exception caught" default="Test FAILED"/><br>
</tck:test>
