<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="x_rt" uri="http://java.sun.com/jstl/xml_rt" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveIfVarTest">
    <x:parse var="doc">
        <a attr="attribute">text</a>
    </x:parse>
    <!-- EL: If var is specified, the result of the test condition
             is stored in the specified variable name. The type of 
             the exported var is java.lang.Boolean. -->
    XPath expression will evaluate to true, exported var should evaluate to true.<br>
    Body content should be processed.<br>
    <x:if select="$doc//a[name(@attr)]" var="tResult">
        XPath expression evaluated to true.<br>
    </x:if>
    <tck:isInstance varName="tResult" type="java.lang.Boolean"/>
    Var is: <c:out value="${tResult}" default="Test FAILED"/><br><br>

    XPath expression will evaluate to false, exported var should evaluate to false.<br>
    Body content should be not be processed.<br>
    <x:if select="$doc//b" var="fResult">
        XPath expression evaluated to true.<br>
    </x:if>
    <tck:isInstance varName="fResult" type="java.lang.Boolean"/>
    Var is: <c:out value="${fResult}" default="Test FAILED"/><br><br>

    <!-- An empty body is also valid for x:if.  -->
    If tag with an empty body and var is specified.<br>
    XPath expression will evaluated to true, exported var should evaluate to true.<br>
    <x:if select="$doc//a[name(@attr)]" var="etResult"/>
    <tck:isInstance varName="etResult" type="java.lang.Boolean"/>
    Var is: <c:out value="${etResult}" default="Test FAILED"/><br><br>
    
    If tag with an empty body and var is specified.<br>
    XPath expression will evaluate to false, expored var should evaluated to false.<br>
    <x:if select="$doc//b" var="efResult"/>
    <tck:isInstance varName="efResult" type="java.lang.Boolean"/>
    Var is: <c:out value="${efResult}" default="Test FAILED"/><br><br>

    <!-- RT: If var is specified, the result of the test condition
             is stored in the specified variable name. The type of 
             the exported var is java.lang.Boolean. -->
    XPath expression will evaluate to true, exported var should evaluate to true.<br>
    Body content should be processed.<br>
    <x_rt:if select="$doc//a[name(@attr)]" var="rtResult">
        XPath expression evaluated to true.<br>
    </x_rt:if>
    <tck:isInstance varName="rtResult" type="java.lang.Boolean"/>
    Var is: <c:out value="${tResult}" default="Test FAILED"/><br><br>

    XPath expression will evaluate to false, exported var should evaluate to false.<br>
    Body content should be not be processed.<br>
    <x_rt:if select="$doc//b" var="rfResult">
        XPath expression evaluated to true.<br>
    </x_rt:if>
    <tck:isInstance varName="rtResult" type="java.lang.Boolean"/>
    Var is: <c:out value="${fResult}" default="Test FAILED"/><br><br>

    <!-- An empty body is also valid for x:if.  -->
    If tag with an empty body and var is specified.<br>
    XPath expression will evaluated to true, exported var should evaluate to true.<br>
    <x_rt:if select="$doc//a[name(@attr)]" var="retResult"/>
    <tck:isInstance varName="retResult" type="java.lang.Boolean"/>
    Var is: <c:out value="${etResult}" default="Test FAILED"/><br><br>
    
    If tag with an empty body and var is specified.<br>
    XPath expression will evaluate to false, expored var should evaluated to false.<br>
    <x_rt:if select="$doc//b" var="efResult"/>
    <tck:isInstance varName="refResult" type="java.lang.Boolean"/>
    Var is: <c:out value="${efResult}" default="Test FAILED"/><br><br>
</tck:test>
