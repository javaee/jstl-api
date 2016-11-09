<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.ArrayList" %>
<tck:test testName="positiveVarTest">
    <%
        pageContext.setAttribute("eVal", new Boolean("true"));
        pageContext.setAttribute("rVal", new Boolean("true"));
        ArrayList simpleList = new ArrayList();
        simpleList.add("sample1");
        simpleList.add(new Integer("123"));
    %>
    <!-- tag support of 'var' attribute including nested behavior -->
    <tck:displayType varName="rVal"/>
    <c:forEach var="rVal" items='<%= simpleList %>'>
        <tck:displayType varName="rVal"/>   
    </c:forEach>
    <tck:displayType varName="rVal"/>   
    
</tck:test>
