<%--
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveTransformXmlAndXmlSystemIdTest">
    <tck:localAbsUrl var="exUrl" path="/jstl_xml_xform_web/import.xml"/>
    <c:import url="import.xml" var="externXml"/>
    <c:import url="simple.xsl" var="xslDoc"/>

    <%--  Validate that the xmlSystemId and xml attributes are still valid --%>
    <%-- Result should have 'Entity Resolved' wrapped by &lt;h4&gt; elements:   --%>
    <x:transform xml='<%= pageContext.getAttribute("externXml") %>'
                    xslt='<%= pageContext.getAttribute("xslDoc") %>'
                    xmlSystemId='<%= (String) pageContext.getAttribute("exUrl") %>'/><br>

    <%-- Result should have 'Entity Resolved' wrapped by &lt;h4&gt; elements: --%>
    <x:transform xslt='<%= pageContext.getAttribute("xslDoc") %>'
                    xmlSystemId='<%= (String) pageContext.getAttribute("exUrl") %>'>
        <?xml version="1.0"?>

        <!DOCTYPE import [
            <!ENTITY external SYSTEM "xfiles/resolve.xml">
        ]>
        <root>
            &external;
        </root>
    </x:transform><br>
</tck:test>
