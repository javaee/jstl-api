<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="negativeQueryMaxRowsConfigTest">

     <%-- configure javax.servlet.jsp.jstl.sql.maxRows --%>
     <tck:config configVar="maxrows" op="set" value="invalid" />

   <!-- Validate sql:query action that specifies invalid String value for
        javax.servlet.jsp.jstl.sql.maxRows throws JspException -->

    <h1>Validate sql:query action that specifies invalid String value for
        javax.servlet.jsp.jstl.sql.maxRows throws JspException </h1>
    <p>

  <tck:catch var="e2" exception= "javax.servlet.jsp.JspException" >
     <sql:query var="resultSet2"
                    dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'  >
          <%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Simple_Select_Query") %>
      </sql:query>
   </tck:catch>

   <c:out value="${e2}" escapeXml="false"/>

</tck:test>
