<%--
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.xml.transform.*,javax.xml.transform.stream.*,java.io.*" %>
<tck:test testName="positiveTransformResultTest">
    <c:import url="simple2.xml" var="xmlDoc"/>
    <c:import url="simple2.xsl" var="xslDoc"/>
    <%
        ByteArrayOutputStream eBoa = new ByteArrayOutputStream(128);
        ByteArrayOutputStream rBoa = new ByteArrayOutputStream(128);
        Result eResult = new StreamResult(eBoa);
        Result rResult = new StreamResult(rBoa);
        pageContext.setAttribute("eResult", eResult);
        pageContext.setAttribute("rResult", rResult);
    %>

   <!-- The transform action can accept a Result object which
             acts as a holder for the transformed result. -->
    <x:transform doc='<%= pageContext.getAttribute("xmlDoc") %>'
                    xslt='<%= pageContext.getAttribute("xslDoc") %>'
                    result='<%= (Result) pageContext.getAttribute("rResult") %>'/>
    Result:<br>
    <%
        StreamResult postResult = (StreamResult) pageContext.getAttribute("rResult");
        ByteArrayOutputStream os = (ByteArrayOutputStream) postResult.getOutputStream();
        out.println(os.toString("ISO-8859-1"));
    %>
</tck:test>
