<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveUrlNoCharEncodingTest">
    <c:set var="eUrl" value="/jstl_core_web/jstl?foo=test this&foo1=5%&foo2='5=5'"/>
    <!-- No character encoding should be performed by the action -->
    <c:url var="rVar" value='<%= (String) pageContext.getAttribute("eUrl") %>'/>
    <%
        String expVal = (String) pageContext.getAttribute("eUrl");
        String retVal = (String) pageContext.getAttribute("rVar");
        expVal = expVal.substring(expVal.indexOf('?'));
        retVal = retVal.substring(retVal.indexOf('?'));
        if (expVal.equals(retVal)) {
            out.println("No character encoding occurred.<br>");
        } else {
            out.println("Character encoding occurred!<br>\n" +
                        "expected: " + expVal + "<br>\n" +
                        "returned: " + retVal + "<br>");
        }
    %>
</tck:test>
