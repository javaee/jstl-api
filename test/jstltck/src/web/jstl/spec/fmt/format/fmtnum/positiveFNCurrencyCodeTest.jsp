<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveFNCurrencyCodeTest">
    <c:set var="code" value="USD"/>
    <fmt:setLocale value="en_US"/>
    <tck:checkRuntime var="is14"/>

    <!-- currency code specifies the currency code to be applied
             when formatting currencies.  The currency code will only
             be applied when type is currency -->
    <fmt:formatNumber value="123456789" currencyCode="USD"/>
    <fmt:formatNumber value="123456789" type="number" currencyCode="USD"/>
    <fmt:formatNumber value="123456789" type="percent" currencyCode="USD"/>
    <!-- Special handling is required with currencyCode as the 
         behavior changes depending on the runtime.  So the resulting
         value will not be displayed. -->
    <fmt:formatNumber value="123456789" var="rtRes" type="currency" currencyCode='<%= (String) pageContext.getAttribute("code") %>'/>
    <c:choose>
        <c:when test="${is14}">
            <% 
                String val = (String) pageContext.getAttribute("rtRes");
                if (val.equals("$123,456,789.00")) {
                    out.println("Value properly formatted as a currency.");
                } else {
                    out.println("Value not properly formatted as a currency.");
                    out.println("Expected: $123,456,789.00");
                    out.println("Received: " + val);
                }
            %>
        </c:when>
        <c:otherwise>
            <%
                String val = (String) pageContext.getAttribute("rtRes");
                if (val.equals("USD123,456,789.00")) {
                    out.println("Value properly formatted as a currency.");
                } else {
                    out.println("Value not properly formatted as a currency.");
                    out.println("Expected: USD123,456,789.00");
                    out.println("Received: " + val);
                }
            %>
        </c:otherwise>
    </c:choose>
</tck:test>
