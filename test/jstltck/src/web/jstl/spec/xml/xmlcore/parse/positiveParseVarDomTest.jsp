<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveParseVarDomTest">

    <!-- varDom specifies the name of the variable to associate
             the result of the parse operation within the PageContext.
             The type of the exported variable is org.w3c.dom.Document. -->
    <x:parse doc="<test>xmltext</test>" varDom="rdom1"/>
    Exported var: <tck:isInstance varName="rdom1" type="org.w3c.dom.Document"/>
    
</tck:test>
