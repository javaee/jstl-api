<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveParamValueNullTest">

    <!-- If value is null, it is processed as an empty value -->
    <c:import url="import.jsp">
        <c:param name="testparm" value='<%= null %>'/>
        <c:param name="testparm2" value="value2"/>
    </c:import>
</tck:test>
