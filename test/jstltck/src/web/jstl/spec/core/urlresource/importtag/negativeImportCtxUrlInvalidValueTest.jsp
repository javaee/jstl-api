<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeImportCtxUrlInvalidValueTest">

    <!-- If the context attribute is specified, the URL provided
             to the url attribute does not have a leading slash ('/'),
             an Exception will be thrown. -->
    <c:catch var="rex">
        <c:import url="import.txt" context="/jstltck-core"/>
    </c:catch>
    <% 
        Object o = pageContext.getAttribute("rex");
        if (o != null) {
            if (o instanceof Throwable) {
                out.println("Invalid type provided to action and Exception was thrown.  Test PASSED!<br>");
            } else {
                out.println("[Error]: Var was exported but was not an instance of Throwable!<br>");
            }
        } else {
            out.println("[Error]: No Exception thrown!<br>");
        }
    %>
</tck:test>
