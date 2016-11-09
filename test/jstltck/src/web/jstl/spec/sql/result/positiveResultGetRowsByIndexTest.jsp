<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="positiveResultGetRowsByIndexTest">

  <c:set var='idNum' value='${1}' />
  <c:set var='firstName' value='Lance' />
  <c:set var='lastName' value='Andersen' />

  <!-- Validate ability to utilize Result.getRowsByIndex() to access the
           returned column values -->

   <h1>Validate ability to utilize Result.getRowsByIndex() to access the
           returned column values </h1>
   <p>

   <sql:query var="resultSet2"
                 dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
                 sql='<%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Select_Jstl_Tab1_OneRow_Query") %>' />

 <c:set var='rows2'  value='${resultSet2.rowsByIndex}'/>
  <c:set var='column2' value='${resultSet2.columnNames}' />

  <c:choose>
      <c:when test="${rows2[0][0] == idNum &&
                      rows2[0][1] == firstName &&
                      rows2[0][2] == lastName}">
         Successfully accessed each column value using Result.getRowsByIndex().
         <p>
      </c:when>
      <c:otherwise>
         <h2>Error</h2> Could not access the column values using
         Result.getRowsByIndex(). The expected values where
         <strong><c:out value='${idNum}' />, <c:out value='${firstName}' />,
         <c:out value='${lastName}' /></strong>.  The values returned were <strong>
         <c:out value='${rows2[0][0]}' />, <c:out value='${rows2[0][1]}' />,
         <c:out value='${rows2[0][2]}' /></strong>.
         <p>
      </c:otherwise>
   </c:choose>
</tck:test>
