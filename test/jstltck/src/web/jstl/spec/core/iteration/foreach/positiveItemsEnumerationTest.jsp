<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Vector,java.util.Enumeration" %>
<tck:test testName="positiveItemsEnumerationTest">
    <%
        Vector vector = new Vector();
        vector.add("val1");
        vector.add("val2");
        vector.add("val3");
        vector.add("val4");
        pageContext.setAttribute("eNum", vector.elements());
        Enumeration elE = vector.elements();
        Enumeration elR = vector.elements();
    %>
    <!-- check support for iteration over an enumeration -->
    <c:forEach var="rVar" items='<%= vector.elements() %>'>
        <% 
              String rVari = (String) pageContext.findAttribute("rVar");
              String rVare = (String) elR.nextElement();
              if (rVari.equals(rVare)) {
                out.print(rVari);
              } else {
                out.print("Incorrect order");
              }
        %>
    </c:forEach>

</tck:test>
