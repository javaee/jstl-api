<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeOutSelectFailureTest">

    <!-- If the expression language fails to evaluated the XPath
             expression, an instance of javax.servlet.jsp.JspException is thrown. -->
    <tck:catch var="rex" exception="javax.servlet.jsp.JspException">
        <x:out select="$doc//a"/>
    </tck:catch>
    <c:out value="${rex}" escapeXml="false"/><br>
</tck:test>
