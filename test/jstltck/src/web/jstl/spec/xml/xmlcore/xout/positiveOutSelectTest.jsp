<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveOutSelectTest">
    <x:parse var="doc">
        <a>
          <b>text</b>
        </a>
    </x:parse>

    <!-- The select attribute specifies the XPath expression to evaluate -->
    XPath result should be 'text': <x:out select="$doc//b"/><br>
</tck:test>
