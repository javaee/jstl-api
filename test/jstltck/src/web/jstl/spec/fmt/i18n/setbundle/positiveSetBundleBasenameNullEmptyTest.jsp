<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.servlet.jsp.jstl.fmt.LocalizationContext" %>
<tck:test testName="positiveSetBundleBasenameNullEmptyTest">

    <!-- If basename is null or empty, the LocalizationContext
             ResourceBundle will be null. -->
   <fmt:setBundle basename='<%= null %>' var="bundle2"/>
   <c:if test="${bundle2.resourceBundle == null}">
        <c:out value="LocalizationContext is null.  Test PASSED"/>
   </c:if>

    <fmt:setBundle basename="" var="bundle3"/>
    <c:if test="${bundle3.resourceBundle == null}">
        <c:out value="LocalizationContext is null.  Test PASSED"/>
    </c:if>
</tck:test>
