<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeUrlContextUrlInvalidValueTest">

    <!-- If the context attribute is provided an invalid
             value, i.e, a context without a leading slash, an
             Exception is thrown.  Additionally, if context
             is specified and the path specified doesn't begin
             with a leading slash, an Exception is thrown. -->
    Context value specified without leading slash:<br>
    <c:catch var="rictx">
        <c:url value="/test" context="invalid"/>
    </c:catch>
    <% 
        Object o = pageContext.getAttribute("rictx");
        if (o != null) {
            if (o instanceof Throwable) {
                out.println("Invalid value provided to context attribute, and Exception was thrown.  Test PASSED!<br>");
            } else {
                out.println("[Error]: Var was exported but was not an instance of Throwable!<br>");
            }
        } else {
            out.println("[Error]: No Exception thrown!<br>");
        }
    %>
    Context specified relative path without leading slash:<br>
    <c:catch var="rival">
        <c:url value="test" context="/jstltck-fmt"/>
    </c:catch>
    <% 
        o = pageContext.getAttribute("rival");
        if (o != null) {
            if (o instanceof Throwable) {
                out.println("Invalid value provided to value attribute, and Exception was thrown.  Test PASSED!<br>");
            } else {
                out.println("[Error]: Var was exported but was not an instance of Throwable!<br>");
            }
        } else {
            out.println("[Error]: No Exception thrown!<br>");
        }
    %>
</tck:test>
