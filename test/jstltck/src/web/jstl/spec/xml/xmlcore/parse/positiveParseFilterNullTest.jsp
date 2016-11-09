<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveParseFilterNullTest">

    <!-- If filter is null, no filtering is performed -->
    <x:parse doc="<test attr='value'>xmltext</test>" var="rdoc"/>
    Non-Filtered Results (both should yield 'xmltext'):<br>
    'Attr' attribute present: <x:out select="$rdoc/test[@attr]"/><br>
    Selection of test element: <x:out select="$rdoc//test"/><br>
    <x:parse doc="<test attr='value'>xmltext</test>" filter='<%= null %>' var="rfdoc"/>
    Filter attribute was provided a null value, there should be no<br>
    change in the displayed results (both should yield 'xmltext'):<br>
    'Attr' attribute present: <x:out select="$rfdoc/test[@attr]"/><br>
    Selection of test element: <x:out select="$rfdoc//test"/><br>
</tck:test>
