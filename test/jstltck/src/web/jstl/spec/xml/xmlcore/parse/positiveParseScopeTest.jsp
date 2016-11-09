<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveParseScopeTest">

   <!-- The scope attribute specifies the scope into which
             var is exported.  If not specified, var is exported
             to the page scope by default. -->
   <x:parse doc="<test>xmltext</test>" var="riPageText"/>
   <x:parse doc="<test>xmltext</test>" var="rePageText" scope="page"/>
   <x:parse doc="<test>xmltext</test>" var="reRequestText" scope="request"/>
   <x:parse doc="<test>xmltext</test>" var="reSessionText" scope="session"/>
   <x:parse doc="<test>xmltext</test>" var="reApplicationText" scope="application"/>
   <tck:checkScope varName="riPageText"/>
   <tck:checkScope varName="rePageText"/>
   <tck:checkScope varName="reRequestText" inScope="request"/>
   <tck:checkScope varName="reSessionText" inScope="session"/>  
   <tck:checkScope varName="reApplicationText" inScope="application"/>
   <c:remove var="reApplicationText" scope="application"/> 
</tck:test>
