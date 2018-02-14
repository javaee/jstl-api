/*
 * Copyright (c) 1997-2018 Oracle and/or its affiliates. All rights reserved.
 * Copyright 2004 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.taglibs.standard.tag.common.xml;

import java.util.List;
import java.util.Vector;
import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathVariableResolver;
import javax.xml.xpath.XPathFactoryConfigurationException;

import org.apache.taglibs.standard.resources.Resources;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * <p>Support for tag handlers that evaluate XPath expressions.</p>
 *
 * @author Shawn Bayern
 * @author Ramesh Mandava ( ramesh.mandava@sun.com )
 * @author Pierre Delisle ( pierre.delisle@sun.com )
 * @author Dongbin Nie
 */
// would ideally be a base class, but some of our user handlers already
// have their own parents
public class XPathUtil {
    
    //*********************************************************************
    // Constructor
    
    /**
     * Constructs a new XPathUtil object associated with the given
     * PageContext.
     */
    public XPathUtil(PageContext pc) {
        pageContext = pc;
    }    
    
    //*********************************************************************
    // Support for JSTL variable resolution
    
    // The URLs
    private static final String PAGE_NS_URL
    = "http://java.sun.com/jstl/xpath/page";
    private static final String REQUEST_NS_URL
    = "http://java.sun.com/jstl/xpath/request";
    private static final String SESSION_NS_URL
    = "http://java.sun.com/jstl/xpath/session";
    private static final String APP_NS_URL
    = "http://java.sun.com/jstl/xpath/app";
    private static final String PARAM_NS_URL
    = "http://java.sun.com/jstl/xpath/param";
    private static final String INITPARAM_NS_URL
    = "http://java.sun.com/jstl/xpath/initParam";
    private static final String COOKIE_NS_URL
    = "http://java.sun.com/jstl/xpath/cookie";
    private static final String HEADER_NS_URL
    = "http://java.sun.com/jstl/xpath/header";
    
    //*********************************************************************
    // Support for XPath evaluation
    
    private PageContext pageContext;
    
    private static final String XPATH_FACTORY_CLASS_NAME = 
            "org.apache.taglibs.standard.tag.common.xml.JSTLXPathFactory";
    private static XPathFactory XPATH_FACTORY;
    
    private static JSTLXPathNamespaceContext jstlXPathNamespaceContext = null;
    
    private static DocumentBuilderFactory dbf = null;
    
    static {
        initXPathFactory();
        initXPathNamespaceContext();
        initDocumentBuilderFactory();
    }

    private static void initXPathFactory() {
        // If the system property DEFAULT_PROPERTY_NAME + ":uri" is present, 
        // where uri is the parameter to this method, then its value is read 
        // as a class name. The method will try to create a new instance of 
        // this class by using the class loader, and returns it if it is 
        // successfully created.
        if (System.getSecurityManager() !=  null) {
             AccessController.doPrivileged(new PrivilegedAction<Object>(){
                public Object run(){
                    System.setProperty(XPathFactory.DEFAULT_PROPERTY_NAME + 
                            ":" + XPathFactory.DEFAULT_OBJECT_MODEL_URI, 
                            XPATH_FACTORY_CLASS_NAME);
                    return null;
                }
            });
        } else {
            System.setProperty(XPathFactory.DEFAULT_PROPERTY_NAME + 
                ":" + XPathFactory.DEFAULT_OBJECT_MODEL_URI, 
                XPATH_FACTORY_CLASS_NAME);
        }
        try {
            XPATH_FACTORY = XPathFactory.newInstance(XPathFactory.DEFAULT_OBJECT_MODEL_URI);
        } catch (XPathFactoryConfigurationException xpce) {
            xpce.printStackTrace();
        }
	}
    
    /** Initialize globally useful data. */
    private static void initXPathNamespaceContext() {
        // register supported namespaces
        jstlXPathNamespaceContext = new JSTLXPathNamespaceContext();
        jstlXPathNamespaceContext.addNamespace("pageScope", PAGE_NS_URL);
        jstlXPathNamespaceContext.addNamespace("requestScope", REQUEST_NS_URL);
        jstlXPathNamespaceContext.addNamespace("sessionScope", SESSION_NS_URL);
        jstlXPathNamespaceContext.addNamespace("applicationScope", APP_NS_URL);
        jstlXPathNamespaceContext.addNamespace("param", PARAM_NS_URL);
        jstlXPathNamespaceContext.addNamespace("initParam", INITPARAM_NS_URL);
        jstlXPathNamespaceContext.addNamespace("header", HEADER_NS_URL);
        jstlXPathNamespaceContext.addNamespace("cookie", COOKIE_NS_URL);
    }
    
    private static void initDocumentBuilderFactory() {
        dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware( true );
        dbf.setValidating( false );
    }
    
    /**
     * Create a new empty document.
     *
     * This method always allocates a new document as its root node might be
     * exposed to other tags and potentially be mutated.
     *
     * @return a new empty document
     */
    private static Document newEmptyDocument() {
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            return db.newDocument();
        } catch (ParserConfigurationException e) {
        	throw new AssertionError();
        }
    }
    
    /**
     * Evaluate an XPath expression to a String value. 
     */
    public String valueOf(Node contextNode, String xpathString) 
        throws JspTagException {
        // p("******** valueOf(" + n + ", " + xpathString + ")");
        XPathVariableResolver jxvr = new JSTLXPathVariableResolver(pageContext);
        
        XPath xpath = XPATH_FACTORY.newXPath();
        xpath.setNamespaceContext(jstlXPathNamespaceContext);
        xpath.setXPathVariableResolver(jxvr);
        try {
            return xpath.evaluate(xpathString, contextNode);
        } catch (XPathExpressionException ex) {
            throw new JspTagException(ex.toString(), ex);
        }
    }
    
    
    /** 
     * Evaluate an XPath expression to a boolean value. 
     */
    public boolean booleanValueOf(Node contextNode, String xpathString)
    throws JspTagException {
        XPathVariableResolver jxvr = new JSTLXPathVariableResolver(pageContext);
        
        XPath xpath = XPATH_FACTORY.newXPath();
        xpath.setNamespaceContext(jstlXPathNamespaceContext);
        xpath.setXPathVariableResolver(jxvr);
        try {
            return ((Boolean) xpath.evaluate(
              xpathString, contextNode, XPathConstants.BOOLEAN)).booleanValue();
        } catch (XPathExpressionException ex) {
            throw new JspTagException(
                Resources.getMessage("XPATH_ERROR_XOBJECT", ex.toString()), ex);            
        }
    }
    
    /** 
     * Evaluate an XPath expression to a List of nodes. 
     */
    public List selectNodes(Node contextNode, String xpathString)  
        throws JspTagException {
        XPathVariableResolver jxvr = new JSTLXPathVariableResolver(pageContext);
        
        try {
            XPath xpath = XPATH_FACTORY.newXPath();
            xpath.setNamespaceContext(jstlXPathNamespaceContext);
            xpath.setXPathVariableResolver(jxvr);
            Object nl = xpath.evaluate(
                xpathString, contextNode, JSTLXPathConstants.OBJECT);
            return new JSTLNodeList( nl );
        } catch (XPathExpressionException ex ) {
            throw new JspTagException(ex.toString(), ex);
        }
    }
    
    /** 
     * Evaluate an XPath expression to a single node. 
     */
    public Node selectSingleNode(Node contextNode, String xpathString)
    throws JspTagException {
        //p("selectSingleNode of XPathUtil = passed node:" +
        //   "xpathString => " + n + " : " + xpathString );
        XPathVariableResolver jxvr = new JSTLXPathVariableResolver(pageContext);
        
        try {
            XPath xpath = XPATH_FACTORY.newXPath();
            xpath.setNamespaceContext(jstlXPathNamespaceContext);
            xpath.setXPathVariableResolver(jxvr);
            return (Node) xpath.evaluate(
                xpathString, contextNode, XPathConstants.NODE);
        } catch (XPathExpressionException ex) {
            throw new JspTagException(ex.toString(), ex);            
        }
    }
    
    //*********************************************************************
    // Static support for context retrieval from parent <forEach> tag
    
    public static Node getContext(Tag t) throws JspTagException {
        ForEachTag xt =
        (ForEachTag) TagSupport.findAncestorWithClass(
        t, ForEachTag.class);
        if (xt == null)
            return newEmptyDocument();
        else
            return (xt.getContext());
    }
    
    //*********************************************************************
    // Utility methods
    
    private static void p(String s) {
        System.out.println("[XPathUtil] " + s);
    }
    
    public static void printDetails(Node n) {
        p("\n\nDetails of Node = > " + n ) ;
        p("Name:Type:Node Value = > " + n.getNodeName() +
        ":" + n.getNodeType() + ":" + n.getNodeValue()  ) ;
        p("Namespace URI : Prefix : localName = > " +
        n.getNamespaceURI() + ":" +n.getPrefix() + ":" + n.getLocalName());
        p("\n Node has children => " + n.hasChildNodes() );
        if ( n.hasChildNodes() ) {
            NodeList nl = n.getChildNodes();
            p("Number of Children => " + nl.getLength() );
            for ( int i=0; i<nl.getLength(); i++ ) {
                Node childNode = nl.item(i);
                printDetails( childNode );
            }
        }
    }    
}

class JSTLNodeList extends Vector implements NodeList   {
    
    Vector nodeVector;

    public JSTLNodeList ( Vector nodeVector ) {
        this.nodeVector = nodeVector;
    }

    public JSTLNodeList ( NodeList nl ) {
        nodeVector = new Vector();
        //p("[JSTLNodeList] nodelist details");
        for ( int i=0; i<nl.getLength(); i++ ) {
            Node currNode = nl.item(i);
            //XPathUtil.printDetails ( currNode );
            nodeVector.add(i, nl.item(i) );
        }
    }

    public JSTLNodeList ( Node n ) {
        nodeVector = new Vector();
        nodeVector.addElement( n );
    }

    public JSTLNodeList (Object o) {
        nodeVector = new Vector();
        
        if (o instanceof NodeList) {
            NodeList nl = (NodeList)o;
            for ( int i=0; i<nl.getLength(); i++ ) {
                Node currNode = nl.item(i);
                //XPathUtil.printDetails ( currNode );
                nodeVector.add(i, nl.item(i) );
            }
        } else {
            nodeVector.addElement( o );
        }
    }

    public Node item ( int index ) {
        return (Node)nodeVector.elementAt( index );
    }

    public Object elementAt ( int index ) {
        return nodeVector.elementAt( index );
    }

    public Object get ( int index ) {
        return nodeVector.get( index );
    }

    public int getLength (  ) {
        return nodeVector.size( );
    }

    public int size (  ) {
        //p("JSTL node list size => " + nodeVector.size() );
        return nodeVector.size( );
    }

    // Can implement other Vector methods to redirect those methods to 
    // the vector in the variable param. As we are not using them as part 
    // of this implementation we are not doing that here. If this changes
    // then we need to override those methods accordingly  

}
         



