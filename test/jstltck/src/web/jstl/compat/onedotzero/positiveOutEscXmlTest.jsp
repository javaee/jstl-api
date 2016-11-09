<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="x_rt" uri="http://java.sun.com/jstl/xml_rt" %>
<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveOutEscXmlTest">
    <x:parse var="doc">
        <a>
          <![CDATA[< > & ' "]]>
        </a>
    </x:parse>
    <!-- EL: If escapeXml is true, the following characters will
             be converted to their corresponding entity codes:
             < -> &lt;
             > -> &gt;
             & -? &amp;
             ' -> &#039;
             " -> &#034
             If false, no escaping will occur.
             If escapeXml is not specified, escaping will occur. -->
     escapeXml == true: <x:out select="$doc//a" escapeXml="${true}"/><br>
     escapeXml == false: <x:out select="$doc//a" escapeXml="false"/><br>
     escapeXml == not specified: <x:out select="$doc//a"/><br>

     <!-- RT: If escapeXml is true, the following characters will
             be converted to their corresponding entity codes:
             < -> &lt;
             > -> &gt;
             & -? &amp;
             ' -> &#039;
             " -> &#034
             If false, no escaping will occur.
             If escapeXml is not specified, escaping will occur. -->
     escapeXml == true: <x_rt:out select="$doc//a" 
                                  escapeXml='<%= true %>'/>
     escapeXml == false: <x_rt:out select="$doc//a" escapeXml="false"/><br>
     escapeXml == not specified: <x_rt:out select="$doc//a"/><br>
</tck:test>
