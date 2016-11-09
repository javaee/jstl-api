<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/permitted" %>
<tck:test testName="negativePermittedTlvTest">
    <!-- core is not on the permitted list.  A fatail
         translation error should occur. -->
    <c:out value="Test FAILED"/><br>
</tck:test>
