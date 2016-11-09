<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="positiveUpdateNoVarAttributeTest">

   <%
      pageContext.setAttribute("key", new Integer("1"));
   %>
   <%-- Number of rows to be returned by the DML statements --%>
   <c:set var="expectedRowsAffected" value="${1}" />

 <!-- Validate sql:update action does not require the var attribute
            inorder to execute a SQL Statement. -->

   <h1>Validate sql:update action does not require the var attribute
   inorder to execute a SQL Statement </h1>
   <p>

   <%-- Clear out our table prior to starting the test --%>
   <sql:update var="updateCount" dataSource="${applicationScope.jstlDS}">
       <c:out value="${sqlProps.Delete_AllRows_Query}" />
   </sql:update>

   <%-- Insert a row an then validate the row was added to the table --%>
   <sql:update dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
                  sql='<%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Insert_Row_Query") %>' />


   <!-- Validate that we had the correct number of rows added to our table -->
    <sql:query var="resultSet" dataSource="${applicationScope.jstlDS}"
              sql="${sqlProps.Select_Jstl_Tab2_AllRows_Query}" />

   <c:choose>
      <c:when test="${resultSet.rowCount != expectedRowsAffected}">
         <H2>ERROR:</H2>
         The query: <strong>
         "<c:out value="${sqlProps.Insert_Row_Query}" />" </strong>
         did not insert the row(s) as expected.
         <p>
      </c:when>
      <c:otherwise>
         The query did successfully insert
         <strong><c:out value="${expectedRowsAffected}" /></strong> row(s).
         <p>
      </c:otherwise>
   </c:choose>

</tck:test>
