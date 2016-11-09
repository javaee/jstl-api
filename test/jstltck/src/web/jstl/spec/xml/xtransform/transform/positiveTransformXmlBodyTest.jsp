<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveTransformXmlBodyTest">
    <c:import url="simple.xsl" var="xsl"/>

    <%-- The transform action must be able to parse XML provided
             as body content and transform the parsed result using
             the specified stylesheet. --%>
    <x:transform xslt='<%= (String) pageContext.getAttribute("xsl") %>'>
        <ele>
            <somele>element text</somele>
        </ele>
    </x:transform>
</tck:test>
