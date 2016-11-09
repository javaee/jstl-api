<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/noexpr" %>
<tck:test testName="positiveScriptFreeTlvNoExprTest">
    <!-- Use a taglibrary with allowExpressions set to false.
         and all other properties, allowDeclarations, allowRTExpressions,
         and allowScriptlets are set to true.  Using declarations, rtexpressios,
         and scriptlets should not generate a translation error. -->
    <%
        out.println("Output from a scriptlet.<br>");
    %>
    <%! int i = 0; %>
    <c_rt:out value='<%= new String("Output from an RTExpression") %>'/>
</tck:test>
