<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveIfScopeTest">
    <x:parse var="doc">
        <a attr="attribute">text</a>
    </x:parse>

    <!-- Validate the action properly exports var to the
             scope as specified by the scope attribute.  If
             scope is not specified, var will be exported to
             the page scope by default. -->
    <x:if select="$doc//b" var="riPage"/>
    <x:if select="$doc//b" var="rePage" scope="page">
        Shouldn't be displayed
    </x:if>
    <x:if select="$doc//a" var="reRequest" scope="request"/>
    <x:if select="$doc//b" var="reSession" scope="session">
        Shouldn't be displayed
    </x:if>
    <x:if select="$doc//a" var="reApplication" scope="application"/>
    <tck:checkScope varName="riPage"/>
    <tck:checkScope varName="rePage"/>
    <tck:checkScope varName="reRequest" inScope="request"/>
    <tck:checkScope varName="reSession" inScope="session"/>
    <tck:checkScope varName="reApplication" inScope="application"/>
    <c:remove var="reApplication" scope="application"/>
</tck:test>
