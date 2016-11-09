<%-- 
 Copyright 2003 Sun Micorsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="tck" uri="http://java.sun.com/jstltck/jstltck-util" %>
<tck:test testName="positiveOutEscXmlTest">
    <x:parse var="doc">
        <a>
          <![CDATA[< > & ' "]]>
        </a>
    </x:parse>

     <!-- If escapeXml is true, the following characters will
             be converted to their corresponding entity codes:
             < -> &lt;
             > -> &gt;
             & -? &amp;
             ' -> &#039;
             " -> &#034
             If false, no escaping will occur.
             If escapeXml is not specified, escaping will occur. -->
     escapeXml == true: <x:out select="$doc//a"
                                  escapeXml='<%= true %>'/>
     escapeXml == false: <x:out select="$doc//a" escapeXml="false"/><br>
     escapeXml == not specified: <x:out select="$doc//a"/><br>
</tck:test>
