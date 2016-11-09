<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="negativeParamUpdateBodyContentTest">

   <!-- Validate sql:update action that specifies a query with placeholders
             throws a JspException if there is no sql:param action specified -->

   <h1> Validate sql:update action that specifies a query with placeholders
        throws a JspException if there is no sql:param  action specified</h1>
   <p>

   <tck:catch var="e2" exception= "javax.servlet.jsp.JspException"            checkRootCause='true'
              exceptionText='<%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Delete_Jstl_Tab2_Using_Param_Query") %>' >
       <sql:update var="updateCount2"
                      dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>' >
             <c:out value="${sqlProps.Delete_Jstl_Tab2_Using_Param_Query}" />
       </sql:update>
   </tck:catch>

   <c:out value="${e2}" escapeXml="false"/>


</tck:test>
