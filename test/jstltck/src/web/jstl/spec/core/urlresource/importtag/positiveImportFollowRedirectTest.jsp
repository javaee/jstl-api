<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveImportFollowRedirectTest">
    <tck:localAbsUrl var="aUrl" path="/jstl_core_url_import_web/import.txt"/>

    <!-- When importing an external resource using the HTTP protocol,
             the action should follow the redirect and import the target resource. -->
    <c:import url='<%= (String) pageContext.getAttribute("aUrl") %>'/>
</tck:test>
