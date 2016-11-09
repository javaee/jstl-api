<%--
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.servlet.jsp.jstl.fmt.LocalizationContext" %>
<%!
    private void checkEncoding(PageContext context, HttpServletResponse response) {
        String charset = (String) context.getAttribute("javax.servlet.jsp.jstl.fmt.request.charset",
                                                       PageContext.SESSION_SCOPE);
        if (charset != null && charset.equals(response.getCharacterEncoding())) {
            response.addHeader("charset", "attribute set");
        }
    }
%>
<%@ page import="java.util.ResourceBundle" %>
<tck:test testName="positiveResponseSetCharEncodingAttrTest">

    <c:if test="${param.action == 'locale'}">
        <fmt:setLocale value="en"/>
        <% checkEncoding(pageContext, response); %>
        <c:remove var="javax.serlvet.jsp.jstl.fmt.request.charset" scope="session"/>
    </c:if>

    <c:if test="${param.action == 'bundle'}">
        <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources"/>
        <% checkEncoding(pageContext, response); %>
        <c:remove var="javax.serlvet.jsp.jstl.fmt.request.charset" scope="session"/>
    </c:if>

    <c:if test="${param.action == 'setbundle'}">
        <%-- Export to application scope for use with message tests --%>
        <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"
                       var="tBundle" scope="application"/>
        <% checkEncoding(pageContext, response); %>
        <c:remove var="javax.serlvet.jsp.jstl.fmt.request.charset" scope="session"/>
    </c:if>

    <c:if test="${param.action == 'message'}">
        <fmt:message key="mkey"
                        bundle='<%= (LocalizationContext) pageContext.getAttribute("tBundle", PageContext.APPLICATION_SCOPE) %>'/>
        <% checkEncoding(pageContext, response); %>
        <c:remove var="javax.servlet.jsp.jstl.fmt.request.charset" scope="session"/>
        <c:remove var="tBundle" scope="application"/>
    </c:if>

</tck:test>
