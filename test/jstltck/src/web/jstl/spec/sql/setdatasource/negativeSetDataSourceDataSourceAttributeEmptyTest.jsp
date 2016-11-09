<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*,com.sun.ts.tests.jstl.common.wrappers.TckDataSourceWrapper" %>
<tck:test testName="negativeSetDataSourceDataSourceAttributeEmptyTest">

   <%
      pageContext.setAttribute("invalidDataSource", new TckDataSourceWrapper());
   %>
   <sql:setDataSource dataSource="${invalidDataSource}" var='driverInfoDS' />

   <!-- Validate that a sql:SetDataSource action which is passed an
   uninitialized DataSource Object for the dataSource attribute that a
   JspException will be thrown  the first attempt to utilize the dataSource  -->

   <h1>Validate that a sql:SetDataSource action which is passed an
   uninitialized DataSource Object for the dataSource attribute that a
   JspException will be thrown the  first attempt to utilize the dataSource
   </h1>
   <p>
     <tck:catch var="ex2" exception= "javax.servlet.jsp.JspException" >
      <sql:query var="resultSet2"
                 dataSource='driverInfoDS'  >
            <c:out value="${sqlProps.Select_Jstl_Tab1_By_Id_Query}" />
      </sql:query>
   </tck:catch>

   <c:out value="${ex2}" escapeXml="false"/>


</tck:test>
