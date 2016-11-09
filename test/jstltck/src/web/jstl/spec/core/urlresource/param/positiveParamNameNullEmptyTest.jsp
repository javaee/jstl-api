<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveParamNameNullEmptyTest">
    <c:set var="eVar" value=""/>

    <!-- If the name atribute is null or empty, no action is performed. -->
    <c:import url="import.jsp">
        <c:param name='<%= null %>' value="value"/>
        <c:param name='<%= (String) pageContext.getAttribute("eVar") %>' value="value2"/>
    </c:import>
</tck:test>
