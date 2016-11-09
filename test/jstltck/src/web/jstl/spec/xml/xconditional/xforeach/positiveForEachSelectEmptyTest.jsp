<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveForEachSelectEmptyTest">

    <!-- If select is empty, no iteration is performed. -->
    <x:forEach select="">
        Body content improperly processed.<br>
    </x:forEach>
</tck:test>
