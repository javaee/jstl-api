<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveCWOWhiteSpaceTest">
    <x:parse var="doc">
        <a attr="attrvalue">
            a-text
        </a>
    </x:parse>

    <!-- Validate that white space can appear anywhere around
             the nested when and otherwise actions nested within choose. -->
    <x:choose>

            <x:when select="$doc//a[@attr='attrvalue']">
                     Body content properly processed.<br>
            </x:when>   <x:when select="$doc//a[@attr='attrvalue']"></x:when><x:otherwise>
            
                  </x:otherwise>

    </x:choose>
</tck:test>
