<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveImportVarTest">
    <!-- Validate 'var' attribute -->
    <c:import url="import.txt" var="rImportVar"/>
    <c:out value="${rImportVar}"/>
</tck:test>
