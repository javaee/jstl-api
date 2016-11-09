<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeCWOOtherwiseNoParentRTTest">
    <!-- If otherwise doesn't have choose an an immediate parent,
             a fatal translation error will occur. -->
    <x:otherwise>
        Body content improperly processed.<br>
    </x:otherwise>
</tck:test>
