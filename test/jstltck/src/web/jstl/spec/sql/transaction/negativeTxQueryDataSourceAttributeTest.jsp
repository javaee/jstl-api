<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="negativeTxQueryDataSourceAttributeTest">

   <h1>Error :</h1>
   You should have encountered a translation error as sql:query action cannot
   specify a dataSource attribute within a sql:transaction action!
   <p>

   <sql:transaction dataSource="${applicationScope.jstlDS}" >
      <sql:query var="resultSet"
                 dataSource='$applicationScope.jstlDS}'
                 sql="${sqlProps.Simple_Select_Query}" />
   </sql:transaction>
</tck:test>
