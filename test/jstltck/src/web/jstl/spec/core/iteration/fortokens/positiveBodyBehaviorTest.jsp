<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveBodyBehaviorTest">

    <!-- Body behavior : Includes body content -->
    <c:forTokens items="a" delims=" ">
        Body Content
    </c:forTokens>
    <!-- Body behavior : Empty body -->
    <c:forTokens items="a" delims=" "></c:forTokens>
</tck:test>
