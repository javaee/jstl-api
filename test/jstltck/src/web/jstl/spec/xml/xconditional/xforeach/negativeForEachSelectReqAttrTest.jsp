<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeForEachSelectReqAttrRTTest">
    <!-- RT: If select is not present, a fatal translation error will 
             occur. -->
    <x:forEach>
        Body Content improperly processed.<br>
    </x:forEach>
</tck:test>
