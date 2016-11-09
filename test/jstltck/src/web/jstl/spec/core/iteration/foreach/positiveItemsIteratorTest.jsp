<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="java.util.HashSet,java.util.Iterator,java.util.ArrayList,java.util.Arrays" %>
<tck:test testName="positiveItemsIteratorTest">
    <%
        ArrayList lTest = new ArrayList();
        ArrayList lControl = new ArrayList();

        HashSet hSet = new HashSet();
        hSet.add("val1");
        hSet.add("val2");
        hSet.add("var3");
        hSet.add("var4");
        pageContext.setAttribute("hashSet", hSet.iterator());
        for (Iterator rIter = hSet.iterator(); rIter.hasNext(); ) {
            lControl.add(rIter.next());
        }

    %>
    <!-- RT: check for support if iteration via a passed Iterator -->
    <c:forEach var="rVar" items='<%= hSet.iterator() %>'>
        <%
              lTest.add(pageContext.findAttribute("rVar"));
        %>
    </c:forEach>

    <%
        String[] test =
            (String[]) lTest.toArray(new String[lTest.size()]);
        String[] control =
            (String[]) lControl.toArray(new String[lControl.size()]);

        Arrays.sort(test);
        Arrays.sort(control);

        if (!Arrays.equals(test, control)) {
            out.println("Test FAILED.  Iteration produced unexpected results.");
            out.println("Expected values:");
            for (int i = 0; i < control.length; i++) {
                out.println('\t' + control[i]);
            }
            out.println("Values received:");
            for (int i = 0; i < test.length; i++) {
                out.println('\t' + test[i]);
            }
        }

    %>

</tck:test>
