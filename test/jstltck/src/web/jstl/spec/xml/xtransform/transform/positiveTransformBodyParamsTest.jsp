<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveTransformBodyParamsTest">
    <c:import url="param.xsl" var="xsl"/>

    <!-- The transform action must accept x:param nested actions
             and provide these as parameters to the stylesheet. -->
    <x:transform doc="<a>REPLACE</a>" xslt='<%= (String) pageContext.getAttribute("xsl") %>'>
        <x:param name="message" value="RT Parameter properly passed!"/>
        <x:param name="fsize" value="15pt"/>
    </x:transform><br>
</tck:test>
