<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeSetTargetNullInvalidObjTest">
    <%
        pageContext.setAttribute("invalid", new Integer(1));
    %>
    <!-- If target is null or is not an instance of
             java.util.Map or JavaBean, a javax.servlet.jsp.JspException
             is thrown. -->
    Target is null:<br>
    <tck:catch var="rex" exception="javax.servlet.jsp.JspException">
        <c:set value="val1" property="somprop" target='<%= null %>'/>
    </tck:catch>
    <c:out value="${rex}" default="Test FAILED" escapeXml="false"/>

    Target is not a Map or Bean:<br>
    <tck:catch var="rex1" exception="javax.servlet.jsp.JspException">
        <c:set value="val1" property="someprop"
                  target='<%= (Integer) pageContext.getAttribute("invalid") %>'/>
    </tck:catch>
    <c:out value="${rex1}" default="Test FAILED" escapeXml="false"/>
</tck:test>
