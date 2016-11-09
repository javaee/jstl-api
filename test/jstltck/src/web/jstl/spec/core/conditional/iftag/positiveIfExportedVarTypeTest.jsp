<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveExportedVarTypeTest">
    <%-- check type of var exported tag --%>
    <c:if test="true" var="var0"/>
    <tck:isInstance varName="var0" type="java.lang.Boolean"/>
</tck:test>
