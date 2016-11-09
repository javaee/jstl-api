<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeSetInvalidScopeRTTest">
    <x:parse var="doc">
        <a>text</a>
    </x:parse>
    <!-- RT: If scope is provided an invalid value, a fatal translation
             error will occur. -->
    <x:set select="$doc//a" scope="invalid"/>
</tck:test>
