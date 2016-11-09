<%--
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativePNScopeNoVarTest">
    <!-- If scope is specified and var is not, a fatal translation
             error occurs. -->
    <fmt:parseNumber value="1,234" scope="page"/>
</tck:test>
