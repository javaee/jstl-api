<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveItemsPrimArrayTest">
    <%
        byte[] aByte = { (byte) 'a', (byte) 'b' };
        boolean[] aBoolean = { true, false };
        char[] aChar = { 'a', 'b' };
        short[] aShort = { (short) 1, (short) 2 };
        int[] aInt = { 1, 2 };
        long[] aLong = { 1L, 2L };
        float[] aFloat = { 1.0f, 2.0f };
        double[] aDouble = { 1.0d, 2.0d };
        Object[] holder = { aByte, aBoolean, aChar, aShort,
                            aInt, aLong, aFloat, aDouble };
    %>

    <!-- check support for primitive arrays -->
    <c:forEach var="rOuter" items='<%= holder %>'>
        <c:forEach var="rInner" items='<%= pageContext.getAttribute("rOuter") %>'>
            <tck:displayType varName="rInner"/><br>
            <c:out value="${rInner}" default="forEach Test FAILED"/><br>
        </c:forEach>
    </c:forEach>

</tck:test>
