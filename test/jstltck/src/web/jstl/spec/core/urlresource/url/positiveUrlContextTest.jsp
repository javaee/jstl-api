<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page session="false" %>
<tck:test testName="positiveUrlContextTest">
    <c:set var="ctx" value="/jstltck-fmt"/>

    <!-- The context attribute specifies the context
             of the relative URL resource. -->
    <c:url value="/jstl/core/fmt/non.jsp"
              context='<%= (String) pageContext.getAttribute("ctx") %>'/>
    <c:url value="/jstl/core/urlresource/importtag/import.txt"
           context="/jstltck-core"/>      
</tck:test>
