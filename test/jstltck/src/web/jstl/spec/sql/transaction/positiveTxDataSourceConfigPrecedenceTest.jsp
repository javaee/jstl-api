<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="positiveTxDataSourceConfigPrecedenceTest">

   <!-- Validate sql:transaction action  that the dataSource attribute takes
            precedence over the javax.servlet.jsp.jstl.sql.dataSource
            configuration parameter -->

   <h1>Validate sql:transaction action  that the dataSource attribute takes
            precedence over the javax.servlet.jsp.jstl.sql.dataSource
            configuration parameter </h1>
   <p>


   <c:catch var="ex2"  >

       <sql:transaction
           dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'  >
          <sql:query var="resultSet2" >
             <%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Simple_Select_Query") %>
          </sql:query>
       </sql:transaction>

   </c:catch>

   <c:choose>
      <c:when test="${!empty ex2}">
         <H2>ERROR:</H2>
         javax.servlet.jsp.jstl.sql.dataSource <strong>did</strong> take
         precedence over the <strong>dataSource</strong> attribute!The Exception
          that was raised is:
         <strong><c:out value='${ex2}' escapeXml='false' /></strong>.
         <p>
      </c:when>
      <c:otherwise>
         The dataSource attribute <strong>did</strong> take precedence over
          javax.servlet.jsp.jstl.sql.dataSource. The query executed without
          an error.
         <p>
      </c:otherwise>
   </c:choose>


  <tck:config configVar="datasource" op="remove" />


</tck:test>
