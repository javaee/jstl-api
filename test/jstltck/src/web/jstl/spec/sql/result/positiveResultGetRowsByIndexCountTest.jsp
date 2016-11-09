<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="positiveResultGetRowsByIndexCountTest">

 <!-- Validate ability to utilize Result.getRowsByIndex() to access the
           returned rows. Check that the correct row count is returned -->

   <h1>Validate ability to utilize Result.getRowsByIndex() to access the
       returned rows. Check that the correct row count is returned </h1>
   <p>
   <sql:query var="resultSet2"
                 dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
                 sql='<%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Simple_Select_Query") %>' />

  <c:set var='rows2' value='${resultSet2.rowsByIndex}' />

  <%
      Object[][] rows = (Object[][]) pageContext.getAttribute("rows2");
      pageContext.setAttribute("rowsReturned2", new Integer(rows.length));
  %>

  <c:choose>
      <c:when test="${rowsReturned2 == initParam.JSTL_TAB1_ROWS}">
         The Correct number of rows <strong>was</strong>
         returned from Result.getRowsByIndex().
         <p>
      </c:when>
      <c:otherwise>
         <h2>Error</h2> The Expected number of rows was not returned from
         Result.getRowsByIndex(). The expected number of columns was
         <strong><c:out value='${initParam.JSTL_TAB1_ROWS}' /></strong>,
         the returned number of rows was <strong>
         <c:out value='${rowsReturned2}' /></strong> using the query
         <strong><c:out value='${sqlProps.Simple_Select_Query}'/></strong>.
         <p>
      </c:otherwise>
   </c:choose>


</tck:test>
