<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="negativesetDataSourceScopeAttributeTest">

 <!-- Validate that a sql:setDataSource action specifies a scope
              attribute that is invalid will generate a
              translation error. -->
  <sql:setDataSource dataSource="${jstlDS}" var='driverInfoDS' scope='invalid' />

</tck:test>
