<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeImportRequestDispatcherServletExceptionTest">

    <!-- If RequestDispatcher.include() method throws a ServletException
             and a root cause exists, a JspException is thrown with the
             root cause message as the exception message and the original
             root cause as the JspException root cause.  If no root
             cause is present, the exception text will be included in the
             message and the original exception as the root cause. -->
    <tck:catch var="riae" exception="javax.servlet.jsp.JspException"
               checkRootCause="true" rootException="java.lang.IllegalStateException"
               exceptionText="root message">
        <c:import url="ServletExceptionRootCause.jsp"/>
    </tck:catch>
    <c:out value="${riae}" default="Test FAILED" escapeXml="false"/><br>
    <br>
    <tck:catch var="rse" exception="javax.servlet.jsp.JspException"
               checkRootCause="true" rootException="javax.servlet.ServletException"
               exceptionText="thrown from included resource">
        <c:import url="ServletException.jsp"/>
    </tck:catch>
    <c:out value="${rse}" default="Test FAILED" escapeXml="false"/><br>
</tck:test>
