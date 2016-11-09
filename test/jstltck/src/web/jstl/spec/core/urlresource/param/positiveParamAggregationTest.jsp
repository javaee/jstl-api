<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveParamAggregationTest">
    <!-- Validate request parameter aggregation -->
    <c:import url="import.jsp?testparm=origvalue">
        <c:param name="testparm" value="newvalue"/>
        <c:param name="testparm2" value="origvalue"/>
    </c:import>
</tck:test>
