<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveScopedAttrEncodingTest">
    <c:remove var="javax.servlet.jsp.jstl.fmt.request.charset" scope="session"/>
    <c:set var="javax.servlet.jsp.jstl.fmt.request.charset" value="US-ASCII" scope="session"/>

    <!-- Encoding should be based of javax.servlet.jsp.jstl.fmt.request.charset
             attribute -->
    <fmt:requestEncoding/>
    <%= request.getCharacterEncoding().toLowerCase() %>

    <c:remove var="javax.servlet.jsp.jstl.fmt.request.charset" scope="session"/>
</tck:test>
