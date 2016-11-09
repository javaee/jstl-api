<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="positiveParamBodyContentQueryTest">
   <%
      pageContext.setAttribute("key", new Integer("1"));
      pageContext.setAttribute("lastName", "Andersen");
   %>
   <c:set var="expectedRows" value="${1}" />

    <!-- Validate ability to utilize  sql:query sql:param actions and
             specifying a parameter as body content to execute the query-->

   <h1>Validating sql:query action by specifying multiple sql:param actions and
   specifying a parameter as body content via RT</h1>
   <p>

   <sql:query var="resultSet2"
                 dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'  >

      <%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Select_Jstl_Tab1_MultiParam_Query") %>

      <sql:param value='<%=(Integer) pageContext.getAttribute("key") %>' />
      <sql:param>
         <c:out value="${lastName}" />
      </sql:param>
   </sql:query>

   <c:set var="rows2" value="${resultSet2.rowsByIndex}" />

   <c:choose>
      <c:when test="${resultSet2.rowCount != expectedRows}">
         <H2>ERROR:</H2>
         The query: <strong>
         "<c:out value="${sqlProps.Select_Jstl_Tab1_MultiParam_Query}" />"
         </strong> which was executed with the parameter values of  <strong>
         <c:out value='${key}' /></strong> and <strong>
         <c:out value='${lastName}'/></strong> returned <strong>
         <c:out value="${resultSet2.rowCount}" /></strong> rows and the
         expected number of rows was
         <strong><c:out value="${expectedRows}" /></strong>.
         <p>
      </c:when>
      <c:when test="${rows2[0][0] != key}">
         <H2>ERROR:</H2>
         The query: <strong>
         "<c:out value="${sqlProps.Select_Jstl_Tab1_MultiParam_Query}" />"
         </strong> which was executed with the parameter values of  <strong>
         <c:out value='${key}' /></strong> and <strong>
         <c:out value='${lastName}'/></strong> returned the wrong row.
         <p>
      </c:when>
      <c:otherwise>
         The query did return a Result Object that contained
         <strong><c:out value="${expectedRows}" /></strong> row as expected.
         <p>
      </c:otherwise>
   </c:choose>

</tck:test>
