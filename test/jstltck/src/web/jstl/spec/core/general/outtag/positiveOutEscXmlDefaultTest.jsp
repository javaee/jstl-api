<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveOutEscXmlDefaultTest">

    <!-- If escapeXml is not specified, the default
             value of 'true' is used -->
    XML entities should be escaped: <c:out value="< > ' \" &"/><br>
</tck:test>
