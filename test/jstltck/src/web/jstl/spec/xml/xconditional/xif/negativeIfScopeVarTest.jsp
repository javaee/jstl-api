<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeIfScopeVarRTTest">
    <x:parse var="doc">
        <a>text</a>
    </x:parse>
    <!-- RT: If scope is specified and var is not, a translation error
             will occur. -->
    <x:if select="$doc//a" scope="page"/>
</tck:test>
