<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.*" %>
<tck:test testName="positiveItemsCollectionTest">
    <%
        ArrayList aList = new ArrayList();
        aList.add("aval1");
        aList.add("aval2");
        Vector vector = new Vector();
        vector.add("aval1");
        vector.add("aval2");
        LinkedList lList = new LinkedList();
        lList.add("vval1");
        lList.add("vval2");
        TreeSet treeSet = new TreeSet();
        treeSet.add("tval1");
        treeSet.add("tval2");
        Object[] holder = { aList, vector, lList, treeSet };
    %>

    <!-- check support of iterating through Collections (lists, sets) -->
    <c:forEach var="rOuter" items='<%= holder %>'>
        <tck:displayType varName="rOuter"/>
        <c:forEach var="eInner" items='<%= pageContext.getAttribute("rOuter") %>'>
            <c:out value="${eInner}" default="forEach Test FAILED"/><br>
        </c:forEach>
    </c:forEach>

</tck:test>
