<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*" %>

<tck:test testName="positiveQueryVarAttributeTest">

   <!-- Validate the exported var attribute is of type
             javax.servlet.jsp.jstl.sql.Result -->

   <h1>Validating sql:query action var attribute is of type javax.servlet.jsp.jstl.sql.Result </h1>
   <p>

   <sql:query var="resultSet2"
                 dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>' >
       <c:out value="${sqlProps.Simple_Select_Query}" />
   </sql:query>

   <tck:isInstance varName='resultSet2' type='javax.servlet.jsp.jstl.sql.Result' />

</tck:test>
