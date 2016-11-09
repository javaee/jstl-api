<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="negativeParseScopeVarSyntaxELTest">
    <!-- If scope is specified, and var is not, the TLV
              must flag this and generate a fatal translation error. -->
    <x:parse scope="page">
        <a>text</a>
    </x:parse>
</tck:test>
