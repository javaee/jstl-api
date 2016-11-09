<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.HashMap,java.util.Map,com.sun.ts.tests.jstl.common.beans.SimpleBean" %>
<tck:test testName="positiveSetVarNullValueTest">
    <% 
        HashMap map = new HashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        pageContext.setAttribute("map", map);
    %>
    <jsp:useBean id="simple" class="com.sun.ts.tests.jstl.common.beans.SimpleBean" />
    <!-- Validate that if value is null, the variable
             referenced by var is removed from scope. If
             setting a property of a Bean or a Map, then
             Map entry is removed, and the Bean property
             is set to null.-->
    Var is set and value is null:<br>
    <c:set var="reTest" value='<%= null %>'/>
    <c:out value="${reTest}" default="Attribute removed.  Test PASSED"/><br>

    Map property, key2 should be removed, thus the value whem accessed, would be null:<br>
    <c:set target='<%= (Map) pageContext.getAttribute("map") %>' property="key2" value='<%= null %>'/>
    <%
        if (!map.containsKey("key2")) {
            out.println("Map Key: 'key2' removed.  Test PASSED<br>");
        } else {
            out.println("Map Key: 'key2' not removed.  Test FAILED<br>");
        }
    %>

    JavaBean property, properly value should be set to null:<br>
    <c:set target='<%= (SimpleBean) pageContext.getAttribute("simple") %>' property="value" value="value"/>
    <c:set target='<%= (SimpleBean) pageContext.getAttribute("simple") %>' property="value" value='<%= null %>'/>
    <c:out value="${simple.value}" default="Bean property null.  Test PASSED"/><br>
</tck:test>
