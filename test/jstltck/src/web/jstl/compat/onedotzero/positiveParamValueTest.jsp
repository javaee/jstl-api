<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fmt_rt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveParamValueTest">
    <c:set var="val1" value="value1"/>
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources">
        <!-- EL: Behvioral test for value -->
        <fmt:message key="pkey">
            <fmt:param value="${val1}"/>
            <fmt:param value="value2"/>
        </fmt:message>

        <!-- RT: Behvioral test for value -->
        <fmt_rt:message key="pkey">
            <fmt_rt:param value='<%= (String) pageContext.getAttribute("val1") %>'/>
            <fmt_rt:param value="value2"/>
        </fmt_rt:message>
    </fmt:bundle>
</tck:test>
