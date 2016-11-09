<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/nodecl" %>
<tck:test testName="negativeScriptFreeTlvNoDeclTest">
    <!-- The tck taglib has allowDeclartions set to false.  The
         presense of a declaration should generate a translation error. -->
    <%! String test = "Shouldn't have translated"; %>
</tck:test>
