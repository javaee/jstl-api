<%-- 
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="sql_rt" uri="http://java.sun.com/jstl/sql_rt" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="positiveTxQueryCommitTest">

   <!-- EL: Validate sql:transaction and sql:query actions allow for a query
            to be executed successfully -->

   <h1>Validate sql:transaction and sql:query actions allow for a query
            to be executed successfully using EL</h1>
   <p>

   <sql:transaction dataSource="${applicationScope.jstlDS}" >
      <sql:query var="resultSet" sql="${sqlProps.Simple_Select_Query}" />
   </sql:transaction>

   <c:choose>
      <c:when test="${resultSet.rowCount != JSTL_TAB1_ROWS}">
         <H2>ERROR:</H2>
         The query: <strong>
         "<c:out value="${sqlProps.Simple_Select_Query}" />"
         </strong> returned <strong>"<c:out value="${resultSet.rowCount}" />"
         </strong> rows and the expected number of rows was
         <strong>"<c:out value="${JSTL_TAB1_ROWS}" />"</strong>.
         <p>
      </c:when>
      <c:otherwise>
         The query did return a Result Object that contained
         <strong><c:out value="${JSTL_TAB1_ROWS}" /></strong> rows.
         <p>        
      </c:otherwise>
   </c:choose>

   <!-- RT: Validate sql:transaction and sql:query actions allow for a query
            to be executed successfully -->

   <h1>Validate sql:transaction and sql:query actions allow for a query
            to be executed successfully using RT</h1>
   <p>

   <sql_rt:transaction 
                 dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'  >
      <sql_rt:query var="resultSet2"                  
                    sql='<%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Simple_Select_Query") %>' />
   </sql_rt:transaction>

   <c:choose>
      <c:when test="${resultSet2.rowCount != JSTL_TAB1_ROWS}">
         <H2>ERROR:</H2>
         The query: <strong>
         "<c:out value="${sqlProps.Simple_Select_Query}" />"
         </strong> returned <strong>"<c:out value="${resultSet2.rowCount}" />"
         </strong> rows and the expected number of rows was
         <strong>"<c:out value="${JSTL_TAB1_ROWS}" />"</strong>.
         <p>
      </c:when>
      <c:otherwise>
         The query did return a Result Object that contained
         <strong><c:out value="${JSTL_TAB1_ROWS}" /></strong> rows.
         <p>
      </c:otherwise>
   </c:choose>


</tck:test>
