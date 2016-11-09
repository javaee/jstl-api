<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/noscr" %>
<tck:test testName="negativeScriptFreeTlvNoScrTest">
    <!-- The tck taglib has allowScriptlets set to false.  The
         presense of a scriptlet should generate a translation error. -->
    <% String test = "Shouldn't have translated"; %>
</tck:test>
