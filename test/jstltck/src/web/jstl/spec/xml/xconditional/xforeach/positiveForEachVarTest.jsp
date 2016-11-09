<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveVarForEachTest">
     <x:parse var="doc">
        <a>
            <b>btext1</b>
            <b>btext2</b>
        </a>
    </x:parse>

   <!-- If var is specified, a nested scoped variable is made availabe
             and signifies the current item of the iteration. The type of the
             nested var is dependent on the result of the XPath expression. -->
    The type of iter in this case is a node-set --> java.lang.Object<br>
    Two iterations should occur.<br>
    <c:set var="iter" value="nested var"/>
    <x:forEach var="iter" select="$doc//b">
        <tck:isInstance varName="iter" type="java.lang.Object"/>
        <x:out select="$iter"/><br>
    </x:forEach>
    <c:out value="${iter}" default="<strong>iter</strong> correctly removed after action completed" escapeXml="false"/>
</tck:test>
