/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $URL: http://jse.east.sun.com:9001/re_repos/spider/branches/jstl/1.2/src/com/sun/ts/tests/jstl/common/filters/SimpleXmlFilter.java $ $LastChangedDate: 2007-02-11 23:30:10 -0500 (Sun, 11 Feb 2007) $
 */

package com.sun.ts.tests.jstl.common.filters;

import org.xml.sax.helpers.XMLFilterImpl;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class SimpleXmlFilter extends XMLFilterImpl {

    /** Creates new SimpleXmlFilter */
    public SimpleXmlFilter() {
    }

/* 
 * public methods
 * ========================================================================
 */
    
    /**
     * When called, an new attribute, 'test', will be added to
     * each element processed.
     */
    public void startElement(String namespaceURI, String localName,  
                             String qualifiedName, Attributes atts) 
    throws SAXException {
        AttributesImpl attributes = new AttributesImpl(atts);
        attributes.addAttribute("", "test", "test", "CDATA", "attrvalue");
        atts = attributes;
        super.startElement(namespaceURI, localName, qualifiedName, atts);
    }
}
