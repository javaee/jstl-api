<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveSetScopeTest">
    <x:parse var="doc">
        <a>text</a>
    </x:parse>

    <!-- The scope attribute specifies the scope into which var
             is exported.  If scope is not specified, var will 
             be exported to the page scope by default. -->
    <x:set var="riPage" select="$doc//a"/>
    <x:set var="rePage" select="$doc//a" scope="page"/>
    <x:set var="reRequest" select="$doc//a" scope="request"/>
    <x:set var="reSession" select="$doc//a" scope="session"/>
    <x:set var="reApplication" select="$doc//a" scope="application"/>
    <tck:checkScope varName="riPage"/>
    <tck:checkScope varName="rePage"/>
    <tck:checkScope varName="reRequest" inScope="request"/>
    <tck:checkScope varName="reSession" inScope="session"/>
    <tck:checkScope varName="reApplication" inScope="application"/>
    <c:remove var="reApplication" scope="application"/>
</tck:test>
