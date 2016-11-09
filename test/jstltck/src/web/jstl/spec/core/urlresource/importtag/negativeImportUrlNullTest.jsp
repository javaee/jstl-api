<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeImportUrlNullTest">
    <!-- If URL is null, a javax.servlet.jsp.JspException is thrown -->
    <tck:catch var="rex" exception="javax.servlet.jsp.JspException">
        <c:import url='<%= null %>'/>
    </tck:catch>
    <c:out value="${rex}" default="Test FAILED" escapeXml="false"/>
</tck:test>
