<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveImportAbsUrlTest">
    <tck:localAbsUrl var="aUrl" path="/jstl_core_url_import_web/import.txt"/>
    <!-- Import HTTP absolute URL -->
    <c:import url='<%= (String) pageContext.getAttribute("aUrl") %>'/>
</tck:test>
