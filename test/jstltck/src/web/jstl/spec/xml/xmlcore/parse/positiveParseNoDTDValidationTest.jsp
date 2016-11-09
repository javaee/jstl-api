<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveParseNoDTDValidationTest">

    <!-- No validation is performed against the provided XML
             document. -->
    No parsing exception shoud occur. Select should yield 'DATA':<br>
    <x:parse var="doc">
        <?xml version="1.0" encoding="UTF-8" ?>
        <!DOCTYPE test [
            <!ELEMENT test (docs)>
            <!ELEMENT docs EMPTY>
        ]>
        <test>
            <docs>DATA</docs>
        </test>
    </x:parse>
    <x:out select="$doc//docs"/><br>  
</tck:test>
