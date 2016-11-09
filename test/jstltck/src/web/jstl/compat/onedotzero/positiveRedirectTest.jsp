<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page session="false" %>
<tck:test testName="positiveRedirectTest">
    <c:set var="eUrl" value="/jstl/core/urlresource/param/import.jsp"/>
    <c:set var="rUrl" value="import.jsp"/>
    <c:set var="ctx" value="/jstl_1_0_compat_web"/>
    <!-- EL: Validate that redirects properly occur when the url attribute
             is provided or if url and context are specified. -->
    <!-- Context-relative paths -->
    <c:if test="${param.el1 != null}">
        <c:redirect url="${eUrl}"/>
    </c:if>
    <c:if test="${param.el2 != null}">
        <c:redirect url="/jstl/core/urlresource/param/import.jsp"/>
    </c:if>
    <!-- Page-relative paths -->
    <c:if test="${param.el3 != null}">
        <c:redirect url="${rUrl}"/>
    </c:if>
    <c:if test="${param.el4 != null}">
        <c:redirect url="import.jsp"/>
    </c:if>
    <!-- Foreign context -->
    <c:if test="${param.el5 != null}">
        <c:redirect url="${eUrl}" context="${ctx}"/>
    </c:if>
    <c:if test="${param.el6 != null}">
        <c:redirect url="/jstl/core/urlresource/param/import.jsp" context="/jstl_1_0_compat_web"/>
    </c:if>

    <!-- RT: Validate that redirects properly occur when the url attribute
             is provided or if url and context are specified. -->
    <c:if test="${param.rt1 != null}">
        <c_rt:redirect url='<%= (String) pageContext.getAttribute("eUrl") %>'/>
    </c:if>
    <c:if test="${param.rt2 != null}">
        <c_rt:redirect url="/jstl/core/urlresource/param/import.jsp"/>
    </c:if>
    <!-- Page-relative paths -->
    <c:if test="${param.rt3 != null}">
        <c_rt:redirect url='<%= (String) pageContext.getAttribute("rUrl") %>'/>
    </c:if>
    <c:if test="${param.rt4 != null}">
        <c_rt:redirect url="import.jsp"/>
    </c:if>
    <!-- Foreign context -->
    <c:if test="${param.rt5 != null}">
        <c_rt:redirect url='<%= (String) pageContext.getAttribute("eUrl") %>' 
                    context='<%= (String) pageContext.getAttribute("ctx") %>'/>
    </c:if>
    <c:if test="${param.rt6 != null}">
        <c_rt:redirect url="/jstl/core/urlresource/param/import.jsp" context="/jstl_1_0_compat_web"/>
    </c:if>
</tck:test>
