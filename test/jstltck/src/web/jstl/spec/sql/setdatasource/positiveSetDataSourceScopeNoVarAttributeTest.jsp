<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.sql.*, java.util.*,
                 javax.servlet.jsp.jstl.core.Config" %>

<tck:test testName="positiveSetDataSourceScopeNoVarAttributeTest">

   <!-- Validate when scope is specified and var is not the 
        javax.servlet.jsp.jstl.sql.dataSource attribute is set -->

   <h1>Validating sql:setDataSource action scope attributes </h1>
   <p>

   <sql:setDataSource
       dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
       scope='page'   />

     <sql:setDataSource
       dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
       scope='request'   />

    <sql:setDataSource
       dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
       scope='session'   />

     <sql:setDataSource
       dataSource='<%=(DataSource) pageContext.getAttribute("jstlDS", PageContext.APPLICATION_SCOPE) %>'
       scope='application'   />

   <%
        final String DS_VARNAME = "javax.servlet.jsp.jstl.sql.dataSource";
        Object pageScope = Config.get(pageContext, DS_VARNAME, PageContext.PAGE_SCOPE);
        Object requestScope = Config.get(pageContext, DS_VARNAME, PageContext.REQUEST_SCOPE);
        Object sessionScope = Config.get(pageContext, DS_VARNAME, PageContext.SESSION_SCOPE);
        Object applicationScope = Config.get(pageContext, DS_VARNAME, PageContext.APPLICATION_SCOPE);
	
        if (pageScope != null) {
            if (pageScope instanceof javax.sql.DataSource) {
                if (requestScope != null) {
                   if (requestScope instanceof javax.sql.DataSource) {
                       if (sessionScope != null) {
                           if (sessionScope instanceof javax.sql.DataSource) {
                               if (applicationScope != null) {
                                   if (applicationScope instanceof javax.sql.DataSource) {
                                       out.println("Test PASSED");
                                   } else {
                                       out.println("Test FAILED.  The javax.servlet.jsp.jstl.sql.dataSource attribute " +
                                                   "was set in the application scope, but was not an instance of javax.sql.DataSource.");
                                       out.println("Actual type: " + applicationScope.getClass().getName());
                                   }
                               } else {
                                   out.println("Test FAILED.  The javax.servlet.jsp.jstl.sql.dataSource attribute was not " +
                                               "set when sql:setDataSource was called when application scope was specified and var was not.");
                               }
                           } else {
                               out.println("Test FAILED.  The javax.servlet.jsp.jstl.sql.dataSource attribute " +
                                           "was set in the session scope, but was not an instance of javax.sql.DataSource.");
                               out.println("Actual type: " + sessionScope.getClass().getName());
                           }
                       } else {
                           out.println("Test FAILED.  The javax.servlet.jsp.jstl.sql.dataSource attribute was not " +
                                       "set when sql:setDataSource was called when session scope was specified and var was not.");
                       }
                   } else {
                       out.println("Test FAILED.  The javax.servlet.jsp.jstl.sql.dataSource attribute " +
                                   "was set in the request scope, but was not an instance of javax.sql.DataSource.");
                       out.println("Actual type: " + requestScope.getClass().getName());
                   }
               } else {
                   out.println("Test FAILED.  The javax.servlet.jsp.jstl.sql.dataSource attribute was not " +
                               "set when sql:setDataSource was called when request scope was specified and var was not.");
               }
           } else {
               out.println("Test FAILED.  The javax.servlet.jsp.jstl.sql.dataSource attribute " +
                           "was set in the page scope, but was not an instance of javax.sql.DataSource.");
               out.println("Actual type: " + requestScope.getClass().getName());
           }
       } else {
           out.println("Test FAILED.  The javax.servlet.jsp.jstl.sql.dataSource attribute was not " +
                       "set when sql:setDataSource was called when page scope was specified and var was not.");
       } 
   %>

   <%-- clean up --%>
   <c:remove var="javax.servlet.jsp.jstl.sql.dataSource" scope="request"/>
   <c:remove var="javax.servlet.jsp.jstl.sql.dataSource" scope="session"/>
   <c:remove var="javax.servlet.jsp.jstl.sql.dataSource" scope="application"/>

</tck:test>
