<%--
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.io.*,javax.xml.transform.*,javax.xml.transform.stream.*" %>
<tck:test testName="positiveTransformXsltInputSource">
    <%-- START TEST INITIALIZATION --%>
    <c:import url="simple.xml" var="xmlDoc"/>
    <c:import url="simple.xsl" var="xslDoc"/>
    <%
        // init reader
        Reader eXmlReader = new StringReader((String) pageContext.getAttribute("xslDoc"));
        Reader rXmlReader = new StringReader((String) pageContext.getAttribute("xslDoc"));

        // init javax.xml.transform.Source
        Source eSource = new StreamSource(
                  application.getResourceAsStream("/simple.xsl"));
        Source rSource = new StreamSource(
                  application.getResourceAsStream("/simple.xsl"));
        pageContext.setAttribute("eReader", eXmlReader);
        pageContext.setAttribute("rReader", rXmlReader);
        pageContext.setAttribute("eSource", eSource);
        pageContext.setAttribute("rSource", rSource);
    %>
    <%-- END TEST INITIALIZATION --%>

    <%-- The xslt attribute must be able to accept the following
             input sources:
                - String
                - Reader
                - javax.xml.transform.Source
                - Object exported by: --%>
    In all cases the resulting text should be wrapped by &lt;h4&gt; elements:<br>
    Input from String:<br>
    <x:transform doc='<%= pageContext.getAttribute("xmlDoc") %>'
                    xslt='<%= pageContext.getAttribute("xslDoc") %>'/><br>

    Input from Reader:<br>
    <x:transform doc='<%= pageContext.getAttribute("xmlDoc") %>'
                    xslt='<%= pageContext.getAttribute("rReader") %>'/><br>

    Input from javax.xml.transform.Source:<br>
    <x:transform doc='<%= pageContext.getAttribute("xmlDoc") %>'
                    xslt='<%= pageContext.getAttribute("rSource") %>'/><br>

</tck:test>
