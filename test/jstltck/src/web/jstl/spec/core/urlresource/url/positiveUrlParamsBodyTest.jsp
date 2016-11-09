<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveUrlParamsBodyTest">

    <!-- Validate the action can properly handled nested param subtags -->
    <c:url var="rUrl" value="/jstl">
        <c:param name="parm1" value="value1"/>
    </c:url>
    <%
        String retVal = (String) pageContext.getAttribute("rUrl");
        if (retVal.indexOf("parm1=value1") > -1) {
            out.println("Expected parameter found. Test PASSED!<br>");
        } else {
            out.println("Test FAILED!<br>\n" +
                      "Unable to find request parameter 'parm1'<br>\n" +
                      "Returned value: " + retVal + "<br>");
        }
    %>
    <c:url var="rcUrl" value="/jstl" context="/jstltck-core">
        <c:param name="parm1" value="value1"/>
    </c:url>
    <%
        retVal = (String) pageContext.getAttribute("rcUrl");
        if (retVal.indexOf("parm1=value1") > -1) {
            out.println("Expected parameter found. Test PASSED!<br>");
        } else {
            out.println("Test FAILED!<br>\n" +
                      "Unable to find request parameter 'parm1'<br>\n" +
                      "Returned value: " + retVal + "<br>");
        }
    %>
</tck:test>
