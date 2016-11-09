<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveImportBodyParamTest">
    <!-- Validate that action correctly imports resources
             with nested param subtags. -->
    <c:import url="import.jsp">
        <c:param name="testparm" value="value"/>
    </c:import>
</tck:test>
