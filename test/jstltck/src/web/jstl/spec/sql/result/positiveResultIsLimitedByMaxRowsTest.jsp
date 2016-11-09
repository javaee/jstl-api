<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="positiveResultIsLimitedByMaxRowsTest">

   <%
      pageContext.setAttribute("noMaxRows", new Integer("-1"));
      pageContext.setAttribute("maxRowsLimit", new Integer("5"));
   %>

   <!-- Validate that a sql:query action and Result.isLimitedByMaxRows
            will return the correct value -->

   <h1>Validating sql:query action and  Result.isLimitedByMaxRows </h1>
   <p>

   <sql:query var="resultSet4"
                 dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'  >
       <%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Simple_Select_Query") %>
   </sql:query>

   <c:choose>
      <c:when test="${resultSet4.limitedByMaxRows}">
         <H2>ERROR:</H2>
         The maxRows attribute was <strong>NOT</strong> specified.  The value
         returned from <strong>Result.isLimitedByMaxRows()</strong> was
         <strong>true</strong>. The expected value was <strong>false</strong>.
         <p>
      </c:when>
      <c:otherwise>
         The maxRows attribute was <strong>NOT</strong> specified.  The value
         returned from <strong>Result.isLimitedByMaxRows()</strong> was
         <strong>false</strong> as expected.
         <p>
      </c:otherwise>
   </c:choose>


   <sql:query var="resultSet5"
                 dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
                 maxRows='<%=((Integer) pageContext.getAttribute("noMaxRows")).intValue() %>' >
      <%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Simple_Select_Query") %>
   </sql:query>

   <c:choose>
      <c:when test="${resultSet5.limitedByMaxRows}">
         <H2>ERROR:</H2>
         The maxRows attribute was set to <strong>
         <c:out value="${noMaxRows}" /></strong>. The value
         returned from <strong>Result.isLimitedByMaxRows()</strong> was
         <strong>true</strong>. The expected value was <strong>false</strong>.
         <p>
      </c:when>
      <c:otherwise>
         The maxRows attribute was set to <strong>
         <c:out value="${noMaxRows}" /></strong>. The value
         returned from <strong>Result.isLimitedByMaxRows()</strong> was
         <strong>false</strong> as expected.
         <p>
      </c:otherwise>
   </c:choose>

   <sql:query var="resultSet6"
                 dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
                 maxRows='<%=((Integer) pageContext.getAttribute("maxRowsLimit")).intValue() %>' >
      <%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Simple_Select_Query") %>
   </sql:query>

   <c:choose>
      <c:when test="${resultSet6.limitedByMaxRows}">
         The maxRows attribute was set to <strong>
         <c:out value="${maxRowsLimit}" /></strong>. The value
         returned from <strong>Result.isLimitedByMaxRows()</strong> was
         <strong>true</strong> as expected.
         <p>
      </c:when>
      <c:otherwise>
         <H2>ERROR:</H2>
         The maxRows attribute was set to <strong>
         <c:out value="${maxRowsLimit}" /></strong>. The value
         returned from <strong>Result.isLimitedByMaxRows()</strong> was
         <strong>false</strong>. The expected value was <strong>true</strong>.
         <p>
      </c:otherwise>
   </c:choose>


   <%-- Hard code maxRows to the value of maxRowsLimit --%>

   <sql:query var="resultSet7"
                 dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
                 maxRows='5' >
      <%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Simple_Select_Query") %>
   </sql:query>

   <c:choose>
      <c:when test="${resultSet7.limitedByMaxRows}">
         The maxRows attribute was set to <strong>
         <c:out value="${maxRowsLimit}" /></strong>. The value
         returned from <strong>Result.isLimitedByMaxRows()</strong> was
         <strong>true</strong> as expected.
         <p>
      </c:when>
      <c:otherwise>
         <H2>ERROR:</H2>
         The maxRows attribute was set to <strong>
         <c:out value="${maxRowsLimit}" /></strong>. The value
         returned from <strong>Result.isLimitedByMaxRows()</strong> was
      </c:otherwise>
   </c:choose>

</tck:test>
