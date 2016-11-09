<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Vector" %>
<%@ page import="javax.el.ValueExpression" %>

<% Vector v = new Vector();
   v.add("One"); v.add("Two"); v.add("Three");
   pageContext.setAttribute("foo", v);
%>

<tck:test testName="positiveForEachDeferredValueTest1">
   <c:forEach var="item" items="#{foo}">
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
