<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveVarStatusTest">
    <%
        String[] sArray = { "one", "two", "three" };
        pageContext.setAttribute("status", "val");
        pageContext.setAttribute("rstatus", "rval");
    %>
    <!-- check varStatusSupport -->
    <tck:displayType varName="rstatus"/>
    <c:forEach varStatus="rstatus"
                  items='<%= sArray %>'>
        <tck:isInstance varName="rstatus" type="javax.servlet.jsp.jstl.core.LoopTagStatus"/>
    </c:forEach>
    <tck:checkScope varName="rstatus"/>

</tck:test>
