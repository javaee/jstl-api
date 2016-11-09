<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="sql_rt" uri="http://java.sun.com/jstl/sql_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*" %>

   <tck:test testName="positiveUpdateBodyContentTest">


   <!-- EL: Validate the sql:update action supports a SQL
             statement as body content -->

   <h1>Validate sql:update action supports a SQL statement as body content using EL</h1>

   <sql:update var="updateCount" dataSource="${applicationScope.jstlDS}">
       <c:out value="${sqlProps.Delete_NoRows_Query}" />
   </sql:update>

   <c:choose>
       <c:when test="${updateCount == 0}">
          The correct <strong>update count</strong> was received for the
          query.<p>
       </c:when>
       <c:otherwise>
          <h2>Error:</h2> The query "<strong>
          <c:out value="${sqlProps.Delete_NoRows_Query}" />
          </strong>" resulted in an update count of <strong>
          <c:out value="${updateCount}" /></strong> and the
          the expected update count was <strong>0</strong>!<p>
       </c:otherwise>
   </c:choose>

   
   <!-- RT: Validate the sql:update action supports a SQL
             statement as body content -->

   <h1>Validate sql:update action supports a SQL statement as body content using RT</h1>

   <sql_rt:update var="updateCount2" 
                  dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>' >
       <c:out value="${sqlProps.Delete_NoRows_Query}" />
   </sql_rt:update>


   <c:choose>
       <c:when test="${updateCount2 == 0}">
          The correct <strong>update count</strong> was received for the
          query.<p>          
       </c:when>
       <c:otherwise>
          <h2>Error:</h2> The query "<strong>
          <c:out value="${sqlProps.Delete_NoRows_Query}" />
          </strong>" resulted in an update count of <strong>
          <c:out value="${updateCount2}" /></strong> and the
          the expected update count was <strong>0</strong>!<p>
       </c:otherwise>
   </c:choose>

</tck:test>
