<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveParamBodyValueTest">

    <!-- the value of the param can be specified in the body of the param
             action -->
    <c:import url="import.jsp">
        <c:param name="testparm">
            testvalue
        </c:param>
        <c:param name="testparm2">
            testvalue2
        </c:param>
    </c:import>
</tck:test>
