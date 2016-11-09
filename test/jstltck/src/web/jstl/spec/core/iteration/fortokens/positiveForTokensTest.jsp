<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveForTokensTest">
    <%
        String complexString = "a###b c# $d";
        String complexDelim = "# ";
    %>

    <!-- Validation of forTokens using dynamic values -->
    <c:forTokens items='<%= complexString %>' delims='<%= complexDelim %>' var="rVar0">
        <c:out value="${rVar0}" default="forTokens Test FAILED"/><br>
    </c:forTokens>
    <!-- Validation of forTokens using static values -->
    <c:forTokens items="a|b|c" delims="|"  var="rVar1">
        <c:out value="${rVar1}" default="forTokens Test FAILED"/><br>
    </c:forTokens>

</tck:test>
