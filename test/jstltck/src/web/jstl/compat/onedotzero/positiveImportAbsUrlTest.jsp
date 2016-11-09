<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveImportAbsUrlTest">
    <tck:localAbsUrl var="aUrl" path="/jstl_1_0_compat_web/import.txt"/>
    <!-- EL: Import HTTP absolute URL -->
    <c:import url="${aUrl}"/>
    <!-- RT: Import HTTP absolute URL -->
    <c_rt:import url='<%= (String) pageContext.getAttribute("aUrl") %>'/>
</tck:test>
