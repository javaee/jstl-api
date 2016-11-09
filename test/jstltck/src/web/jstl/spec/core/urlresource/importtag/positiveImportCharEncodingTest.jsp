<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.io.Reader,java.io.BufferedReader,java.io.IOException" %>
<tck:test testName="positiveImportCharEncodingTest">

    <!-- validate charEncoding -->
    charEncoding import:  var or varReader not specified.<br>
    <c:import url="import-encoded.txt" charEncoding="UTF-16"/><br>
    charEncoding import: var is specified varReader is not.<br>
    <c:import url="import-encoded.txt" var="rvar1" charEncoding="UTF-16"/>
    <c:out value="${rvar1}" default="Test FAILED" escapeXml="false"/><br>
    charEncoding import: varReader is specified, var is not.<br>
    <c:import url="import-encoded.txt" varReader="rtReader" charEncoding="UTF-16">
        <%
            BufferedReader read = new BufferedReader(
                                 (Reader) pageContext.getAttribute("rtReader"));
            try {
                for (String line = read.readLine(); line != null; line = read.readLine()) {
                    out.println(line);
                }
            } catch (IOException ioe) {
                out.println("Unexpected IOException from Reader!");
            }
        %>
    </c:import>
</tck:test>
