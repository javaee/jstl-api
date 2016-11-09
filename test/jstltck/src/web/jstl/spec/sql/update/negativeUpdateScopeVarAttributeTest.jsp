<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="sql_rt" uri="http://java.sun.com/jstl/sql_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="negativeUpdateScopeVarAttributeTest">
   
   <!-- Validate that a sql:update action specifies a scope
              attribute but not a var attribute will generate a
              translation error. -->

      <sql:update scope="page" 
                  dataSource="${applicationScope.jstlDS}" 
                  sql="${Delete_NoRows_Query}" />


</tck:test>

