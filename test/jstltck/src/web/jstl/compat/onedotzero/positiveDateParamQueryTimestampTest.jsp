<%-- 
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="sql_rt" uri="http://java.sun.com/jstl/sql_rt" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="positiveDateParamQueryTimestampTest">

   <%
      pageContext.setAttribute("theDate", new Date( 101,7,30,20,20,20));
   %>
   <c:set var="expectedRows" value="${1}" />


   <!-- EL: Validate sql:query, sql:dateParam actions specifying the type 
       of timestamp -->

   <h1>Validate sql:query, sql:dateParam actions specifying the type 
       of timestamp using EL</h1>
   <p>
   <%-- Init our table prior to starting the test --%>
   <sql:update var="updateCount" dataSource="${applicationScope.jstlDS}"
               sql="${sqlProps.Delete_Jstl_Tab3_AllRows_Query}" />   
   <sql:update var="updateCount" dataSource="${applicationScope.jstlDS}"
               sql="${sqlProps.Insert_Jstl_Tab3_Query}" />

   <sql:query var="resultSet" dataSource="${applicationScope.jstlDS}"
              sql="${sqlProps.Select_Jstl_Tab3_Timestamp_Query}" >
      <sql:dateParam value="${theDate}" type='timestamp'/>
   </sql:query>

   <c:set var="rows" value="${resultSet.rowsByIndex}" />
   <c:set var='column' value='${resultSet.columnNames}' />   

   <c:choose>
      <c:when test="${resultSet.rowCount != expectedRows}">
         <H2>ERROR:</H2>
         The query: <strong>
         "<c:out value="${sqlProps.Select_Jstl_Tab3_Timestamp_Query}" />"
         </strong> returned <strong>"<c:out value="${resultSet.rowCount}" />"
         </strong> rows and the expected number of rows was
         <strong>"<c:out value="${expectedRows}" />"</strong>.
         <p>
      </c:when>
      <c:otherwise>
         The query did return a Result Object that contained
         <strong><c:out value="${expectedRows}" /></strong> row as expected.
         <p>        
      </c:otherwise>
   </c:choose>


   <!-- EL: Validate sql:query, sql:dateParam actions specifying the type 
       of timestamp -->

   <h1>Validate sql:query, sql:dateParam actions specifying the type 
       of timestamp using RT</h1>
   <p>
   <%-- Init our table prior to starting the test --%>
   <sql:update var="updateCount" dataSource="${applicationScope.jstlDS}"
               sql="${sqlProps.Delete_Jstl_Tab3_AllRows_Query}" />   
   <sql:update var="updateCount" dataSource="${applicationScope.jstlDS}"
               sql="${sqlProps.Insert_Jstl_Tab3_Query}" />

   <sql_rt:query var="resultSet2" 
                 dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'  
                 sql='<%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Select_Jstl_Tab3_Timestamp_Query") %>' >

      <sql_rt:dateParam value='<%= (Date) pageContext.getAttribute("theDate") %>' type='timestamp'/>
   </sql_rt:query>


   <c:set var="rows2" value="${resultSet2.rowsByIndex}" />
   <c:set var='column2' value='${resultSet2.columnNames}' />
   
   <c:choose>
      <c:when test="${resultSet2.rowCount != expectedRows}">
         <H2>ERROR:</H2>
         The query: <strong>
         "<c:out value="${sqlProps.Select_Jstl_Tab3_Timestamp_Query}" />"
         </strong> returned <strong>"<c:out value="${resultSet2.rowCount}" />"
         </strong> rows and the expected number of rows was
         <strong>"<c:out value="${expectedRows}" />"</strong>.
         <p>
      </c:when>
      <c:otherwise>
         The query did return a Result Object that contained
         <strong><c:out value="${expectedRows}" /></strong> row as expected.
         <p>        
      </c:otherwise>
   </c:choose>


</tck:test>
