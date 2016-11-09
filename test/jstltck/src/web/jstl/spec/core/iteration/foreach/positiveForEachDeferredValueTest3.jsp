<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.TreeMap" %>
<%@ page import="javax.el.ValueExpression" %>

<% TreeMap map = new TreeMap();
   map.put("golden", "California");
   map.put("empire", "New York");
   map.put("sunshine", "Florida");
   pageContext.setAttribute("states", map);
%>

<tck:test testName="positiveForEachDeferredValueTest3">
   <c:forEach var="item" items="#{states}">
      <tck:save attr="#{item}"/>
   </c:forEach>
   <%
      ArrayList al = (ArrayList) pageContext.getAttribute("alist", PageContext.APPLICATION_SCOPE);
      for (int i = 0; i < al.size(); i++) {
          ValueExpression ve = (ValueExpression) al.get(i);
   %>
          <%= i %>
          <%= ve.getValue(pageContext.getELContext()) %>
          <br/>
   <%
       }
       pageContext.setAttribute("alist", null, PageContext.APPLICATION_SCOPE);
   %>
</tck:test>
