<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.HashMap,java.util.Map,com.sun.ts.tests.jstl.common.beans.SimpleBean" %>
<tck:test testName="positiveSetPropertyTest">
    <%
        pageContext.setAttribute("nm", new String("value"));
        pageContext.setAttribute("nv", new String("nValue"));
        pageContext.setAttribute("mmap", new HashMap());
    %>
    <jsp:useBean id="simple" class="com.sun.ts.tests.jstl.common.beans.SimpleBean"/>

    <!-- Validate that the property and target attributes of the set
             action can properly set the propery on a JavaBean and java.util.Map
             objects.  Validate that the propery value to be set can be provided via the 
             value attribute or as body content. -->
    <c:set value='<%= (String) pageContext.getAttribute("nv") %>'
              property="value"
              target='<%= (SimpleBean) pageContext.getAttribute("simple") %>'/>
    Property value: <c:out value="${simple.value}" default="Test FAILED"/><br>
    <c:set property='<%= (String) pageContext.getAttribute("nm") %>'
              target='<%= (SimpleBean) pageContext.getAttribute("simple") %>'>
        bValue
    </c:set>
    Property value: <c:out value="${simple.value}" default="Test FAILED"/><br>
    <c:set value="mapVal1"
           property="key1" 
           target='<%= (Map) pageContext.getAttribute("mmap") %>'/>
    Map value: <c:out value="${mmap.key1}" default="Test FAILED"/><br>
    <c:set property="key1"
           target='<%= (Map) pageContext.getAttribute("mmap") %>'>
        bodyMapVal1
    </c:set>
    Map value: <c:out value="${mmap.key1}" default="Test FAILED"/><br>
</tck:test>
