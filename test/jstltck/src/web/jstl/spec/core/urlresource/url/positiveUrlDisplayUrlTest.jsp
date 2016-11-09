<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveUrlDisplayUrlTest">

    <!-- Validate that if var is not specified, the resulting URL
             is written to the current JspWriter -->
    <c:url value="/jstltck-core/jstl"/>
</tck:test>
