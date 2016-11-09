<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeCWOWhenSelectFailureTest">

    <!-- If the XPath expression provided to the select attribute
             of the when action fails to evaluate, an instance of
             javax.servlet.jsp.JspException must be thrown. -->
    <tck:catch var="rex" exception="javax.servlet.jsp.JspException">
        <x:choose>
            <x:when select="$doc//a">
                Body content improperly processed.<br>
            </x:when>
        </x:choose>
    </tck:catch>
    <c:out value="${rex}" default="Test FAILED" escapeXml="false"/>
</tck:test>
