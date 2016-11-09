<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveFNGroupingUsedTest">
    <fmt:setLocale value="en_US"/>

    <!-- groupingUsed behavior.  If not specifed, grouping
             will be used. -->
    <fmt:formatNumber value="123456789"/>
    <fmt:formatNumber value="123456789" groupingUsed='<%= true %>'/>
    <fmt:formatNumber value="123456789" groupingUsed="false"/>
    <fmt:formatNumber value="123456789" type="currency" groupingUsed="false"/>
    <fmt:formatNumber value="123456789" type="currency" groupingUsed="true"/>
    <fmt:formatNumber value="123456789" type="percent" groupingUsed="false"/>
    <fmt:formatNumber value="123456789" type="percent" groupingUsed="true"/>
</tck:test>
