<%--
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="positiveQueryEmptyResultTest">

   <!-- Validate that a Simple SQL Query will return
              an empty Result object when query returns 0 rows -->

   <h1>Validating sql:query action returns empty Result object </h1>
   <p>


   <sql:query var="resultSet2"
                 dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'  >
       <%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Select_NoRows_Query") %>
   </sql:query>

   <c:choose>
      <c:when test="${resultSet2.rowCount != 0}">
         <H2>ERROR:</H2>
         The query: <strong>
         "<c:out value="${sqlProps.Select_NoRows_Query}" />"
         </strong> returned <strong>"<c:out value="${resultSet2.rowCount}" />"
         </strong>  rows and the expected number of
          rows was <strong>"0" </strong>
         <p>
      </c:when>
      <c:otherwise>
         The query did return a Result object that contained
         <strong>0</strong> rows.
         <p>
      </c:otherwise>
   </c:choose>

</tck:test>
