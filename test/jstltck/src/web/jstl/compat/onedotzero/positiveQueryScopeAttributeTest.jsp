<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="sql_rt" uri="http://java.sun.com/jstl/sql_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*" %>

<tck:test testName="positiveQueryScopeAttributeTest">


   <!-- EL: Validate the explicit/implicit behavior of the
             action when scope is and isn't provided -->

   <h1>Validating sql:query action scope attributes using EL</h1>
   <p>

   <sql:query var="iPage" dataSource="${applicationScope.jstlDS}">
       <c:out value="${sqlProps.Simple_Select_Query}" />
   </sql:query>
   <tck:checkScope varName="iPage" />
   
   <sql:query var="ePage" dataSource="${applicationScope.jstlDS}" scope="page">
       <c:out value="${sqlProps.Simple_Select_Query}" />
   </sql:query>
   <tck:checkScope varName="ePage" inScope="page" />
  
   <sql:query var="eSession" dataSource="${applicationScope.jstlDS}" scope="session">
       <c:out value="${sqlProps.Simple_Select_Query}" />
   </sql:query>
   <tck:checkScope varName="eSession" inScope="session" />
 
   <sql:query var="eRequest" dataSource="${applicationScope.jstlDS}" scope="request">
       <c:out value="${sqlProps.Simple_Select_Query}" />
   </sql:query>
   <tck:checkScope varName="eRequest" inScope="request" />

   <sql:query var="eApplication" dataSource="${applicationScope.jstlDS}" scope="application">
       <c:out value="${sqlProps.Simple_Select_Query}" />
   </sql:query>
   <tck:checkScope varName="eApplication" inScope="application" />
   <c:remove var="eApplication" scope="application"/>

   <!-- RT: Validate the explicit/implicit behavior of the
             action when scope is and isn't provided -->

   <h1>Validating sql:query action scope attributes using RT</h1>
   <p>

   <sql_rt:query var="riPage" 
                 dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'  >
       <%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Simple_Select_Query") %>
   </sql_rt:query>
   <tck:checkScope varName="riPage" inScope="page" />

   <sql_rt:query var="rePage" 
                 dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'  
                 scope = 'page'>
       <%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Simple_Select_Query") %>
   </sql_rt:query>
   <tck:checkScope varName="rePage" inScope="page" />

   <sql_rt:query var="reSession" 
                 dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'  
                 scope = 'session'>
       <%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Simple_Select_Query") %>
   </sql_rt:query>
   <tck:checkScope varName="reSession" inScope="session" />

   <sql_rt:query var="reRequest" 
                 dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'  
                 scope = 'request'>
       <%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Simple_Select_Query") %>
   </sql_rt:query>
   <tck:checkScope varName="reRequest" inScope="request" />

   <sql_rt:query var="reApplication" 
                 dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'  
                 scope = 'application'>
       <%=((Properties)pageContext.getAttribute("sqlProps",PageContext.APPLICATION_SCOPE)).getProperty("Simple_Select_Query") %>
   </sql_rt:query>

   <tck:checkScope varName="reApplication" inScope="application" />
   <c:remove var="reApplication" scope="application"/>

</tck:test>
