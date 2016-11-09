<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveParamNameValueTest">
    <!-- EL: Validate the acceptance of EL and static values -->
    <c:set var="pname" value="testparm"/>
    <c:set var="pvalue" value="parmvalue"/>
    <c:import url="import.jsp">
        <c:param name="${pname}" value="${pvalue}"/>
        <c:param name="testparm2" value="parmvalue2"/>
    </c:import>

    <!-- RT: Validate the acceptance of RT and static values -->
    <c_rt:import url="import.jsp">
        <c_rt:param name='<%= (String) pageContext.getAttribute("pname") %>'
                    value='<%= (String) pageContext.getAttribute("pvalue") %>'/>
        <c_rt:param name="testparm2" value="parmvalue2"/>
    </c_rt:import>
</tck:test>
