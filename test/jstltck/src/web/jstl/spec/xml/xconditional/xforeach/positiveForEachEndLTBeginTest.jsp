<%--
   Copyright 2003 Sun Microsystems, Inc.  All rights reserved.
   SUN PROPRIETARY/CONFIDENTIAL.  Use is subject license terms.
--%>

<%@ page contentType="text/plain" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
 <x:parse var="doc">
        <a>
            <b>btext1</b>
            <b>btext2</b>
            <b>btext3</b>
            <b>btext4</b>
            <b>btext5</b>
            <b>btext6</b>
            <b>btext7</b>
        </a>
    </x:parse>
<x:forEach select="$doc//b" begin="2" end="1">
    Test FAILED
</x:forEach>
