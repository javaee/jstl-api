<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveVarStatusTest">
    <!-- validate RT tag support of varStatus -->
    <c:forTokens items="a*b" delims="*" varStatus="rStatus">
        <tck:isInstance varName="rStatus" type="javax.servlet.jsp.jstl.core.LoopTagStatus"/>
    </c:forTokens>
    
</tck:test>
