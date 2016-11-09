<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeTransformXmlXsltNullEmptyTest">

    <!-- If xml or xslt is null or emtpy, a JspException is thrown. -->
    Xml attribute is null:<br>
    <tck:catch var="ex" exception="javax.servlet.jsp.JspException">
        <x:transform doc='<%= null %>' xslt="non" var="trans"/>
    </tck:catch>
    <c:out value="${ex}" default="Test FAILED" escapeXml="false"/><br>
    Xml attribute is Empty:<br>
    <tck:catch var="ex" exception="javax.servlet.jsp.JspException">
        <x:transform doc="" xslt="non" var="trans"/>
    </tck:catch>
    <c:out value="${ex}" default="Test FAILED" escapeXml="false"/><br>
    Xslt attribute is null:<br>
    <tck:catch var="ex" exception="javax.servlet.jsp.JspException">
        <x:transform doc="non" xslt='<%= null %>' var="trans"/>
    </tck:catch>
    <c:out value="${ex}" default="Test FAILED" escapeXml="false"/><br>
    Xstl attribute is Empty:<br>
    <tck:catch var="ex" exception="javax.servlet.jsp.JspException">
        <x:transform doc="non" xslt="" var="trans"/>
    </tck:catch>
    <c:out value="${ex}" default="Test FAILED" escapeXml="false"/><br>
</tck:test>
