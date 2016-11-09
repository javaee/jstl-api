<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveParamEncodingTest">

    <!-- param names and values should be URL encoded if necessary -->
    <c:url var="rUrl" value="/jstltck-core/jstl">
        <c:param name="test" value="received 5"/>
        <c:param name="new test">
            0=0
        </c:param>
    </c:url>
    <%
        String url = (String) pageContext.getAttribute("rUrl");
        if (url.toLowerCase().indexOf("received+5") > -1 && 
            url.toLowerCase().indexOf("0%3d0") > -1) {
            out.println("Params properly encoded<br>");
        } else {
            out.println("Params not encoded!<br>\n" +
                        "url -> " + url + "<br>");
        }
    %>
</tck:test>
