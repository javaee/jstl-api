<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveMessageKeyNotFoundTest">
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources">

        <!-- if the specified key is not found in the ResourceBundle,
                 "???<keynam>??? will be written to the current JspWriter
                 where <keyname> is the unknown key -->
        <fmt:message key="nosuchkey"/>
    </fmt:bundle>
</tck:test>
