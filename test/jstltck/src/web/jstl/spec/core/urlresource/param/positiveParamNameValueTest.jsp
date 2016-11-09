<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveParamNameValueTest">
    <c:set var="pname" value="testparm"/>
    <c:set var="pvalue" value="parmvalue"/>

    <!-- Validate the acceptance of RT and static values -->
    <c:import url="import.jsp">
        <c:param name='<%= (String) pageContext.getAttribute("pname") %>'
                    value='<%= (String) pageContext.getAttribute("pvalue") %>'/>
        <c:param name="testparm2" value="parmvalue2"/>
    </c:import>
</tck:test>
