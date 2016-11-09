<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativePNUnableToParseValueTest">

    <!-- If the action is unable to parse the String value provided
             when attempting to format it, an JspException is thrown, with
             unparsable value present in the exception text and the original
             exception as the root cause. -->
    <tck:catch var="rex" exception="javax.servlet.jsp.JspException" exceptionText="abcd"
               checkRootCause="true">
        <fmt:parseNumber value="abcd"/>
    </tck:catch>
    <c:out value="${rex}" default="Test FAILED" escapeXml="false"/>
</tck:test>
