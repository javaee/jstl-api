<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="positiveTxDataSourceAttributeDataSourceTest">

  <!-- Validate sql:transaction action by specifying a DataSource Object
           as the dataSource attribute-->

   <h1>Validate sql:transaction action specifying a DataSource Object
       as the dataSource attribute </h1>
   <p>


  <c:catch var="ex2"  >
     <sql:transaction
            dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'  >
        <sql:query var="resultSet2" >
           <c:out value="${sqlProps.Simple_Select_Query}" />
        </sql:query>
     </sql:transaction>
   </c:catch>

   <c:choose>
      <c:when test="${!empty ex2}">
         <H2>ERROR:</H2>
         Could not execute the query <strong><c:out value="${sqlProps.Simple_Select_Query}" />
         </strong> when using a <strong>DataSource Object</strong> for
         the dataSource attribute! The Exception that was raised is:
         <strong><c:out value='${ex2}' escapeXml='false' /></strong>.
         <p>
      </c:when>
      <c:otherwise>
         Successfully executed the query when the dataSource attribute was
         provided a DataSource Object.
         <p>
      </c:otherwise>
   </c:choose>

</tck:test>
