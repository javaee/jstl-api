<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeParseDocNullEmptyTest">

    <!-- If the doc attribute value is null or emtpy,
              a JspException is thrown. -->
    <tck:catch var="rex1" exception="javax.servlet.jsp.JspException"><br>
        <x:parse var="doc" doc="${null}"/>
    </tck:catch>
    <c:out value="${rex1}" default="Test FAILED" escapeXml="false"/><br>
    
    <tck:catch var="rex2" exception="javax.servlet.jsp.JspException">
        <x:parse var="doc" doc=""/>
    </tck:catch>
    <c:out value="${rex2}" default="Test FAILED" escapeXml="false"/>
</tck:test>
