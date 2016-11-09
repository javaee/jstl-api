<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positivePNLocalizationContextTest">
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources1"/>

    <!-- Validate that the action is able to dermine the
             formatting locale based on the localizationContext configuration
             variable. -->
    <fmt:parseNumber value="1,234"/>
    <fmt:parseNumber value="$1,234.00" type="currency"/>
    <fmt:parseNumber value="1.5%" type="percent"/>
</tck:test>
