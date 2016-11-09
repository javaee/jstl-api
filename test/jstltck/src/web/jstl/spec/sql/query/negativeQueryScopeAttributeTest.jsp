<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page import="javax.sql.*" %>

<tck:test testName="negativeQueryScopeAttributeRTTest">


   <!-- Validate that the TLV catches the invalid value
            passed to the scope attribute which in turn generates
            a fatal translation error -->

   <h1>Validate sql:query action with invalid scope attribute generates a translation error </h1>
   <p>

   <sql:query var="rePage" dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS") %>'
                 scope="invalid">
       <c:out value="${sqlProps.Simple_Select_Query}" />
   </sql:query>

</tck:test>

