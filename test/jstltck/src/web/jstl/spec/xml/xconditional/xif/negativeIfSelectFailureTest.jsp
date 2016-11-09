<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeSelectFailureTest">

    <!-- If the XPath expression provided to the select attribute
             fails to evaluation an instance of javax.servlet.jsp.JspException
             is thrown. -->
    <tck:catch var="ex" exception="javax.servlet.jsp.JspException">
        <x:if select="$doc//a" var="res"/>
    </tck:catch>
    <c:out value="${ex}" default="Test FAILED" escapeXml="false"/>
</tck:test>
