<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeRedirectExcBodyContentTest">

    <!-- Validate that an Exception is thrown
             if the body content of the c:redirect action causes an exception -->
    <c:catch var="rex">
        <c:redirect url="/jstl_core_web/urlresource/param/import.jsp">
            <c:param name="testparm">
                <tck:throwit/>
            </c:param>
        </c:redirect>
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
