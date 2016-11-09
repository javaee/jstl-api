<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="positiveSetDataSourceScopeVarAttributeTest">

   <!-- Validate the explicit/implicit behavior of the
             action when scope is and isn't provided (var attribute specified) -->

   <h1>Validating sql:setDataSource action scope attributes </h1>
   <p>

   <sql:setDataSource
       dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
       var='riPage' />
   <tck:checkScope varName="riPage" />

   <sql:setDataSource
       dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
       var='rePage' scope='page'   />
   <tck:checkScope varName="rePage"  inScope='page'/>

     <sql:setDataSource
       dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
       var='reSession' scope='session'   />
   <tck:checkScope varName="reSession" inScope="session" />

    <sql:setDataSource
       dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
       var='reRequest' scope='request'   />
   <tck:checkScope varName="reRequest"  inScope='request'/>

     <sql:setDataSource
       dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
       var='reApplication' scope='application'   />
   <tck:checkScope varName="reApplication" inScope='application'/>

</tck:test>
