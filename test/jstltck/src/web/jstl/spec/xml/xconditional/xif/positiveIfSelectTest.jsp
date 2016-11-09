<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveIfSelectTest">
    <x:parse var="doc">
        <a attr="attribute">text</a>
    </x:parse>

    <!-- If the Xpath expression evaluates to true, the body content
             of the action is written to the current JspWriter. -->
    <br><br>XPath expression will evaluate to true, body content should be displayed:<br>
    <x:if select="$doc//a[name(@attr)]">
        Test PASSED: Element with attr attribute exists.<br>
    </x:if>
    <br>XPath expression will evaluate to false, body content should not be displayed:<br>
    <x:if select="$doc//b">
        Test FAILS if this is displayed.<br>
    </x:if>
</tck:test>
