<%--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveSetScopeTest">
    <!-- EL: Validate that the set action will properly export 
             var to the scope as specified by the scope attribute.
             Also verify that if scope is not specified, var is
             exported to the page scope by default. -->
    <c:set value="defaultPage" var="iPage"/>
    <c:set value="explicitPage" var="ePage" scope="page"/>
    <c:set value="explicitRequest" var="eRequest" scope="request"/>
    <c:set value="explicitSession" var="eSession" scope="session"/>
    <c:set value="explicitApplication" var="eApplication" scope="application"/>
    <tck:checkScope varName="iPage"/>
    <tck:checkScope varName="ePage"/>
    <tck:checkScope varName="eRequest" inScope="request"/>
    <tck:checkScope varName="eSession" inScope="session"/>
    <tck:checkScope varName="eApplication" inScope="application"/>
    <c:remove var="eApplication" scope="application"/>

    <!-- RT: Validate that the set action will properly export 
             var to the scope as specified by the scope attribute.
             Also verify that if scope is not specified, var is
             exported to the page scope by default. -->
    <c_rt:set value="defaultPage" var="iPage"/>
    <c_rt:set value="explicitPage" var="ePage" scope="page"/>
    <c_rt:set value="explicitRequest" var="eRequest" scope="request"/>
    <c_rt:set value="explicitSession" var="eSession" scope="session"/>
    <c_rt:set value="explicitApplication" var="eApplication" scope="application"/>
    <tck:checkScope varName="iPage"/>
    <tck:checkScope varName="ePage"/>
    <tck:checkScope varName="eRequest" inScope="request"/>
    <tck:checkScope varName="eSession" inScope="session"/>
    <tck:checkScope varName="eApplication" inScope="application"/>
    <c:remove var="eApplication" scope="application"/>
</tck:test>

