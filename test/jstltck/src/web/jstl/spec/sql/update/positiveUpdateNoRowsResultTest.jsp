<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*" %>

   <tck:test testName="positiveUpdateNoRowsResultTest">

   <!-- Validate the exported var attribute returns a value of 0
             if now rows were affected by the SQL statement -->

   <h1>Validate sql:update action var attribute equals 0 if no rows were affected by the SQL statement </h1>

   <sql:update var="updateCount2"
                  dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>' >
       <c:out value="${sqlProps.Delete_NoRows_Query}" />
   </sql:update>


   <c:choose>
       <c:when test="${updateCount2 == 0}">
          No rows were affected by the query as expected.<p>
       </c:when>
       <c:otherwise>
          <strong>Error:</strong> The query "<strong>
          <c:out value="${sqlProps.Delete_NoRows_Query}" />
          </strong>" resulted in an update count of <strong>
          <c:out value="${updateCount2}" /></strong> and the
          the expected update count was <strong>0</strong>!<p>
       </c:otherwise>
   </c:choose>

</tck:test>
