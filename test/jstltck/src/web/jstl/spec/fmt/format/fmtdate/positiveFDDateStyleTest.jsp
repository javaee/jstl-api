<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Date" %>
<tck:test testName="positiveFDDateStyleTest">
    <%  
        Date date = new Date(883192294202L);
        pageContext.setAttribute("dte", date);
    %>
    <c:set var="def" value="default"/>
    <c:set var="sho" value="short"/>
    <c:set var="med" value="medium"/>
    <c:set var="lon" value="long"/>
    <c:set var="ful" value="full"/>
    <fmt:setLocale value="en_US"/>
    <fmt:setTimeZone value="EST"/>

     <!-- dateStyle specifies what date style the formated value
             will be returned in.  This will only be applied
             when type is not specified, or is set to date or both. 
             if dateStyle is not specified, the default of 'default' 
             will be applied if applicable. -->
     <br>'type' not specified -- dateStyle should be applied<br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle='<%= (String) pageContext.getAttribute("def") %>'/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle="default"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle='<%= (String) pageContext.getAttribute("sho") %>'/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle="short"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle='<%= (String) pageContext.getAttribute("med") %>'/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle="medium"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle='<%= (String) pageContext.getAttribute("lon") %>'/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle="long"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle='<%= (String) pageContext.getAttribute("ful") %>'/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>' dateStyle="full"/><br>

     <br>'type' set to 'date' -- dateStyle should be applied<br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>' type="date"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>' type="date"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle='<%= (String) pageContext.getAttribute("def") %>' type="date"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle="default" type="date"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle='<%= (String) pageContext.getAttribute("sho") %>' type="date"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle="short" type="date"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle='<%= (String) pageContext.getAttribute("med") %>' type="date"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle="medium" type="date"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle='<%= (String) pageContext.getAttribute("lon") %>' type="date"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle="long" type="date"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle='<%= (String) pageContext.getAttribute("ful") %>' type="date"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle="full" type="date"/><br>

     <br>'type' set to 'time' -- dateStyle should not be applied<br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>' type="time"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>' type="time"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle='<%= (String) pageContext.getAttribute("def") %>' type="time"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle="default" type="time"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle='<%= (String) pageContext.getAttribute("sho") %>' type="time"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle="short" type="time"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle='<%= (String) pageContext.getAttribute("med") %>' type="time"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle="medium" type="time"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle='<%= (String) pageContext.getAttribute("lon") %>' type="time"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle="long" type="time"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle='<%= (String) pageContext.getAttribute("ful") %>' type="time"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle="full" type="time"/><br>

     <br>'type' set to 'both' -- dateStyle should be applied<br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>' type="both"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>' type="both"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle='<%= (String) pageContext.getAttribute("def") %>' type="both"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle="default" type="both"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle='<%= (String) pageContext.getAttribute("sho") %>' type="both"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle="short" type="both"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle='<%= (String) pageContext.getAttribute("med") %>' type="both"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle="medium" type="both"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle='<%= (String) pageContext.getAttribute("lon") %>' type="both"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle="long" type="both"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle='<%= (String) pageContext.getAttribute("ful") %>' type="both"/><br>
     <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>'
                        dateStyle="full" type="both"/><br>
</tck:test>
