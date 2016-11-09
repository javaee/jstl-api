<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveMessageCompoundNoParamTest">
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources">

        <!-- If a message is compound and no params are provided,
                 the message is returned as is. -->
        <fmt:message key="pkey"/>
    </fmt:bundle>
</tck:test>
