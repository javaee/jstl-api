<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="positiveTxCommitLifeCycleTest">

   <!-- Validate sql:transaction action Lifecycle for a committed transaction
    -->

   <h1>Validate sql:transaction action LifeCycle for a committed transaction </h1>
   <p>

   <sql:transaction dataSource='<%=(DataSource) pageContext.getAttribute("logDS", PageContext.APPLICATION_SCOPE) %>' >

      <sql:update var="updateCount2"
                    sql='<%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Delete_AllRows_Query") %>' />
   </sql:transaction>


    <strong>Dump LifeCycle for sql:transaction action for a committed transaction </strong>
    <p>
    <c:forEach var='entry' items='${applicationScope.connLog}'>
       <c:out value='${entry}' />
       <br>
   </c:forEach>

  <c:remove var='connLog' scope= 'application' />

</tck:test>
