<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveXPathToJavaTypesTest">
    <x:parse var="doc">
        <Server port="8005" shutdown="SHUTDOWN" debug="0">
            <GlobalNamingResources>
                <Environment name="simpleValue" type="java.lang.Integer" value="30"/>
                <Resource name="UserDatabase" auth="Container"
                    description="User database that can be updated and saved">
                </Resource>
                <ResourceParams name="UserDatabase">
                    <parameter>
                        <name>factory</name>
                        <value>some.factory</value>
                    </parameter>
                    <parameter>
                        <name>pathname</name>
                        <value>users.xml</value>
                    </parameter>
                </ResourceParams>
            </GlobalNamingResources>
        </Server>
    </x:parse>

    <!--  The variable defined by var will have different types
              dending on the XPath expression applied.
              The mapping is defined as follows:
              XPath      Java
              boolean    java.lang.Boolean
              number     java.lang.Number
              String     java.lang.String
              node-set   Implementation specified - will check java.lang.Object -->
    XPath expression: boolean(/Server/GlobalNamingResources/ResourceParams) - Result should be of type Boolean<br>
    <x:set var="reBool" select="boolean($doc/Server/GlobalNamingResources/ResourceParams)"/>
    Result: <tck:isInstance varName="reBool" type="java.lang.Boolean"/><br>
    XPath expression: count(/Server/GlobalNamingResources/ResourceParams) - Result should be of type Number<br>
    <x:set var="reNum" select="count($doc/Server/GlobalNamingResources/ResourceParams/parameter)"/>
    Result: <tck:isInstance varName="reNum" type="java.lang.Number"/><br>
    XPath expression: string($doc/*) - Result should be of type String<br>
    <x:set var="reStr" select="string($doc/*)"/>
    Result: <tck:isInstance varName="reStr" type="java.lang.String"/><br>
    XPath expression: $doc//parameter - Result should be a Node-Set of type java.lang.Object<br>
    <x:set var="reNode" select="$doc//parameter"/>
    Result: <tck:isInstance varName="reNode" type="java.lang.Object"/><br>
</tck:test>
