<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positivePNParseLocaleNullEmptyTest">
    <fmt:setLocale value="en-US"/>

    <!-- if parseLocale is null or empty, it is treated as if
             not specified. The locale configuration variable should be used.-->
    <fmt:parseNumber value="1,234" parseLocale='<%= null %>'/>
    <fmt:parseNumber value="1,234" parseLocale=""/>
</tck:test>
