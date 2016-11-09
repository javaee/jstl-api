<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveFNFallbackLocaleTest">
    <tck:config op="set" configVar="fallback" value="en-US"/>

    <!-- The fallbackLocale configuration variable will be
             used if no locale match can be determined. -->
    <fmt:formatNumber value="1234"/>
    <fmt:formatNumber value="1234" type="currency"/>
    <fmt:formatNumber value="1234" type="percent"/>
</tck:test>
