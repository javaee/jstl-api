<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeCWOWhenBeforeOtherwiseRTTest">
    <!-- When must appear before an otherwise action,
             and otherwise must be the last nested action
             if present, otherwise a fatal translation error
             will occur. -->
    <c:choose>
        <c:otherwise>
            Body improperly processed.<br>
        </c:otherwise>
        <c:when test='<%= true %>'>
            Body content improperly processed.<br>
        </c:when>
    </c:choose>
</tck:test>
