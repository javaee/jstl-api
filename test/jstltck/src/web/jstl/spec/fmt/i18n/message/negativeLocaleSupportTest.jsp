<%-- 
 Copyright 2004 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.servlet.jsp.jstl.fmt.LocaleSupport" %>

<tck:test testName="localSupportTest">
  <c:set var="base" value="com.sun.ts.tests.jstl.common.resources.InvalidResources"/>
  <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"/>
  
  <!-- nkey does not exist in com.sun.ts.tests.jstl.common.resources.Resources -->
  (pageContext,key):
  <%= LocaleSupport.getLocalizedMessage(pageContext, "nkey") %>
  
  <!-- base is invalid -->
  (pageContext,key,basename):
  <%= LocaleSupport.getLocalizedMessage(pageContext, "mkey", 
            (String) pageContext.getAttribute("base", PageContext.PAGE_SCOPE)) %>
  
  <!-- nkey does not exist in com.sun.ts.tests.jstl.common.resources.Resources -->
  (pageContext,key,args):
  <%= LocaleSupport.getLocalizedMessage(pageContext, "nkey", 
            new Object[] {"Monday", "Tuesday"} ) %>
  
  <!-- base is invalid -->
  (pageContext,key,args,basename):
  <%= LocaleSupport.getLocalizedMessage(pageContext, "pkey", 
            new Object[] {"Monday", "Tuesday"},
            (String) pageContext.getAttribute("base", PageContext.PAGE_SCOPE)) %>
</tck:test>
