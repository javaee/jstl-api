<%--
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeImportAbsResourceNon2xxTest">
    <tck:localAbsUrl var="aUrl" path="/jstl_core_url_import_web/ResponseInternalServerError.jsp"/>

    <!-- If the resource is external (Absolute URL), and the
              response code is not 2xx, throw a JspException
              with the path and status code in the message -->
    Check the message:<br>
    <tck:catch var="ex" exception="javax.servlet.jsp.JspException"
               exceptionText="/jstl_core_url_import_web">
       <c:import url='<%= (String) pageContext.getAttribute("aUrl") %>'/>
    </tck:catch>
    <c:out value="${ex}" default="Test FAILED" escapeXml="false"/><br>
    Check the status code:<br>
    <tck:catch var="scode" exception="javax.servlet.jsp.JspException"
               exceptionText="500">
        <c:import url='<%= (String) pageContext.getAttribute("aUrl") %>'/>
    </tck:catch>
    <c:out value="${scode}" default="Test FAILED" escapeXml="false"/><br>
</tck:test>
