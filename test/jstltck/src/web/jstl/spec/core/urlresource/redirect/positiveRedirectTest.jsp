<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page session="false" %>
<tck:test testName="positiveRedirectTest">
    <c:set var="eUrl" value="/urlresource/param/import.jsp"/>
    <c:set var="rUrl" value="import.jsp"/>
    <c:set var="ctx" value="/jstl_core_web"/>

    <!-- Validate that redirects properly occur when the url attribute
             is provided or if url and context are specified. -->
    <c:if test="${param.rt1 != null}">
        <c:redirect url='<%= (String) pageContext.getAttribute("eUrl") %>'/>
    </c:if>
    <c:if test="${param.rt2 != null}">
        <c:redirect url="/urlresource/param/import.jsp"/>
    </c:if>
    <!-- Page-relative paths -->
    <c:if test="${param.rt3 != null}">
        <c:redirect url='<%= (String) pageContext.getAttribute("rUrl") %>'/>
    </c:if>
    <c:if test="${param.rt4 != null}">
        <c:redirect url="import.jsp"/>
    </c:if>
    <!-- Foreign context -->
    <c:if test="${param.rt5 != null}">
        <c:redirect url='<%= (String) pageContext.getAttribute("eUrl") %>'
                    context='<%= (String) pageContext.getAttribute("ctx") %>'/>
    </c:if>
    <c:if test="${param.rt6 != null}">
        <c:redirect url="/urlresource/param/import.jsp" context="/jstl_core_web"/>
    </c:if>
</tck:test>
