<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeImportRequestDispatcherNon2xxTest">

    <!-- If the resource invoked by RequestDispatcher.include()
             sets a response code other than 2xx, a JspTagException
             is thrown with the status code and path in the message -->
    Check the message:<br>
    <tck:catch var="ex" exception="javax.servlet.jsp.JspException"
               exceptionText="/">
       <c:import url="/ResponseScGone.jsp"/>
    </tck:catch>
    <c:out value="${ex}" default="Test FAILED" escapeXml="false"/>
    Check the status code:<br>
    <tck:catch var="scode" exception="javax.servlet.jsp.JspException"
               exceptionText="410">
        <c:import url="ResponseScGone.jsp"/>
    </tck:catch>
    <c:out value="${scode}" default="Test FAILED" escapeXml="false"/>
</tck:test>
