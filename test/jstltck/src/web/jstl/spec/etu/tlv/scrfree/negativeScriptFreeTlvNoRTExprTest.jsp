<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/nortexpr" %>
<tck:test testName="negativeScriptFreeTlvNoRTExprTest">
    <!-- The tck taglib has allowRTExressions set to false.  The
         presense of an RT expression should generate a translation error. -->
    <c_rt:out value='<%= "Should not be translated" %>' />
</tck:test>
