<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveImportUrlTest">
    <%
        String url = "import.txt";
    %>
    <!-- Validate acceptance of RT values -->
    <c:import url='<%= url %>'/>
    <!-- Validate acceptance of static values -->
    <c:import url="import.txt"/>

</tck:test>
