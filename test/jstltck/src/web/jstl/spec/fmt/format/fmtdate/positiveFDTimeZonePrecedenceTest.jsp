<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.Date" %>
<tck:test testName="positiveFDTimeZonePrecedenceTest">
    <%  
        Date date = new Date(883192294202L);
        pageContext.setAttribute("dte", date);
    %>
    <fmt:setTimeZone value="EST"/>
    <fmt:setLocale value="en_US"/>

    <!--  The time zone to be used when formatting operates
              with the following order of presendence:
              - If timeZone specified, use that value.
              - If wrapped by a timeZone action, use that 
                value.
              - Use the value of the scoped attribute
                javax.servlet.jsp.jstl.fmt.timeZone. -->
    <br>TimeZone attribute specified with a value of PST:<br>
      Wrapped by &lt;fmt:timeZone&gt; action with MST.  Time should be 7:11:34 PM:<br>
      <fmt:timeZone value="MST">
        <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>' timeZone="PST" type="both"/><br>
      </fmt:timeZone>

      Not wrapped.  Page has a time zone of EST.  Time should be 7:11:34 PM<br>
      <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>' timeZone="PST" type="both"/><br>

    <br>No TimeZone attribute specified:<br>
      Wrapped by &lt;fmt:timeZone&gt; action with MST.  Time should be 8:11:34 PM:<br>
      <fmt:timeZone value="MST">
        <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>' type="both"/><br>
      </fmt:timeZone>

      Not wrapped.  Page has a time zone of EST.  Time should be 10:11:34 PM<br>
      <fmt:formatDate value='<%= (Date) pageContext.getAttribute("dte") %>' type="both"/><br>
    <br>
</tck:test>
