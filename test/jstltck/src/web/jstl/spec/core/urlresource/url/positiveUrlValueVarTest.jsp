<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveUrlValueVarTest">

     <!-- validate that the url action's url attribute can accept
             both RT and dynamic values. Validate that the returned
             value is the same as that returned by response.encodeURL() -->
     <c:url var="rtVal" value='<%= "/rewrite" %>'/>
     <c:url var="rtsVal" value="/rewrite"/>
     <%
        String encodeVal = response.encodeURL("/jstl_core_url_web/rewrite");
        String rtValue = (String) pageContext.getAttribute("rtVal");
        String rtsValue = (String) pageContext.getAttribute("rtsVal");
        if (rtValue.equals(encodeVal) && rtsValue.equals(encodeVal)) {
            out.println("The &lt;c:url&gt; action returned expected value.<br>");
        } else {
            out.println("The &lt;c:url&gt; action returned value different from that " +
                        "returned by response.encodeUrl()!<br>");
            out.println("From url action: " + rtValue);
            out.println("From encodeURL: " + encodeVal);
        }
     %>
</tck:test>
