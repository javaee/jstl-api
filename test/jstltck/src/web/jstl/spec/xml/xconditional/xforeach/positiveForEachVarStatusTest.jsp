<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveVarStatusTest">
    <%
        pageContext.setAttribute("rstatus", "rval");
    %>
     <x:parse var="doc">
        <a>
            <b>btext1</b>
            <b>btext2</b>
        </a>
    </x:parse>
    <!-- check varStatusSupport -->
    <tck:displayType varName="rstatus"/>
    <x:forEach varStatus="rstatus"
                  select="$doc//b">
        <tck:isInstance varName="rstatus" type="javax.servlet.jsp.jstl.core.LoopTagStatus"/>
    </x:forEach>
    <tck:checkScope varName="rstatus"/>

</tck:test>
