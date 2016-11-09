<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/noscr" %>
<tck:test testName="positiveScriptFreeTlvNoScrTest">
    <!-- Use a taglibrary with allowScriptlets set to false.
         and all other properties, allowExpressions, allowRTExpressions,
         and allowDeclarations are set to true.  Using expressions, rtexpressios,
         and declarations should not generate a translation error. -->
    <%= new String("Output from an Expression.<br>").toString() %>
    <%! int i = 0; %>
    <c_rt:out value='<%= new String("Output from an RTExpression") %>'/><br>
</tck:test>
