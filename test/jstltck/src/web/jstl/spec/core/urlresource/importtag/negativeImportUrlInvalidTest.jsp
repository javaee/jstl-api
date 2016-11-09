<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeImportUrlInvalidTest">
    <c:set var="invalidUrl" value="htp:/index.html"/>

    <!-- If the URL provided to the url attribute is invalid,
             an instance of javax.servlet.jsp.JspException is thrown. -->
    <tck:catch var="ex" exception="javax.servlet.jsp.JspException">
        <c:import url='<%= (String) pageContext.getAttribute("invalidUrl") %>'/>
    </tck:catch>
    <c:out value="${ex}" default="Test FAILED" escapeXml="false"/>
</tck:test>
