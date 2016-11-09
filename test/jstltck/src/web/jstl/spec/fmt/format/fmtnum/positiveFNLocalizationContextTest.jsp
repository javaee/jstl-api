<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveFNLocalizationContextTest">
    <fmt:setBundle basename="com.sun.ts.tests.jstl.common.resources.Resources1"/>

    <!-- Validate that the action is able to dermine the
             formatting locale based on the localizationContext configuration
             variable. -->
    <fmt:formatNumber value="1234"/>
    <fmt:formatNumber value="1234" type="currency"/>
    <fmt:formatNumber value="1234" type="percent"/>
</tck:test>
