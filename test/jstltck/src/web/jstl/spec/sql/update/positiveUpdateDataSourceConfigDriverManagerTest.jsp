<%--
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*,java.util.*" %>

<tck:test testName="positiveUpdateDataSourceConfigDriverManagerTest">

   <c:set var='driverInfo'
          value="${header['jstl.db.url']},${header['jstl.db.driver']},${header['jstl.db.user']},${header['jstl.db.password']}" />
   <tck:config configVar="datasource" op="set"
               value='<%= (String) pageContext.getAttribute("driverInfo", PageContext.PAGE_SCOPE) %>'/>

   <!-- Validate sql:update action  by specifying a String
       with DriverManager parameters to javax.servlet.jsp.jstl.sql.dataSource -->

   <h1>Validate sql:update by specifying a String with DriverManager
       parameters to javax.servlet.jsp.jstl.sql.dataSource </h1>
   <p>

   <c:catch var="ex2"  >
       <sql:update var="updateCount2"
                      sql='<%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Delete_NoRows_Query") %>' />
   </c:catch>


   <c:choose>
      <c:when test="${!empty ex2}">
         <H2>ERROR:</H2>
         Could not execute the query <strong><c:out value="${sqlProps.Delete_NoRows_Query}" />
         </strong> when using <strong><c:out value='${driverInfo}'/></strong> for
          javax.servlet.jsp.jstl.sql.dataSource! The Exception that was raised is:
         <strong><c:out value='${ex2}' escapeXml='false' /></strong>.
         <p>
      </c:when>
      <c:otherwise>
         Successfully executed the query when javax.servlet.jsp.jstl.sql.dataSource
          was provided DriverManager parameters.
         <p>
      </c:otherwise>
   </c:choose>

  <tck:config configVar="datasource" op="remove" />


</tck:test>
