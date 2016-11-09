<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeCWOWhenSelectReqAttrRTTest">
    <!-- RT: Validate that if the 'test' attribute is not present, a 
             fatal translation error occurs. -->
    <c:choose>
        <c:when>
            Body content improperly processed.<br>
        </c:when>
    </c:choose>
</tck:test>
