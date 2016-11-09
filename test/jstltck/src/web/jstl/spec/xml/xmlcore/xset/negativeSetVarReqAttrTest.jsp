<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeSetVarReqAttrRTTest">
    <x:parse var="doc">
        <a>text</a>
    </x:parse>
    <!-- If var is not specified, a fatal translation error will occur. -->
    <x:set select="$doc//a"/>
</tck:test>
