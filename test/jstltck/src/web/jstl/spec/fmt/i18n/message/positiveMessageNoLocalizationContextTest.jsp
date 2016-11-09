<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.servlet.jsp.jstl.fmt.LocalizationContext" %>
<tck:test testName="positiveMessageNoLocalizationContextTest">
    <fmt:setBundle basename="nosuchbundle" var="bundle"/>

    <!-- If the I18N localization context that this action
             determines, does not have any resource bundle,
             an error message of teh form ???<key>??? is produced. -->

    Null LocalizationContext with null ResourceBundle provided:<br>
    <fmt:message bundle='<%= (LocalizationContext) pageContext.getAttribute("bundle") %>' key="mkey"/><br>

    Message wrapped by bundle action with a non existing ResourceBundle:<br>
    <fmt:bundle basename="nosuchbundle">
        <fmt:message key="mkey"/><br>
    </fmt:bundle>

    
    No ResourceBundle found based based on localizationContext variable.<br>
    <fmt:setBundle basename="nosuchbundle"/>
    <fmt:message key="mkey"/><br>
    <tck:config op="remove" configVar="localectx"/>

</tck:test>
