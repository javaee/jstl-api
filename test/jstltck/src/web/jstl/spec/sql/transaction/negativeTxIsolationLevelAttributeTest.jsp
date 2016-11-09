<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="negativeTxIsolationLevelAttributeTest">

   <c:set var='invalidIsolationLevel' value='invalidIsolation' />

   <!-- Validate sql:transaction and sql:query actions allow for a query
            to be executed successfully -->

   <h1>Validate sql:transaction and sql:query actions allow for a query
            to be executed successfully </h1>
   <p>

   <sql:transaction
                 dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
                 isolationLevel="${invalidIsolationLevel}">
      <sql:query var="resultSet2"
                    sql='<%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Simple_Select_Query") %>' />
   </sql:transaction>

</tck:test>
