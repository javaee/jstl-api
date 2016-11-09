<%--
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveTransformDocSystemIdTest">
    <tck:localAbsUrl var="exUrl" path="/jstl_xml_xform_web/import.xml"/>
    <c:import url="import.xml" var="externXml"/>
    <c:import url="simple.xsl" var="xslDoc"/>

    <!-- The presence of docSystemId should cause the transform
             action to resolve external entities. -->
    <x:transform doc='<%= pageContext.getAttribute("externXml") %>'
                    xslt='<%= pageContext.getAttribute("xslDoc") %>'
                    docSystemId='<%= (String) pageContext.getAttribute("exUrl") %>'/><br>

    <x:transform xslt='<%= pageContext.getAttribute("xslDoc") %>'
                    docSystemId='<%= (String) pageContext.getAttribute("exUrl") %>'>
        <?xml version="1.0"?>

        <!DOCTYPE import [
            <!ENTITY external SYSTEM "xfiles/resolve.xml">
        ]>
        <root>
            &external;
        </root>
    </x:transform><br>
</tck:test>
