<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeCWOWhenSelectReqAttrRTTest">
    <!-- Validate that if the select attribute is not present, a
             fatal translation error occurs. -->
    <x:choose>
        <x:when>
            Body content improperly processed.<br>
        </x:when>
    </x:choose>
</tck:test>
