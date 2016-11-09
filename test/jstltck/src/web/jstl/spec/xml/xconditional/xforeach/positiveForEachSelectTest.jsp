<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveForEachSelectTest">
    <x:parse var="doc">
        <a>
            <b>btext1</b>
            <b>btext2</b>
        </a>
    </x:parse>

    <!-- The select attribute specifies an XPath expression, the result
             if which is iterated through by the action. -->
    Body content should be processed twice.<br>
    <x:forEach select="$doc//b">
        Body content correctly processed.<br>
    </x:forEach>
</tck:test>
