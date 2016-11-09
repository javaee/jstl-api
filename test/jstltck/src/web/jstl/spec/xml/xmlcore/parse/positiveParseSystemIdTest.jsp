<%--
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveParseSystemIdTest">
    <tck:localAbsUrl var="id" path="/jstl_xml_parse_web/import.xml"/>
    <c:import url="import.xml" var="importedXml"/>

    <!-- Providing a SystemId will allow the resolution of
             external entities.  In this case, the imported XML
             document will have an external entity refereced
             at 'xmlfiles/resolve.xml'. -->
    Result of select against parsed document should be: 'Entity Resolved':<br>
    <x:parse doc='<%= (String) pageContext.getAttribute("importedXml") %>' var="rdoc"
                systemId='<%= (String) pageContext.getAttribute("id") %>'/>
    <x:out select="$rdoc//resolved"/><br>

    XML Document provided as text to body of parse:<br>
    Result of select against parsed document should be: 'Entity Resolved':<br>
    <x:parse var="rdoc1" systemId='<%= (String) pageContext.getAttribute("id") %>'>
        <?xml version="1.0"?>
        <!DOCTYPE root [
            <!ENTITY external SYSTEM "xfiles/resolve.xml">
        ]>
        <root>
            &external;
        </root>
    </x:parse>
    <x:out select="$rdoc1//resolved"/><br>
</tck:test>
