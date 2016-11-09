<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Locale" %>
<tck:test testName="positiveSetLocaleValueTest">
    <% 
        Locale loc = new Locale("en", "GB");
        pageContext.setAttribute("gbloc", loc);
    %>
    <c:set var="frloc" value="fr_CA"/>

    <!-- Test the RT tags of String and Locale object as values. -->
    <fmt:setLocale value='<%= (String) pageContext.getAttribute("frloc") %>'/>
    <tck:config var="locVar" configVar="locale" op="get"/>
    <c:out value="${locVar}" default="Test FAILED"/><br>

    <fmt:setLocale value='<%= (Locale) pageContext.getAttribute("gbloc") %>'/>
    <tck:config var="locVar" configVar="locale" op="get"/>
    <c:out value="${locVar}" default="Test FAILED"/><br>

    <fmt:setLocale value="en_US"/>
    <tck:config var="locVar" configVar="locale" op="get"/>
    <c:out value="${locVar}" default="Test FAILED"/><br>
</tck:test>
