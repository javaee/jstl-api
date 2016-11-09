<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeCWOWhenBeforeOtherwiseRTTest">
    <!-- When must appear before an otherwise action,
             and otherwise must be the last nested action
             if present, otherwise a fatal translation error
             will occur. -->
    <x:choose>
        <x:otherwise>
            Body improperly processed.<br>
        </x:otherwise>
        <x:when select="true()">
            Body content improperly processed.<br>
        </x:when>
    </x:choose>
</tck:test>
