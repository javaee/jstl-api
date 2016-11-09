<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="negativeSetDataSourceDataSourceAttributeDataSourceTest">

  <%
      pageContext.setAttribute("invalidDataSource", new Integer("-1"));
   %>

    <!-- Validate sql:query and setDataSource actions by specifying a invalid
        object as the dataSource attribute-->

   <h1>Validate sql:query and setDataSource actions by specifying an invalid
       object as the dataSource attribute </h1>
   <p>


  <tck:catch var="ex2" exception="javax.servlet.jsp.JspException" >
      <sql:setDataSource
          dataSource='<% (Integer) pageContext.getAttribute("invalidDataSource", PageContext.PAGE_SCOPE) %>'
          var='driverInfoDS2'/>
  </tck:catch>

<c:out value="${ex2}" escapeXml="false"/>



</tck:test>
