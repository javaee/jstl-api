<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeCWOWhenNoParentRTTest">
    <!-- A fatal translation error will occur if a when
              action doesn't have choose as an immediate parent. -->
    <c:when test='<%= false %>'>
        Body content improperly processed.<br>
    </c:when>
</tck:test>
