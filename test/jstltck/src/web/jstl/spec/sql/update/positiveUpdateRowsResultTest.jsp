<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.lang.Integer" %>

   <tck:test testName="positiveUpdateRowsResultTest">


   <c:set var="expectedRowsAffected" value="${1}" />

   <h1>Validate sql:update action var attribute equals the number of rows affected by the SQL statement </h1>

   <%-- Clear out our table and insert one row prior to starting the test --%>
   <sql:update var="updateCount" dataSource="${applicationScope.jstlDS}">
       <c:out value="${sqlProps.Delete_AllRows_Query}" />
   </sql:update>
   <sql:update var="updateCount" dataSource="${applicationScope.jstlDS}">
       <c:out value="${sqlProps.Insert_Row_Query}" escapeXml="false" />
   </sql:update>


   <!-- Validate the exported var attribute returns a value equal
             to the number of rows affected by the SQL statement -->

   <h1>Validate sql:update action var attribute equals the number of rows affected by the SQL statement </h1>

   <sql:update var="updateCount2"
                  dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>' >
       <c:out value="${sqlProps.Delete_AllRows_Query}" />
   </sql:update>

   <c:choose>
       <c:when test="${updateCount2 == expectedRowsAffected}">
          The SQL statement returned the correct update count of <strong>
          <c:out value="${expectedRowsAffected}" /></strong>.<p>
       </c:when>
       <c:otherwise>
          <strong>Error:</strong> The SQL statement "<strong>
          <c:out value="${sqlProps.Delete_AllRows_Query}" />
          </strong>" resulted in an update count of <strong>
          <c:out value="${updateCount2}" /></strong> and the
          the expected update count was <strong>
          <c:out value="${expectedRowsAffected}" /></strong>!<p>
       </c:otherwise>
   </c:choose>

</tck:test>
