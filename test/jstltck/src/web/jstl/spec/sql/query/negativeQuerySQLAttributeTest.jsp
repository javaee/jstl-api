<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import= "javax.sql.*, java.util.*" %>

<tck:test testName="negativeQuerySQLAttributeTest">

   <!-- Validate sql:query action which specifies an invalid SQL Query using
   a sql attribute throws a JspException -->

   <h1>Validate sql:query action which specifies an invalid SQL Query using
   a sql attribute throws a JspException </h1>
   <p>
   <tck:catch var="e2" exception= "javax.servlet.jsp.JspException"
             checkRootCause='true'
              exceptionText='<%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Invalid_SQL_Query") %>' >
      <sql:query var="resultSet2"
                    dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
                    sql='<%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Invalid_SQL_Query") %>' />
   </tck:catch>

   <c:out value="${e2}" escapeXml="false"/>

</tck:test>

