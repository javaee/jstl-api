<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveOutDefaultAttributeTest">
    <%
        pageContext.setAttribute("defaultVal", "Dynamic default value");
    %>
    <!-- validate the value of the default attribute is used
             if value evaluates to null. -->
    <c:out value='<%= null %>' default='<%= (String) pageContext.getAttribute("defaultVal") %>'/><br>
    <c:out value='<%= null %>' default="static default value"/><br>
</tck:test>
