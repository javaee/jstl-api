<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fmt_rt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Locale" %>
<tck:test testName="positiveSetLocaleValueTest">
    <% 
        Locale loc = new Locale("en", "GB");
        pageContext.setAttribute("gbloc", loc);
    %>
    <c:set var="frloc" value="fr_CA"/>
    <!-- EL: Test the EL tags of String and Locale object as values. -->
    <fmt:setLocale value="${frloc}"/>
    <tck:config var="locVar" configVar="locale" op="get"/>
    <c:out value="${locVar}" default="Test FAILED"/><br>

    <fmt:setLocale value="${gbloc}"/>
    <tck:config var="locVar" configVar="locale" op="get"/>
    <c:out value="${locVar}" default="Test FAILED"/><br>

    <fmt:setLocale value="en_US"/>
    <tck:config var="locVar" configVar="locale" op="get"/>
    <c:out value="${locVar}" default="Test FAILED"/><br>

    <!-- RT: Test the RT tags of String and Locale object as values. -->
    <fmt_rt:setLocale value='<%= (String) pageContext.getAttribute("frloc") %>'/>
    <tck:config var="locVar" configVar="locale" op="get"/>
    <c:out value="${locVar}" default="Test FAILED"/><br>

    <fmt_rt:setLocale value='<%= (Locale) pageContext.getAttribute("gbloc") %>'/>
    <tck:config var="locVar" configVar="locale" op="get"/>
    <c:out value="${locVar}" default="Test FAILED"/><br>

    <fmt_rt:setLocale value="en_US"/>
    <tck:config var="locVar" configVar="locale" op="get"/>
    <c:out value="${locVar}" default="Test FAILED"/><br>
</tck:test>
