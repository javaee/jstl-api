<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveParseScopeDomTest">

   <!-- The scopeDom attribute specifies the scope into which
             varDom is exported.  If not specified, varDom is exported
             to the page scope by default. -->
   <x:parse doc="<test>xmltext</test>" varDom="riPageText"/>
   <x:parse doc="<test>xmltext</test>" varDom="rePageText" scopeDom="page"/>
   <x:parse doc="<test>xmltext</test>" varDom="reRequestText" scopeDom="request"/>
   <x:parse doc="<test>xmltext</test>" varDom="reSessionText" scopeDom="session"/>
   <x:parse doc="<test>xmltext</test>" varDom="reApplicationText" scopeDom="application"/>
   <tck:checkScope varName="riPageText"/>
   <tck:checkScope varName="rePageText"/>
   <tck:checkScope varName="reRequestText" inScope="request"/>
   <tck:checkScope varName="reSessionText" inScope="session"/>  
   <tck:checkScope varName="reApplicationText" inScope="application"/>
   <c:remove var="reApplicationText" scope="application"/> 
</tck:test>
