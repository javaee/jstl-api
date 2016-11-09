<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Locale" %>
<tck:test testName="positveSetLocaleValueNullEmptyTest">
    <%
        String loc = Locale.getDefault().toString();
        pageContext.setAttribute("default", loc);
    %>

    <!-- If value is null or empty, the runtime default is used -->
    <tck:config op="remove" configVar="locale"/>

    <fmt:setLocale value='<%= null %>'/>
    <tck:config op="get" var="gLoc" configVar="locale"/>
    <%
        Object o = pageContext.getAttribute("gLoc");
        if (loc.equals(o.toString())) {
            out.println("Default Locale used!<br>");
        } else {
            out.println("Default Locale no used!<br>");
        }
    %>
    <tck:config op="remove" configVar="locale"/>

    <fmt:setLocale value=""/>
    <tck:config op="get" var="gLoc" configVar="locale"/>
    <%
        o = pageContext.getAttribute("gLoc");
        if (loc.equals(o.toString())) {
            out.println("Default Locale used!<br>");
        } else {
            out.println("Default Locale no used!<br>");
        }
    %>
</tck:test>
