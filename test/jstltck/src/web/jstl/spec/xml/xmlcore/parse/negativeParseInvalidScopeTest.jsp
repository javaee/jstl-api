<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeParseInvalidScopeRTTest">
    <!-- An invalid value provided to the scope attribute should
             result in a fatal tranlation error. -->
    <x:parse var="doc" scope="invalid">
        <a>text</a>
    </x:parse>
</tck:test>
