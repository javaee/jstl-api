<%--
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveTransformXsltSystemIdTest">
    <tck:localAbsUrl var="exUrl" path="/jstl_xml_xform_web/import.xsl"/>
    <c:import url="simple.xml" var="xmlDoc"/>
    <c:import url="import.xsl" var="externXsl"/>

    <!-- The presence of xmlSystemId should cause the transform
             action to resolve external entities. -->
    Result should display node types of the provided XML document:<br>
    <x:transform doc='<%= pageContext.getAttribute("xmlDoc") %>'
                    xslt='<%= pageContext.getAttribute("externXsl") %>'
                    xsltSystemId='<%= (String) pageContext.getAttribute("exUrl") %>'/><br>
</tck:test>
