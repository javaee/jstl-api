<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<%@ page import="javax.servlet.jsp.jstl.core.Config" %>
<tck:test testName="positiveConfigStaticMemberTest">
    <!-- Validate the following static members of the Config class:
              - FMT_LOCALE
              - FMT_FALLBACK_LOCALE
              - FMT_LOCALIZATION_CONTEXT
              - FMT_TIME_ZONE
              - SQL_DATA_SOURCE
              - SQL_MAX_ROWS -->

    <%
        if (Config.FMT_LOCALE.equals("javax.servlet.jsp.jstl.fmt.locale")) {
            out.println("FMT_LOCALE -- OK<br>\n");
        } else {
            out.println("FMT_LOCALE not equal to 'javax.servlet.jsp.jstl.fmt.locale'<br>\n");
            out.println("Value is: " + Config.FMT_LOCALE + "<br>\n");
        }

        if (Config.FMT_FALLBACK_LOCALE.equals("javax.servlet.jsp.jstl.fmt.fallbackLocale")) {
            out.println("FMT_FALLBACK_LOCALE -- OK<br>\n");
        } else {
            out.println("FMT_FALLBACKLOCALE not equal to 'javax.servlet.jsp.jstl.fmt.fallbackLocale'<br>\n");
            out.println("Value is: " + Config.FMT_FALLBACK_LOCALE + "<br>\n");
        }

        if (Config.FMT_LOCALIZATION_CONTEXT.equals("javax.servlet.jsp.jstl.fmt.localizationContext")) {
            out.println("FMT_LOCALIZATION_CONTEXT -- OK<br>\n");
        } else {
            out.println("FMT_LOCALIZATION_CONTEXT not equal to 'javax.servlet.jsp.jstl.fmt.localizationContext'<br>\n");
            out.println("Value is: " + Config.FMT_LOCALIZATION_CONTEXT + "<br>\n");
        }

        if (Config.FMT_TIME_ZONE.equals("javax.servlet.jsp.jstl.fmt.timeZone")) {
            out.println("FMT_TIME_ZONE -- OK<br>\n");
        } else {
            out.println("FMT_TIME_ZONE not equal to 'javax.servlet.jsp.jstl.fmt.timeZone'<br>\n");
            out.println("Value is: " + Config.FMT_TIME_ZONE + "<br>\n");
        }

        if (Config.SQL_DATA_SOURCE.equals("javax.servlet.jsp.jstl.sql.dataSource")) {
            out.println("SQL_DATA_SOURCE -- OK<br>\n");
        } else {
            out.println("SQL_DATA_SOURCE not equal to 'javax.servlet.jsp.jstl.sql.dataSource'<br>\n");
            out.println("Value is: " + Config.SQL_DATA_SOURCE + "<br>\n");
        }
        
        if (Config.SQL_MAX_ROWS.equals("javax.servlet.jsp.jstl.sql.maxRows")) {
            out.println("SQL_MAX_ROWS -- OK<br>\n");
        } else {
            out.println("SQL_MAX_ROWS not equal to 'javax.servlet.jsp.jstl.sql.maxRows'<br>\n");
            out.println("Value is: " + Config.SQL_MAX_ROWS + "<br>\n");
        }
    %>
</tck:test>
