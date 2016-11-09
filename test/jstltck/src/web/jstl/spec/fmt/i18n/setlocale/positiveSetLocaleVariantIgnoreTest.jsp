<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Locale" %>
<tck:test testName="positiveSetLocaleVariantIgnoreTest">
    <% 
        Locale loc = new Locale("en", "US");
        pageContext.setAttribute("loc", loc);
    %>

    <!-- If value is of type java.util.Locale, then variant,
             if supplied, will be ignored. -->
    <fmt:setLocale value='<%= (Locale) pageContext.getAttribute("loc") %>' variant="INVALID"/>
    <tck:config var="locVar" configVar="locale" op="get"/>
    <c:out value="${locVar}" default="Test FAILED"/>
</tck:test>
