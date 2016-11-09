<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/noexpr" %>
<tck:test testName="negativeScriptFreeTlvNoExprTest">
    <!-- The tck taglib has allowExressions set to false.  The
         presense of an expression should generate a translation error. -->
    <%= new String("Shouldn't have translated.").toString() %>
</tck:test>
