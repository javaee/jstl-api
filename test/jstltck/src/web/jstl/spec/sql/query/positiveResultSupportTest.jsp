<%--
 Copyright 2004 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ taglib prefix="resultSetQuery" uri="http://java.sun.com/jstltck/resultSetQuery" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="positiveResultSupportTest">

   <%
      pageContext.setAttribute("maxRowsLimit", new Integer("5"));
   %>


   <!-- Validate that a resultSetQuery:query action will return
              the number of rows specified by the maxRows attribute -->
   <resultSetQuery:query var="resultSet4"
                 dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'  >
       <%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Simple_Select_Query") %>
   </resultSetQuery:query>

   <c:choose>
      <c:when test="${resultSet4.rowCount != JSTL_TAB1_ROWS}">
         <H2>ERROR:</H2>
         The maxRows attribute was <strong>NOT</strong> specified.  The
          expected number of rows <strong>
          "<c:out value="${JSTL_TAB1_ROWS}" />"</strong> was not
         returned. The actual number of rows returned was
          <strong>"<c:out value="${resultSet4.rowCount}" />"</strong>.
         <p>
      </c:when>
      <c:otherwise>
         The maxRows attribute was <strong>NOT</strong> specified and
         a Result object that contained
         <strong><c:out value="${JSTL_TAB1_ROWS}" /></strong> rows was
         returned as expected. Test PASSED.
         <p>
      </c:otherwise>
   </c:choose>

   <resultSetQuery:query var="resultSet6"
                 dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
                 maxRows='<%=((Integer) pageContext.getAttribute("maxRowsLimit")).intValue() %>' >
      <%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Simple_Select_Query") %>
   </resultSetQuery:query>

   <c:choose>
      <c:when test="${resultSet6.rowCount != maxRowsLimit}">
         <H2>ERROR:</H2>
         The maxRows attribute was set to <strong>
         <c:out value="${maxRowsLimit}" /></strong>.
         The actual number of rows returned was <strong>
          "<c:out value="${resultSet6.rowCount}" />"</strong>.
         <p>
      </c:when>
      <c:otherwise>
         The maxRows attribute was set to <strong>
         <c:out value="${maxRowsLimit}" /></strong>
         and a Result object that contained this row count
          was returned as expected. Test PASSED.
         <p>
      </c:otherwise>
   </c:choose>
</tck:test>

