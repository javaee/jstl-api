<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.io.Reader,java.io.StringReader" %>
<tck:test testName="positiveParseXmlInputTest">
    <c:set var="sXml" value="<test attr=\"value\">xmltext</test>"/>
    <%
        Reader r = new StringReader("<test attr=\"value\">xmltext</test>");
        pageContext.setAttribute("eReader" , r);
        Reader rt = new StringReader("<test attr=\"value\">xmltext</test>");
        pageContext.setAttribute("rReader" , rt);
    %>

    <!-- The parse action can accept input from multiple sources.
              - String
              - Reader -->
    Parse String:<br>
    <x:parse var="doc" doc='<%= (String) pageContext.getAttribute("sXml") %>'/>
    <x:out select="$doc//test"/>
    <br>

    Parse Reader:<br>
    <x:parse var="doc" doc='<%= (Reader) pageContext.getAttribute("rReader") %>'/>
    <x:out select="$doc//test"/>
    <br>
</tck:test>
