<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="negativeTxUpdateDataSourceAttributeTest">

   <h1>Error :</h1>
   You should have encountered a translation error as sql:update action cannot
   specify a dataSource attribute within a sql:transaction action!
   <p>
   <sql:transaction dataSource="${applicationScope.jstlDS}" >
      <sql:update var="updateCount"
                  dataSource="${applicationScope.jstlDS}"
                  sql="${sqlProps.Insert_Row_Query}" />
   </sql:transaction>

</tck:test>
