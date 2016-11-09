<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveOutEscXmlTest">

    <!-- Validated the behavior of escapeXml by toggling the input values
         (RT and static values) -->
    escapeXml true: <c:out value="< > ' \" &" escapeXml='<%= true %>' default="Test FAILED"/><br>
    escapeXml false: <c:out value="< > ' \" &" escapeXml='<%= false %>' default="Test FAILED"/><br>
    escapeXml true: <c:out value="< > ' \" &" escapeXml="true" default="Test FAILED"/><br>
</tck:test>
