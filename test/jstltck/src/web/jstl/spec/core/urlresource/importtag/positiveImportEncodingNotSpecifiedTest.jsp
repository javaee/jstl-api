<%--
   Copyright 2003 Sun Microsystems, Inc.  All rights reserved.
   SUN PROPRIETARY/CONFIDENTIAL.  Use is subject license terms.
--%>

<%@ page contentType="text/plain" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- If encoding is not specified, then use the encoding specfied
     in the response. In this case, the response will be UTF-16. --%>

<c:import url="encoding/Encoding.jsp"/>

<%-- If encoding is not specified, and no encoding is specified in the
     response of the imported resource, the default of ISO-8859-1
     will be used. --%>

<c:import url="import-encoded.txt"/>
