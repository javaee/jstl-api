<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveSetBundleBasenameTest">
    <c:set var="base" value="com.sun.ts.tests.jstl.common.resources.Resources"/>

    <!-- The basename attribute provides the base resource bundle
             to be used when providing localized messages.  In this case,
             since var is not specified, the configuration variable 
             javax.servlet.jsp.jstl.fmt.localizationContext will be set
             with LocalizationContext that was initialized by the 
             ResourceBundle lookup algorithm. -->
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources"/>
    <tck:config op="get" var="ctx" configVar="localectx"/>
    <c:if test="${ctx != null}">
        Property LocalizationContext properly set.<br>
        Message: <fmt:message key="mkey"/><br>
    </c:if>
    <tck:config op="remove" configVar="localectx"/>

    <fmt:setBundle basename='<%= (String) pageContext.getAttribute("base") %>'/>
    <tck:config op="get" var="ctx" configVar="localectx"/>
    <c:if test="${ctx != null}">
        Property LocalizationContext properly set.<br>
        Message: <fmt:message key="mkey"/><br>
    </c:if>
    <tck:config op="remove" configVar="localectx"/>
</tck:test>
