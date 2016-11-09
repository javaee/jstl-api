<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveSetSelectVarTest">
    <x:parse var="doc">
        <parent>
            <a>text</a>
        </parent>
    </x:parse>

    <!-- The select attribute specifies the XPath expression to be
             applied against a parsed object.  The result of the select
             will be exported to the PageContent and associated with the
             variable name specified by var. -->
    <x:set var="rxResult" select="$doc//parent"/>
    xResult should evaluated to 'text': <x:out select="$rxResult//a"/><br>
</tck:test>
