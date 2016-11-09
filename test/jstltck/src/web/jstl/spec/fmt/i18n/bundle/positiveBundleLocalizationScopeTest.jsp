<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveBundleLocalizationScopeTest">

    <!-- If the scope of the localization is limited to the
             scope of the bundle actions, body content.  A message 
             action outside the body will return ???<KEY>??? as its
             not a part of the context. -->
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources">
        Should be 'en message': <fmt:message key="mkey"/><br>
    </fmt:bundle>
    Should be ???mkey???: <fmt:message key="mkey"/><br>
</tck:test>
