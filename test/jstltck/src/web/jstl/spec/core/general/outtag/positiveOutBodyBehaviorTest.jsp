<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveOutBodyBehaviorTest">

    <!-- Validate that if value evaluates to null, the
             body content of the action is used as the default.  Also
             validate that an empty body is valid. -->
    <c:out value='<%= null %>' escapeXml="false">
        Default body<br>
    </c:out>
    <!-- An empty body is valid -->
    <c:out value='<%= null %>'></c:out>
</tck:test>
