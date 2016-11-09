<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="positiveTxRollbackLifeCycleTest">


   <!-- Validate sql:transaction action Lifecycle for a rolledback transaction
    -->

   <h1>Validate sql:transaction action LifeCycle for a rolledback transaction </h1>
   <p>
  <c:catch var="e2"  >
      <sql:transaction dataSource='<%=(DataSource) pageContext.getAttribute("logDS", PageContext.APPLICATION_SCOPE) %>' >
         <sql:update var="updateCount2"
                       sql='<%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Failed_Insert_Query") %>' />
      </sql:transaction>
   </c:catch>


    <strong>Dump LifeCycle for sql:transaction action for commited transaction </strong>
    <p>
    <c:forEach var='entry' items='${applicationScope.connLog}'>
       <c:out value='${entry}' />
       <br>
   </c:forEach>

  <c:remove var='connLog' scope= 'application' />

</tck:test>
