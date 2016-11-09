<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveTransformBodyXmlParamsTest">
    <c:import var="xsl" url="param.xsl"/>

    <!-- Validate the transform action is able to parse
             an XML document provided as body content to the
             action, including the existence of nested x:param
             subtags. -->
    <x:transform xslt='<%= (String) pageContext.getAttribute("xsl") %>'>
        <elemental>THIS SHOULD BE REPLACED</elemental>
        <x:param name="fsize" value="11pt"/>
        <x:param name="message" value="Paramter properly passed!"/>
    </x:transform><br>
</tck:test>
