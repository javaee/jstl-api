<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveItemsStepTest">
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
    <!-- support of 'step' attribute with items - step = 2 : dynamic -->
    <x:forEach var="eVar" select="$doc//b" step='<%= 2 %>'>
        <x:out select="$eVar"/>
    </x:forEach>

</tck:test>
