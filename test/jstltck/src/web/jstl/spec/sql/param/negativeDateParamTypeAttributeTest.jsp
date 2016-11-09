<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="negativeDateParamTypeAttributeTest">


   <%
      pageContext.setAttribute("theDate", new java.util.Date( 101,7,30,19,19,19));
   %>

  <!-- Validate  sql:dateParam action specifying and invalid
            value for the type attribute throws a JspException -->

   <h1>Validate  sql:dateParam action specifying and invalid
    value for the type attribute throws a JspException</h1>
   <p>

   <tck:catch var="e" exception= "javax.servlet.jsp.JspException" >
      <sql:query var="resultSet2"
                    dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
                    sql='<%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Select_Jstl_Tab3_Date_Query") %>' >

      <sql:dateParam value='<%= (java.util.Date) pageContext.getAttribute("theDate") %>' type='invalidType'/>
   </sql:query>

   </tck:catch>

   <c:out value="${e}" escapeXml="false"/>

</tck:test>
