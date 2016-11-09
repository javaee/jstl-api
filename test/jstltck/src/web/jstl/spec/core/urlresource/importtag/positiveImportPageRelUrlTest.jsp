<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveImportPageRelUrlTest">
    <!-- Import page relative content -->
    <c:import url="import.txt"/>
    <c:import var="notext" url="ResponseScCreated.jsp"/>
</tck:test>
