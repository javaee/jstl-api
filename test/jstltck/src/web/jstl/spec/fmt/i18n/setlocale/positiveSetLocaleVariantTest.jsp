<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveSetLocaleVariantTest">
    <c:set var="loc" value="EURO"/>

    <!-- Test the tags acceptance of dynamic and static values -->
    <fmt:setLocale value="en_IE" variant='<%= (String) pageContext.getAttribute("loc") %>'/>
    <tck:config op="get" var="gLoc" configVar="locale"/>
    <c:out value="${gLoc}" default="Test FAILED"/>
    <fmt:setLocale value="en_IE" variant="EURO"/>
    <tck:config op="get" var="gLoc" configVar="locale"/>
    <c:out value="${gLoc}" default="Test FAILED"/>
</tck:test>
