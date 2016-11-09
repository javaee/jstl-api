<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveJavaToXPathTypesTest">
    <%
        Integer n = new Integer(1);
        Boolean b = new Boolean(true);
        pageContext.setAttribute("jInteger", n);
        pageContext.setAttribute("jBoolean", b);
    %>  
    <c:set var="jString" value="name"/>
    <x:parse var="doc">
        <stuff>
            <node1>
                <person>
                    <name>text from first node set</name>
                </person>
            </node1>
            <node2>
                <person>
                    <name>text from seconde node set</name>
                </person>
            </node2>
        </stuff>
    </x:parse>
    <x:set select="$doc//node1" var="nodes"/>

    <!-- An XPath variable must support the following mappings
             from Java to XPath types:
                Java                   XPath
              java.lang.Boolean       boolean
              java.lang.Number        number
              java.lang.String        string
              Object exported by      node-set
              parse, set, or forEach
    -->
    Node-set variable: <x:out select="$nodes/person/name"/><br>
    Node-set variable: <x:out select="$nodes//name"/><br>
    Boolean variable: <x:out select="boolean($pageScope:jBoolean)"/><br>
    Integer variable: <x:out select="number($pageScope:jInteger)"/><br>
    String variable: <x:out select="string($pageScope:jString)"/>
</tck:test>
