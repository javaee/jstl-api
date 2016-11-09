<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeImportRequestDispatcherRTIOExceptionTest">

    <!-- If RequestDispather.include() method throws an IOException
             or RuntimeException, a JspException must be thrown
             with the message of the original exception included in the
             message, and the original Exception as the root cuase. -->
    IOException:<br>
    <tck:catch var="rioe" exception="javax.servlet.jsp.JspException"
               exceptionText="thrown from included resource"
               checkRootCause="true" rootException="java.io.IOException">
        <c:import url="IOException.jsp"/>
    </tck:catch>
    <c:out value="${rioe}" default="Test FAILED" escapeXml="false"/><br>
    ServletException:<br>
    <tck:catch var="rrte" exception="javax.servlet.jsp.JspException"
               exceptionText="thrown from included resource"
               checkRootCause="true" rootException="java.lang.RuntimeException">
        <c:import url="RuntimeException.jsp"/>
    </tck:catch>
    <c:out value="${rrte}" default="Test FAILED" escapeXml="false"/><br>
</tck:test>
