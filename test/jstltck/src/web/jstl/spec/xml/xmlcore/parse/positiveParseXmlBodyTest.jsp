<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveParseXmlBodyTest">

    <!-- The XML to parse can be provided as body content to the action -->
    <x:parse var="doc">
        <test>xmltext</test>
    </x:parse>
    <x:parse varDom="dom">
        <test>xmltext</test>
    </x:parse>
    Doc: <x:out select="$doc//test"/><br>
    Dom: <x:out select="$dom//test"/><br>
</tck:test>
