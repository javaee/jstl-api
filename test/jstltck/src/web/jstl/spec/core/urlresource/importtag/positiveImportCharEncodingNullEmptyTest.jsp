<%--
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveImportCharEncodingNullEmptyTest">
    <!-- If charEncoding is null or empty, the action will
             behave as if it wasn't specified. -->
    <c:import var="rorig" url="import.txt"/>
    <c:import var="rimp1" url="import.txt" charEncoding='<%= null %>'/>
    <c:import var="rimp2" url="import.txt" charEncoding=""/>

    <c:choose>
        <c:when test="${rorig == rimp1 && rorig == rimp2}">
            <pre>Test PASSED.  The result of the import with charEncoding
                 specified as null or empty, is the same as if it was
                 not specified.</pre>
        </c:when>
        <c:otherwise>
            <pre>Test FAILED.  The result of the import with charEncoding
                 specified as null or empty, is not the same as if it
                 was not specified
                 Not Specified: <c:out value="${rorig}" default="Nothing Imported"/>
                 Null: <c:out value="${rimp1}" default="Nothing Imported"/>
                 Empty: <c:out value="${rimp2}" default="Nothing Imported"/></pre>
        </c:otherwise>
    </c:choose>
</tck:test>
