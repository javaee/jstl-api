<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveBundleBasenameNullEmptyTest">

    <!-- If basename is null or empty, the resource bundle is
             treated as non-existent, causing any message key lookups
             to fail with "???<keyname>???" -->
    <fmt:bundle basename='<%= null %>'>
        <fmt:message key="nullval"/>
    </fmt:bundle>
    <fmt:bundle basename="">
        <fmt:message key="emptyval"/>
    </fmt:bundle>
</tck:test>
