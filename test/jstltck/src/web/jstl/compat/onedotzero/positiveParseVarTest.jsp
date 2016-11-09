<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="x_rt" uri="http://java.sun.com/jstl/xml_rt" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveParseVarTest">
    <!-- EL: The var attribute specifies the variable name with with
             to associate the parse result with in the PageContext.
             The type is implementation specific, so verify that it's
             an instance of java.lang.Object. -->
    <x:parse xml="<test>xmltext</test>" var="doc1"/>
    Exported var: <tck:isInstance varName="doc1" type="java.lang.Object"/>

    <!-- RT: The var attribute specifies the variable name with with
             to associate the parse result with in the PageContext.
             The type is implementation specific, so verify that it's
             an instance of java.lang.Object. -->
    <x_rt:parse xml="<test>xmltext</test>" var="rdoc1"/>
    Exported var: <tck:isInstance varName="rdoc1" type="java.lang.Object"/>
</tck:test>
