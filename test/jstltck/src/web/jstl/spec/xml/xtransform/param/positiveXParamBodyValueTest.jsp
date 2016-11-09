<%--
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveXParamBodyValueTest">
    <tck:localAbsUrl var="aUrl" path="/jstl_xml_xformparam_web/param.xsl"/>
    <c:import var="xsl" url="${aUrl}"/>
    <c:set var="message" value="Param properly used"/>

    <!-- The x:param action can set the value of the parameter
             based on the provided body content. -->
    <x:transform xslt="${xsl}">
        <x:param name="message">
            <c:out value="${message}"/>
        </x:param><a>REPLACE</a>
        <x:param name="fsize">8pt</x:param>
    </x:transform>
</tck:test>
