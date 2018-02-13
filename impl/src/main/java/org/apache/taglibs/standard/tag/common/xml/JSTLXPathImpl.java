/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2018 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://oss.oracle.com/licenses/CDDL+GPL-1.1
 * or LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package org.apache.taglibs.standard.tag.common.xml;


import javax.xml.namespace.QName;
import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFunctionResolver;
import javax.xml.xpath.XPathVariableResolver;
import javax.xml.xpath.XPathExpression;

import org.apache.xml.dtm.DTM;
import org.apache.xpath.*;
import org.apache.xpath.objects.XObject;
import org.apache.xpath.res.XPATHErrorResources;
import org.apache.xalan.res.XSLMessages;

import org.w3c.dom.Node;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.traversal.NodeIterator;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;

import java.io.IOException;

/**
 * The JSTLXPathImpl class provides implementation for the methods defined  in
 * javax.xml.xpath.XPath interface. This provide simple access to the results
 * of an XPath expression. 
 * 
 * This class provides our own implementation of XPath, so that we can support 
 * a generic Object type in returnType arguement for XPath's evaluate instance 
 * method.
 *
 * Most of the implementation is exactly similar to what is already provided in 
 * com.sun.org.apache.xpath.internal.jaxp.XPathImpl.java
 */
public class JSTLXPathImpl implements javax.xml.xpath.XPath {

    // Private variables
    private XPathVariableResolver variableResolver;
    private XPathFunctionResolver functionResolver;
    private XPathVariableResolver origVariableResolver;
    private XPathFunctionResolver origFunctionResolver;
    private NamespaceContext namespaceContext=null;
    private org.apache.xpath.jaxp.JAXPPrefixResolver prefixResolver;
    // By default Extension Functions are allowed in XPath Expressions. If 
    // Secure Processing Feature is set on XPathFactory then the invocation of
    // extensions function need to throw XPathFunctionException
    private boolean featureSecureProcessing = false; 

    JSTLXPathImpl( XPathVariableResolver vr, XPathFunctionResolver fr ) {
        this.origVariableResolver = this.variableResolver = vr;
        this.origFunctionResolver = this.functionResolver = fr;
    }

    JSTLXPathImpl( XPathVariableResolver vr, XPathFunctionResolver fr, 
            boolean featureSecureProcessing ) {
        this.origVariableResolver = this.variableResolver = vr;
        this.origFunctionResolver = this.functionResolver = fr;
        this.featureSecureProcessing = featureSecureProcessing;
    }

    /**
     * <p>Establishes a variable resolver.</p>
     *
     * @param resolver Variable Resolver
     */
    public void setXPathVariableResolver(XPathVariableResolver resolver) {
        if ( resolver == null ) {
            String fmsg = XSLMessages.createXPATHMessage( 
                    XPATHErrorResources.ER_ARG_CANNOT_BE_NULL,
                    new Object[] {"XPathVariableResolver"} );
            throw new NullPointerException( fmsg );
        }
        this.variableResolver = resolver;
    }

    /**
     * <p>Returns the current variable resolver.</p>
     *
     * @return Current variable resolver
     */
    public XPathVariableResolver getXPathVariableResolver() {
        return variableResolver;
    }

    /**
     * <p>Establishes a function resolver.</p>
     *
     * @param resolver XPath function resolver
     */
    public void setXPathFunctionResolver(XPathFunctionResolver resolver) {
        if ( resolver == null ) {
            String fmsg = XSLMessages.createXPATHMessage( 
                    XPATHErrorResources.ER_ARG_CANNOT_BE_NULL,
                    new Object[] {"XPathFunctionResolver"} );
            throw new NullPointerException( fmsg );
        }
        this.functionResolver = resolver;
    }

    /**
     * <p>Returns the current function resolver.</p>
     *
     * @return Current function resolver
     */
    public XPathFunctionResolver getXPathFunctionResolver() {
        return functionResolver;
    }

    /**
     * <p>Establishes a namespace context.</p>
     *
     * @param nsContext Namespace context to use
     */
    public void setNamespaceContext(NamespaceContext nsContext) {
        if ( nsContext == null ) {
            String fmsg = XSLMessages.createXPATHMessage( 
                    XPATHErrorResources.ER_ARG_CANNOT_BE_NULL,
                    new Object[] {"NamespaceContext"} );
            throw new NullPointerException( fmsg ); 
        }
        this.namespaceContext = nsContext;
        this.prefixResolver = new org.apache.xpath.jaxp.JAXPPrefixResolver ( nsContext );
    }

    /**
     * <p>Returns the current namespace context.</p>
     *
     * @return Current Namespace context
     */
    public NamespaceContext getNamespaceContext() {
        return namespaceContext;
    }

    private static Document d = null;
    
    private static DocumentBuilder getParser() {
        try {
            // we'd really like to cache those DocumentBuilders, but we can't because:
            // 1. thread safety. parsers are not thread-safe, so at least
            //    we need one instance per a thread.
            // 2. parsers are non-reentrant, so now we are looking at having a
            // pool of parsers.
            // 3. then the class loading issue. The look-up procedure of
            //    DocumentBuilderFactory.newInstance() depends on context class loader
            //    and system properties, which may change during the execution of JVM.
            //
            // so we really have to create a fresh DocumentBuilder every time we need one
            // - KK
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware( true );
            dbf.setValidating( false );
            return dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            // this should never happen with a well-behaving JAXP implementation. 
            throw new Error(e);
        }
    }

    private static Document getDummyDocument( ) {
        // we don't need synchronization here; even if two threads
        // enter this code at the same time, we just waste a little time
        if(d==null) {
            DOMImplementation dim = getParser().getDOMImplementation();
            d = dim.createDocument("http://java.sun.com/jaxp/xpath",
                "dummyroot", null);
        }
        return d;
    }

    
    private XObject eval(String expression, Object contextItem)
        throws javax.xml.transform.TransformerException {
        org.apache.xpath.XPath xpath = new org.apache.xpath.XPath( expression,
            null, prefixResolver, org.apache.xpath.XPath.SELECT );
        org.apache.xpath.XPathContext xpathSupport = null;
        if ( functionResolver != null ) {
            org.apache.xpath.jaxp.JAXPExtensionsProvider jep = 
                    new org.apache.xpath.jaxp.JAXPExtensionsProvider(
                    functionResolver, featureSecureProcessing );
            xpathSupport = new org.apache.xpath.XPathContext( jep );
        } else { 
            xpathSupport = new org.apache.xpath.XPathContext();
        }

        XObject xobj = null;
        
        xpathSupport.setVarStack(new org.apache.xpath.jaxp.JAXPVariableStack(variableResolver));
        
        // If item is null, then we will create a a Dummy contextNode
        if ( contextItem instanceof Node ) {
            xobj = xpath.execute (xpathSupport, (Node)contextItem,
                    prefixResolver );
        } else {
            xobj = xpath.execute ( xpathSupport, DTM.NULL, prefixResolver );
        }
 
        return xobj;
    }
        
    /**
     * <p>Evaluate an <code>XPath</code> expression in the specified context and return the result as the specified type.</p>
     *
     * <p>See "Evaluation of XPath Expressions" section of JAXP 1.3 spec
     * for context item evaluation,
     * variable, function and <code>QName</code> resolution and return type conversion.</p>
     *
     * <p>If <code>returnType</code> is not one of the types defined in {@link XPathConstants} (
     * {@link XPathConstants#NUMBER NUMBER},
     * {@link XPathConstants#STRING STRING},
     * {@link XPathConstants#BOOLEAN BOOLEAN},
     * {@link XPathConstants#NODE NODE} or
     * {@link XPathConstants#NODESET NODESET})
     * then an <code>IllegalArgumentException</code> is thrown.</p>
     *
     * <p>If a <code>null</code> value is provided for
     * <code>item</code>, an empty document will be used for the
     * context.
     * If <code>expression</code> or <code>returnType</code> is <code>null</code>, then a
     * <code>NullPointerException</code> is thrown.</p>
     *
     * @param expression The XPath expression.
     * @param item The starting context (node or node list, for example).
     * @param returnType The desired return type.
     *
     * @return Result of evaluating an XPath expression as an <code>Object</code> of <code>returnType</code>.
     *
     * @throws XPathExpressionException If <code>expression</code> cannot be evaluated.
     * @throws IllegalArgumentException If <code>returnType</code> is not one of the types defined in {@link XPathConstants}.
     * @throws NullPointerException If <code>expression</code> or <code>returnType</code> is <code>null</code>.
     */
    public Object evaluate(String expression, Object item, QName returnType)
            throws XPathExpressionException {
        if ( expression == null ) {
            String fmsg = XSLMessages.createXPATHMessage( 
                    XPATHErrorResources.ER_ARG_CANNOT_BE_NULL,
                    new Object[] {"XPath expression"} );
            throw new NullPointerException ( fmsg );
        }
        if ( returnType == null ) {
            String fmsg = XSLMessages.createXPATHMessage( 
                    XPATHErrorResources.ER_ARG_CANNOT_BE_NULL,
                    new Object[] {"returnType"} );
            throw new NullPointerException ( fmsg );
        }
        // Checking if requested returnType is supported. returnType need to
        // be defined in XPathConstants or JSTLXPathConstants
        if ( !isSupported ( returnType ) ) {
            String fmsg = XSLMessages.createXPATHMessage(
                    XPATHErrorResources.ER_UNSUPPORTED_RETURN_TYPE,
                    new Object[] { returnType.toString() } );
            throw new IllegalArgumentException ( fmsg );
        }

        try {
 
            XObject resultObject = eval( expression, item );
            return getResultAsType( resultObject, returnType );
        } catch ( java.lang.NullPointerException npe ) {
            // If VariableResolver returns null Or if we get 
            // NullPointerException at this stage for some other reason
            // then we have to reurn XPathException 
            throw new XPathExpressionException ( npe );
        } catch ( javax.xml.transform.TransformerException te ) {
            Throwable nestedException = te.getException();
            if ( nestedException instanceof javax.xml.xpath.XPathFunctionException ) {
                throw (javax.xml.xpath.XPathFunctionException)nestedException;
            } else {
                // For any other exceptions we need to throw 
                // XPathExpressionException ( as per spec )
                throw new XPathExpressionException ( te );
            }
        } 
        
    }

    private boolean isSupported( QName returnType ) {
        if ( ( returnType.equals( XPathConstants.STRING ) ) ||
             ( returnType.equals( XPathConstants.NUMBER ) ) ||
             ( returnType.equals( XPathConstants.BOOLEAN ) ) ||
             ( returnType.equals( XPathConstants.NODE ) ) ||
             ( returnType.equals( XPathConstants.NODESET ) ) ||
             ( returnType.equals( JSTLXPathConstants.OBJECT ) )   ) {
  
            return true;
        }
        return false;
     }

    private Object getResultAsType( XObject resultObject, QName returnType )
        throws javax.xml.transform.TransformerException {
        // XPathConstants.STRING
        if ( returnType.equals( XPathConstants.STRING ) ) { 
            return resultObject.str();
        }
        // XPathConstants.NUMBER
        if ( returnType.equals( XPathConstants.NUMBER ) ) { 
            return new Double ( resultObject.num());
        }
        // XPathConstants.BOOLEAN
        if ( returnType.equals( XPathConstants.BOOLEAN ) ) { 
            return Boolean.valueOf( resultObject.bool());
        }
        // XPathConstants.NODESET ---ORdered, UNOrdered???
        if ( returnType.equals( XPathConstants.NODESET ) ) { 
            return resultObject.nodelist();
        }
        // XPathConstants.NODE
        if ( returnType.equals( XPathConstants.NODE ) ) { 
            NodeIterator ni = resultObject.nodeset(); 
            //Return the first node, or null
            return ni.nextNode();
        }
        // JSTLXPathConstants.OBJECT
        if ( returnType.equals( JSTLXPathConstants.OBJECT ) ) {
            if (resultObject instanceof org.apache.xpath.objects.XNodeSet)
                return resultObject.nodelist();
            else 
                return resultObject.object();
        }
        String fmsg = XSLMessages.createXPATHMessage(
                XPATHErrorResources.ER_UNSUPPORTED_RETURN_TYPE,
                new Object[] { returnType.toString()});
        throw new IllegalArgumentException( fmsg );
    }
         
            
        
    /**
     * <p>Evaluate an XPath expression in the specified context and return the result as a <code>String</code>.</p>
     *
     * <p>This method calls {@link #evaluate(String expression, Object item, QName returnType)} with a <code>returnType</code> of
     * {@link XPathConstants#STRING}.</p>
     *
     * <p>See "Evaluation of XPath Expressions" of JAXP 1.3 spec 
     * for context item evaluation,
     * variable, function and QName resolution and return type conversion.</p>
     *
     * <p>If a <code>null</code> value is provided for
     * <code>item</code>, an empty document will be used for the
     * context.
     * If <code>expression</code> is <code>null</code>, then a <code>NullPointerException</code> is thrown.</p>
     *
     * @param expression The XPath expression.
     * @param item The starting context (node or node list, for example).
     *
     * @return The <code>String</code> that is the result of evaluating the expression and
     *   converting the result to a <code>String</code>.
     *
     * @throws XPathExpressionException If <code>expression</code> cannot be evaluated.
     * @throws NullPointerException If <code>expression</code> is <code>null</code>.
     */
    public String evaluate(String expression, Object item)
        throws XPathExpressionException {
        return (String)this.evaluate( expression, item, XPathConstants.STRING );
    }

    /**
     * <p>Compile an XPath expression for later evaluation.</p>
     *
     * <p>If <code>expression</code> contains any {@link XPathFunction}s,
     * they must be available via the {@link XPathFunctionResolver}.
     * An {@link XPathExpressionException} will be thrown if the <code>XPathFunction</code>
     * cannot be resovled with the <code>XPathFunctionResolver</code>.</p>
     * 
     * <p>If <code>expression</code> is <code>null</code>, a <code>NullPointerException</code> is thrown.</p>
     *
     * @param expression The XPath expression.
     *
     * @return Compiled XPath expression.

     * @throws XPathExpressionException If <code>expression</code> cannot be compiled.
     * @throws NullPointerException If <code>expression</code> is <code>null</code>.
     */
    public XPathExpression compile(String expression)
        throws XPathExpressionException {
        // This is never used in JSTL
        if ( expression == null ) {
            String fmsg = XSLMessages.createXPATHMessage( 
                    XPATHErrorResources.ER_ARG_CANNOT_BE_NULL,
                    new Object[] {"XPath expression"} );
            throw new NullPointerException ( fmsg );
        }
        return null;
        /*
        try {
            com.sun.org.apache.xpath.internal.XPath xpath = new XPath (expression, null,
                    prefixResolver, com.sun.org.apache.xpath.internal.XPath.SELECT );
            // Can have errorListener
            com.sun.org.apache.xpath.internal.jaxp.XPathExpressionImpl ximpl = 
                    new com.sun.org.apache.xpath.internal.jaxp.XPathExpressionImpl (xpath,
                    prefixResolver, functionResolver, variableResolver,
                    featureSecureProcessing );
            return ximpl;
        } catch ( javax.xml.transform.TransformerException te ) {
            throw new XPathExpressionException ( te ) ;
        }
         **/
    }


    /**
     * <p>Evaluate an XPath expression in the context of the specified <code>InputSource</code>
     * and return the result as the specified type.</p>
     *
     * <p>This method builds a data model for the {@link InputSource} and calls
     * {@link #evaluate(String expression, Object item, QName returnType)} on the resulting document object.</p>
     *
     * <p>See "Evaluation of XPath Expressions" section of JAXP 1.3 spec 
     * for context item evaluation,
     * variable, function and QName resolution and return type conversion.</p>
     *
     * <p>If <code>returnType</code> is not one of the types defined in {@link XPathConstants},
     * then an <code>IllegalArgumentException</code> is thrown.</p>
     *
     * <p>If <code>expression</code>, <code>source</code> or <code>returnType</code> is <code>null</code>,
     * then a <code>NullPointerException</code> is thrown.</p>
     *
     * @param expression The XPath expression.
     * @param source The input source of the document to evaluate over.
     * @param returnType The desired return type.
     *
     * @return The <code>Object</code> that encapsulates the result of evaluating the expression.
     *
     * @throws XPathExpressionException If expression cannot be evaluated.
     * @throws IllegalArgumentException If <code>returnType</code> is not one of the types defined in {@link XPathConstants}.
     * @throws NullPointerException If <code>expression</code>, <code>source</code> or <code>returnType</code>
     *   is <code>null</code>.
     */
    public Object evaluate(String expression, InputSource source, 
            QName returnType) throws XPathExpressionException {
        // Checking validity of different parameters
        if( source== null ) {
            String fmsg = XSLMessages.createXPATHMessage( 
                    XPATHErrorResources.ER_ARG_CANNOT_BE_NULL,
                    new Object[] {"source"} );
            throw new NullPointerException ( fmsg );
        }
        if ( expression == null ) {
            String fmsg = XSLMessages.createXPATHMessage( 
                    XPATHErrorResources.ER_ARG_CANNOT_BE_NULL,
                    new Object[] {"XPath expression"} );
            throw new NullPointerException ( fmsg );
        }
        if ( returnType == null ) {
            String fmsg = XSLMessages.createXPATHMessage( 
                    XPATHErrorResources.ER_ARG_CANNOT_BE_NULL,
                    new Object[] {"returnType"} );
            throw new NullPointerException ( fmsg );
        }

        //Checking if requested returnType is supported. 
        //returnType need to be defined in XPathConstants
        if ( !isSupported ( returnType ) ) {
            String fmsg = XSLMessages.createXPATHMessage(
                    XPATHErrorResources.ER_UNSUPPORTED_RETURN_TYPE,
                    new Object[] { returnType.toString() } );
            throw new IllegalArgumentException ( fmsg );
        }
        
        try {

            Document document = getParser().parse( source );

            XObject resultObject = eval( expression, document );
            return getResultAsType( resultObject, returnType );
        } catch ( SAXException e ) {
            throw new XPathExpressionException ( e );
        } catch( IOException e ) {
            throw new XPathExpressionException ( e );            
        } catch ( javax.xml.transform.TransformerException te ) {
            Throwable nestedException = te.getException();
            if ( nestedException instanceof javax.xml.xpath.XPathFunctionException ) {
                throw (javax.xml.xpath.XPathFunctionException)nestedException;
            } else {
                throw new XPathExpressionException ( te );
            }
        }

    } 
 



    /**
     * <p>Evaluate an XPath expression in the context of the specified <code>InputSource</code>
     * and return the result as a <code>String</code>.</p>
     *
     * <p>This method calls {@link #evaluate(String expression, InputSource source, QName returnType)} with a
     * <code>returnType</code> of {@link XPathConstants#STRING}.</p>
     *
     * <p>See "Evaluation of XPath Expressions" section of JAXP 1.3 spec
     * for context item evaluation,
     * variable, function and QName resolution and return type conversion.</p>
     *
     * <p>If <code>expression</code> or <code>source</code> is <code>null</code>,
     * then a <code>NullPointerException</code> is thrown.</p>
     *
     * @param expression The XPath expression.
     * @param source The <code>InputSource</code> of the document to evaluate over.
     *
     * @return The <code>String</code> that is the result of evaluating the expression and
     *   converting the result to a <code>String</code>.
     *
     * @throws XPathExpressionException If expression cannot be evaluated.
     * @throws NullPointerException If <code>expression</code> or <code>source</code> is <code>null</code>.
     */
    public String evaluate(String expression, InputSource source)
        throws XPathExpressionException {
        return (String)this.evaluate( expression, source, XPathConstants.STRING );
    }

    /**
     * <p>Reset this <code>XPath</code> to its original configuration.</p>
     *
     * <p><code>XPath</code> is reset to the same state as when it was created with
     * {@link XPathFactory#newXPath()}.
     * <code>reset()</code> is designed to allow the reuse of existing <code>XPath</code>s
     * thus saving resources associated with the creation of new <code>XPath</code>s.</p>
     *
     * <p>The reset <code>XPath</code> is not guaranteed to have the same
     * {@link XPathFunctionResolver}, {@link XPathVariableResolver}
     * or {@link NamespaceContext} <code>Object</code>s, e.g. {@link Object#equals(Object obj)}.
     * It is guaranteed to have a functionally equal <code>XPathFunctionResolver</code>,
     * <code>XPathVariableResolver</code>
     * and <code>NamespaceContext</code>.</p>
     */
    public void reset() {
        this.variableResolver = this.origVariableResolver;
        this.functionResolver = this.origFunctionResolver;
        this.namespaceContext = null;
    }
 
}
