<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="positiveParamQuerySQLAttributeTest">

   <%
      pageContext.setAttribute("key", new Integer("1"));
   %>
   <c:set var="expectedRows" value="${1}" />

   <!-- Validate sql:query, sql:param actions using sql attribute
             to execute query-->

   <h1>Validating sql:query and sql:param actions using sql attribute via RT</h1>
   <p>

   <sql:query var="resultSet2"
                 dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
                 sql='<%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Select_Jstl_Tab1_Using_Param_Query") %>' >

      <sql:param value='<%=(Integer) pageContext.getAttribute("key") %>' />
   </sql:query>


   <c:set var="rows2" value="${resultSet2.rowsByIndex}" />
   <c:set var='column2' value='${resultSet2.columnNames}' />

   <c:choose>
      <c:when test="${resultSet2.rowCount != expectedRows}">
         <H2>ERROR:</H2>
         The query: <strong>
         "<c:out value="${sqlProps.Select_Jstl_Tab1_Using_Param_Query}" />"
         </strong> returned <strong>"<c:out value="${resultSet2.rowCount}" />"
         </strong> rows and the expected number of rows was
         <strong>"<c:out value="${expectedRows}" />"</strong>.
         <p>
      </c:when>
      <c:when test="${rows2[0][0] != key}">
         <H2>ERROR:</H2>
         The query: <strong>
         "<c:out value="${sqlProps.Select_Jstl_Tab1_Using_Param_Query}" />"
         </strong> returned the incorrect value for the column <strong>
         <c:out value="${column2[0]}" /></strong>. The expected
         value was <strong>"<c:out value="${key}" />"</strong> and the
         actual column value was <strong>"<c:out value="${rows2[0][0]}" />"</strong>.
         <p>
      </c:when>
      <c:otherwise>
         The query did return a Result Object that contained
         <strong><c:out value="${expectedRows}" /></strong> row as expected.
         <p>
      </c:otherwise>
   </c:choose>

</tck:test>
