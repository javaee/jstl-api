<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="x_rt" uri="http://java.sun.com/jstl/xml_rt" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveXParamNameTest">
    <tck:localAbsUrl var="aUrl" path="/jstl_1_0_compat_web/param.xsl"/>
    <c:import var="xsl" url="${aUrl}"/>
    <c:set var="message" value="message"/>
    <c:set var="fsize" value="fsize"/>
    <!-- EL: Validate the name attribute of the x:param action.
             It must be able to accept both static and dynamic values. -->
    <x:transform xslt="${xsl}">
        <a>REPLACE</a>
        <x:param name="${message}" value="Param properly used"/>
        <x:param name="fsize" value="10pt"/>
    </x:transform>
    
    <br>
    
    <!-- RT: Validate the name attribute of the x:param action.
             It must be able to accept both static and dynamic values. -->
    <x:transform xslt="${xsl}">
        <x_rt:param name="message" value="Param properly used"/>
        <a>REPLACE</a>
        <x_rt:param name='<%= (String) pageContext.getAttribute("fsize") %>' value="10pt"/>
    </x:transform>
</tck:test>
