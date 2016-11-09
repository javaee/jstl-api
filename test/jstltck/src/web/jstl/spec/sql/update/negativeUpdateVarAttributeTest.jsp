<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="sql_rt" uri="http://java.sun.com/jstl/sql_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="negativeUpdateVarAttributeTest">
  
  
   <!-- Validate that a sql:update action which  passes empty var
            attribute generates a translation error.-->

<h1>Error:</h1>
A translation error should have occured!
<p>

      <sql:update var="" 
                  dataSource="${applicationScope.jstlDS}" 
                  sql="${sqlProps.Delete_NoRows_Query}" />



</tck:test>

