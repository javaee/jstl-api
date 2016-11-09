<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.lang.Integer" %>

   <tck:test testName="positiveUpdateVarAttributeTest">

   <!-- Validate the sql:update action exported var attribute is of type
             java.lang.Integer -->

   <h1>Validating sql:update action var attribute is of type java.lang.Integer </h1>

   <sql:update var="updateCount2"
                  dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>' >
       <c:out value="${sqlProps.Delete_NoRows_Query}" />
   </sql:update>

   <tck:isInstance varName='updateCount2' type='java.lang.Integer' />

</tck:test>
