<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import= "javax.sql.*, java.util.*" %>

<tck:test testName="negativeUpdateSQLAttributeTest">

   <%
      pageContext.setAttribute("invalidSQL", new Integer("-1"));
   %>


   <!-- Validate that a sql:update action which  passes an
              invalid Datatype to the sql attribute throws JspException -->

  <h1>Validate that a sql:update action which  passes an invalid Datatype to the
   sql attribute throws JspException </h1>
  <p>
  <tck:catch var="e" exception= "javax.servlet.jsp.JspException"  >
      <sql:update var="resultSet"
                  dataSource="${applicationScope.jstlDS}"
                  sql="${invalidSql}" />
   </tck:catch>

   <c:out value="${e}" escapeXml="false"/>




</tck:test>

