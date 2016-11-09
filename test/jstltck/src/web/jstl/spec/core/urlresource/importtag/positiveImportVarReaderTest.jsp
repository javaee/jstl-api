<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.io.Reader,java.io.BufferedReader,java.io.IOException" %>
<tck:test testName="positiveImportVarReaderTest">

    <!-- varReader testing -->
    <c:import url="import.txt" varReader="reader">
        <tck:isInstance varName="reader" type="java.io.Reader"/>
        <%
            BufferedReader read = new BufferedReader(
                                    (Reader) pageContext.getAttribute("reader"));
            String line = null;
            try {
                while((line = read.readLine()) != null) {
                    out.println(line);
                }
            } catch (IOException ioe) {
                out.println("Unexpected IOException from Reader!");
            }
        %>
    </c:import>
    <tck:checkScope varName="reader"/>
</tck:test>
 
