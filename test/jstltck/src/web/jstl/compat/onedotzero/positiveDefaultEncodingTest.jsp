<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fmt_rt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveDefaultEncodingTest">
    <c:remove var="javax.servlet.jsp.jstl.fmt.request.charset"/>
    <!-- EL: No content-type and no scoped variable, so the default
             of iso-8859-1 will be used -->
    <fmt:requestEncoding/>
    <%= request.getCharacterEncoding().toLowerCase() %>

   <!-- RT: No content-type and no scoped variable, so the default
             of iso-8859-1 will be used -->
    <fmt_rt:requestEncoding/>
    <%= request.getCharacterEncoding().toLowerCase() %>
    
</tck:test>
