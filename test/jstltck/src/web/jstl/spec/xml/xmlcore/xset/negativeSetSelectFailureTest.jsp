<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeSetSelectFailureTest">

    <!-- If the XPath expression fails to evaluate properly, an
              instance of javax.servlet.jsp.JspException will be thrown. -->
    <tck:catch var="rex" exception="javax.servlet.jsp.JspException">
        <x:set select="$doc//a" var="set"/>
    </tck:catch>
    <c:out value="${rex}" default="Test FAILED"/>
</tck:test>
