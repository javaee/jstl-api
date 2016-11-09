<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/nortexpr" %>
<tck:test testName="positiveScriptFreeTlvNoRTExprTest">
    <!-- Use a taglibrary with allowRTExpressions set to false.
         and all other properties, allowExpressions, allowScriptlets,
         and allowDeclarations are set to true.  Using expressions, scriptlets,
         and declarations should not generate a translation error. -->
    <%= new String("Output from an Expression.<br>").toString() %>
    <%! int i = 0; %>
    <%
        out.println("Output from a scriptlet.<br>");
    %>
</tck:test>
