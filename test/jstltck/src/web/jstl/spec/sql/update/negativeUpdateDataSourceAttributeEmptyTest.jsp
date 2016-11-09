<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*,com.sun.ts.tests.jstl.common.wrappers.TckDataSourceWrapper" %>

<tck:test testName="negativeUpdateDataSourceAttributeEmptyTest">


    <%
      pageContext.setAttribute("invalidDataSource", new TckDataSourceWrapper());
   %>

   <!-- Validate that a sql:update action which is passed an uninitialized
            DataSource Object for the dataSource attribute throws a JspException
   -->

   <h1>Validate that a sql:update action which is passed an uninitialized DataSource
   Object for the dataSource attribute throws a JspException </h1>
   <p>

  <tck:catch var="e2" exception= "javax.servlet.jsp.JspException" >
      <sql:update var="updateCount2"
                 dataSource='<%= pageContext.getAttribute("invalidDataSource", PageContext.PAGE_SCOPE) %>'  >
            <c:out value="${sqlProps.Delete_NoRows_Query}" />
      </sql:update>
   </tck:catch>

   <c:out value="${e2}" escapeXml="false"/>


</tck:test>
