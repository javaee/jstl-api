<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/nodecl" %>
<tck:test testName="positiveScriptFreeTlvNoDeclTest">
    <!-- Use a taglibrary with allowDeclarations set to false.
         and all other properties, allowExpressions, allowRTExpressions,
         and allowScriptlets are set to true.  Using expressions, RTExpressions,
         and scriptlets should not generate a translation error. -->
    <%
        out.println("Output from a scriptlet.<br>");
    %>
    <%= new String("Output from an expression.<br>").toString() %>
    <c_rt:out value='<%= new String("Output from an RTExpression") %>'/><br>
</tck:test>
