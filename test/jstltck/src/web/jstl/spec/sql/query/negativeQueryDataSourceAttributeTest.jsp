<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="negativeQueryDataSourceAttributeTest">

  <!-- Validate that a sql:query action which is passed an
              invalid Datatype to the dataSource attribute throws a JspException -->

   <h1>Validate that a sql:query action which is passed an invalid Datatype to the
     dataSource attribute throws a JspException  </h1>
   <p>
  <tck:catch var="e2" exception= "javax.servlet.jsp.JspException" >
      <sql:query var="resultSet2"
                 dataSource='<%= pageContext.getAttribute("invalidDataSource", PageContext.PAGE_SCOPE) %>'  >
            <c:out value="${sqlProps.Select_Jstl_Tab1_By_Id_Query}" />
      </sql:query>
   </tck:catch>

   <c:out value="${e2}" escapeXml="false"/>



</tck:test>

