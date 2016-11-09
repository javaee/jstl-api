<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="negativeUpdateSQLAttributeTest2">

   <!-- Validate that a sql:update action which  passes an
              invalid SQL query to the sql attribute throws JspException -->

  <h1>Validate that a sql:update action which  passes an invalid SQL query to
      the sql attribute throws JspException </h1>
  <p>
   <tck:catch var="e2" exception= "javax.servlet.jsp.JspException"
             checkRootCause='true'
              exceptionText='<%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Invalid_SQL_Query") %>' >
     <sql:update var="updateCount2"
                   dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
                   sql='<%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Invalid_SQL_Query") %>' />

   </tck:catch>

   <c:out value="${e2}" escapeXml="false"/>



</tck:test>
