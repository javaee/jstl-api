<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="x_rt" uri="http://java.sun.com/jstl/xml_rt" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveTransformVarTest">
    <c:import url="simple2.xml" var="xmlDoc"/>
    <c:import url="simple2.xsl" var="xslDoc"/>
    <!-- EL: If var is specified, the result of the transformation
             will be export to the PageContext as an instance
             of org.w3c.dom.Document. -->
    <x:transform xml="${xmlDoc}" xslt="${xslDoc}" var="trans1"/>
    <tck:isInstance varName="trans1" type="org.w3c.dom.Document"/>
    
    <!-- RT: If var is specified, the result of the transformation
             will be export to the PageContext as an instance
             of org.w3c.dom.Document. -->
    <x_rt:transform xml='<%= pageContext.getAttribute("xmlDoc") %>' 
                    xslt='<%= pageContext.getAttribute("xslDoc") %>' var="trans2"/>
    <tck:isInstance varName="trans2" type="org.w3c.dom.Document"/>
</tck:test>
