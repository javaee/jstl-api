<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fmt_rt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveMessageKeyTest">
    <c:set var="eKey" value="mkey"/>
    <!-- EL: Behavioral test for key attribute -->
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources">
        <!-- EL: Behavioral test for key attribute -->
        <fmt:message key="${eKey}"/>
        <fmt:message key="mkey"/>

        <!-- RT: Behavioral test for key attribute -->
        <fmt_rt:message key='<%= (String) pageContext.getAttribute("eKey") %>'/>
        <fmt_rt:message key="mkey"/>
    </fmt:bundle>
</tck:test>
