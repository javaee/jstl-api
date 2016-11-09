<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveReqEncodingValueTest">
    <c:set var="enc" value="US-ASCII"/>
    <!-- Validate value correctly sets the encoding of the page. -->
    <fmt:requestEncoding value='<%= (String) pageContext.getAttribute("enc") %>'/>
    <c:out value="${requestScope.charenc}" default="Test FAILED"/>
    <% request.removeAttribute("charenc"); %>
    <fmt:requestEncoding value="ISO-8859-1"/>
    <c:out value="${requestScope.charenc}" default="Test FAILED"/>
    <% request.removeAttribute("charenc"); %>
</tck:test>
