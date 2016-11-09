<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.*" %>
<tck:test testName="positiveItemsMapTest">
    <%
        HashMap hashMap = new HashMap();
        hashMap.put("map1", "val1");
        hashMap.put("map2", "val2");
        hashMap.put("map3", "val3");
        Hashtable table = new Hashtable();
        table.put("tab1", "val1");
        table.put("tab2", "val2");
        table.put("tab3", "val3");
        Object[] holder = { hashMap, table };
        Iterator hMapI = hashMap.entrySet().iterator();
        Iterator hTabI = table.entrySet().iterator();
    %>

    <c:forEach var="rInner" items='<%= hashMap %>'>
        <%
            Map.Entry test = (Map.Entry) pageContext.findAttribute("rInner");
            if (!hMapI.hasNext()) {
                out.println("Test FAILED.  The forEach action performed more iterations than necessary.");
            }
            Map.Entry control = (Map.Entry) hMapI.next();
            if (!test.getKey().equals(control.getKey())
                || !test.getValue().equals(control.getValue())) {
                out.println("Test FAILED.  Iteration did not work as expected.");
                out.println("Expected key/value pair of : " + control.getKey() + ", " + control.getValue());
                out.println("Received: " + test.getKey() + ", " + test.getValue());
            }
        %>
     </c:forEach>

     <c:forEach var="rInner" items='<%= table %>'>
        <%
            Map.Entry test = (Map.Entry) pageContext.findAttribute("rInner");
            if (!hTabI.hasNext()) {
                out.println("Test FAILED.  The forEach action performed more iterations than necessary.");
            }
            Map.Entry control = (Map.Entry) hTabI.next();
            if (!test.getKey().equals(control.getKey())
                || !test.getValue().equals(control.getValue())) {
                out.println("Test FAILED.  Iteration did not work as expected.");
                out.println("Expected key/value pair of : " + control.getKey() + ", " + control.getValue());
                out.println("Received: " + test.getKey() + ", " + test.getValue());
            }
        %>
     </c:forEach>

</tck:test>
