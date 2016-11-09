<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveTimezoneVarTest">

    <!-- Timezone can be exported for use by other actions.
             Type should be java.util.Timezone -->
    <fmt:setTimeZone value="PST" var="rtz"/>
    <tck:isInstance varName="rtz" type="java.util.TimeZone"/>
</tck:test>
