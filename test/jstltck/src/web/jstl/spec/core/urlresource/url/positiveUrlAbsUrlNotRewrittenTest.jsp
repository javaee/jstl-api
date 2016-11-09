<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveUrlAbsUrlNotRewrittenTest">
    <tck:localAbsUrl var="url" path="/jstltck-core/non.jsp"/>
    <!-- If the provided URL is an absolute URL, no
              URL rewritting will occur. -->
    No JSESSIONID information should be present in the rewritten URL:<br>
    <c:url value='<%= (String) pageContext.getAttribute("url") %>' var="rUrl"/>
    <%
        String url1 = (String) pageContext.getAttribute("rUrl");
        if(url1.toLowerCase().indexOf("jsessionid") < 0 ) {
            out.println("URL not rewritten.  Test PASSED!<br>");
        } else {
            out.println("URL incorrectly rewritten: " + url1 + " <br>");
        }
    %>
</tck:test>
