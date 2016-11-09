<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveNoItemsIterationTest">
    <!-- support of forEach with no 'items' attribute specified -->
    <c:forEach var="rVar" begin="1" end="2">
        <tck:displayType varName="rVar"/>
    </c:forEach>

</tck:test>
