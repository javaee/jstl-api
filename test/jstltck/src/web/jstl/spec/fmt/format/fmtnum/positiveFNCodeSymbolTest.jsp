<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveFNCodeSymbolTest">
    <tck:checkRuntime var="is14"/>
    <fmt:setLocale value="en_US"/>

    <!--  If currencyCode and currencySymbol are both defined and
              the container's runtime is 1.4 or greater, currencyCode
              takes precedence over currencySymbol, otherwise, 
              currencySymbol takes precedence over currencyCode. -->
    <fmt:formatNumber value="1234" var="rtRes" type="currency" currencyCode="USD" currencySymbol="@"/>
    <c:choose>
        <c:when test="${is14}">
            <%
                String val = (String) pageContext.getAttribute("rtRes");
                if (val.equals("$1,234.00")) {
                    out.println("Value properly formatted as a currency.");
                } else {
                    out.println("Value not properly formatted as a currency.");
                    out.println("Expected: $1,234.00");
                    out.println("Received: " + val);
                }
            %>
        </c:when>
        <c:otherwise>
            <%
                String val = (String) pageContext.getAttribute("rtRes");
                if (val.equals("@1,234.00")) {
                    out.println("Value properly formatted as a currency.");
                } else {
                    out.println("Value not properly formatted as a currency.");
                    out.println("Expected: @1,234.00");
                    out.println("Received: " + val);
                }
            %>
        </c:otherwise>
    </c:choose>        
</tck:test>
