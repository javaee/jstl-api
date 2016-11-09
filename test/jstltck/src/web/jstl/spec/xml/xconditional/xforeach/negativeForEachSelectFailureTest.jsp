<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeForEachSelectFailureTest">

    <!-- If the XPath expression provided to the select attribute
             fails to evaluated, an instance of javax.servlet.jsp.JspException
             is thrown. -->
    <tck:catch var="rex" exception="javax.servlet.jsp.JspException">
        <x:forEach select="$doc//b">
            Body Content improperly processed.<br>
        </x:forEach>
    </tck:catch>
    <c:out value="${rex}" default="Test FAILED" escapeXml="false"/><br>
</tck:test>
