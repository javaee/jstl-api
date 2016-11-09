<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positivePNIntegerOnlyTest">
    <fmt:setLocale value="en_US"/>

    <!-- if integerOnly is true, only the integer portion of the value
             is parsed. By default the entire value is parsed if integerOnly
             is not specified. -->
    Number: <fmt:parseNumber value="1,234.56"/>
    Number: <fmt:parseNumber value="1,234.56" integerOnly='<%= false %>'/>
    Number int only: <fmt:parseNumber value="1,234.56" integerOnly="true"/>
    Currency int only: <fmt:parseNumber value="$1,234.56" integerOnly="true" type="currency"/>
    Currency: <fmt:parseNumber value="$1,234.56" integerOnly="false" type="currency"/>
    <%--
      *** Commented out due to J2SE BugID: 4663985 ***
    Percent int only: <fmt:parseNumber value="150%" integerOnly="true" type="percent"/>
    Percent: <fmt:parseNumber value="150%" integerOnly="false" type="percent"/>
    --%>
</tck:test>
