<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveMessageKeyNullEmptyTest">
    <fmt:bundle basename="com.sun.ts.tests.jstl.common.resources.Resources">

         <!-- If key is null or empty, ?????? is written to the current
                 JspWriter -->
        <fmt:message key='<%= null %>'/>
        <fmt:message key=""/>
    </fmt:bundle>
</tck:test>
