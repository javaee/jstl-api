<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="positiveQueryDataSourceConfigDataSourceTest">

   <%-- Configure javax.servlet.jsp.jstl.sql.dataSource --%>
   <tck:config configVar="datasource" op="set"
               value='<%= (DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'/>

  <!-- Validate sql:query action and javax.servlet.jsp.jstl.sql.dataSource
            configuration parameter  specifying a DataSource Object -->

   <h1>Validating sql:query action, the javax.servlet.jsp.jstl.sql.dataSource
   configuration parameter  specifying a DataSource Object </h1>
   <p>
   <c:catch var='ex2'>
       <sql:query var="resultSet2"  >
             <%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Simple_Select_Query") %>
       </sql:query>

   </c:catch>

   <c:choose>
      <c:when test="${!empty ex2}">
         <H2>ERROR:</H2>
         Could not execute the query <strong><c:out value="${sqlProps.Simple_Select_Query}" />
         </strong> when using a <strong>DataSource Object</strong> for
          javax.servlet.jsp.jstl.sql.dataSource! The Exception that was raised is:
         <strong><c:out value='${ex2}' escapeXml='false' /></strong>.
         <p>
      </c:when>
      <c:otherwise>
         While using the configuration parameter <strong>
         javax.servlet.jsp.jstl.sql.dataSource</strong>, specifying a DataSource
         Object, the query succeeded.
         <p>
      </c:otherwise>
   </c:choose>


  <tck:config configVar="datasource" op="remove" />
</tck:test>
