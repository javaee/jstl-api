<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positivePNFallbackLocaleTest">
    <tck:config op="set" configVar="fallback" value="en-US"/>

    <!-- The fallbackLocale configuration variable will be
             used if no locale match can be determined. -->
    <fmt:parseNumber value="1,234"/>
    <fmt:parseNumber value="$1,234.00" type="currency"/>
    <fmt:parseNumber value="1.5%" type="percent"/>
</tck:test>
