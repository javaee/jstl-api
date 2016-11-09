<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Date" %>
<tck:test testName="positiveFDVarTest">
    <%  
        Date date = new Date(102142631861L);
        pageContext.setAttribute("dte", date);
    %>
    <fmt:setLocale value="en_US"/>
    
    <!-- If var is specifed, the result of the formatting action will
             be exported to the PageContext and associated with the value of
             var. The type of the exported var is java.lang.String.-->
    <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>' var="rDate"/>
    <tck:isInstance varName="rDate" type="java.lang.String"/>
</tck:test>
