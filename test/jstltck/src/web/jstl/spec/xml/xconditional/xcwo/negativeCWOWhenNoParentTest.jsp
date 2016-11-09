<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeCWOWhenNoParentRTTest">
    <!-- A fatal translation error will occur if a when
              action doesn't have choose as an immediate parent. -->
    <x:when select="false()">
        Body content improperly processed.<br>
    </x:when>
</tck:test>
