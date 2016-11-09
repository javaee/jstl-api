<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveUrlRelUrlRewrittenTest">

    <!-- The url action will rewrite, where appropriate,
             all relative URLs.  Since the test client doesn't
             accept cookies, and all JSP pages by default participate
             in a session, the resulting URL should be encoded. -->
    <c:url value="/encoded/test.jsp" var="rRes"/>
    <%
        String url = (String) pageContext.getAttribute("rRes");
        if (url.toLowerCase().indexOf("jsessionid") > -1) {
            out.println("Context-relative path properly rewritten with session information.<br>");
        } else {
            out.println("[ERROR]:  URL not rewritten: " + url + "<br>");
        }
    %>
    Page-relative path:<br>
    <c:url value="test.jsp" var="eRes"/>
    <%
        url = (String) pageContext.getAttribute("eRes");
        if (url.toLowerCase().indexOf("jsessionid") > -1) {
            out.println("Page-relative path properly rewritten with session information.<br>");
        } else {
            out.println("[ERROR]:  URL not rewritten: " + url + "<br>");
        }
    %><br>
    
</tck:test>
