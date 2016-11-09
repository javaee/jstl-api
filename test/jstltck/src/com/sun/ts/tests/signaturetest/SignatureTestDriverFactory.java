/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: SignatureTestDriverFactory.java 56745 2009-02-12 12:24:46Z dougd $
 */

package com.sun.ts.tests.signaturetest;

/**
 * <p>Factory to obtain SignatureTestDriver implementations.</p>
 */
public class SignatureTestDriverFactory {

    /**
     * <p>Identifier for the driver that uses API Check to perform
     * signature validation.</p>
     */
    public static final String API_CHECK = "apicheck";

    /**
     * <p>Identifier for the driver that uses the Signature Test framwork
     * for signature validation.</p>
     */
    public static final String SIG_TEST = "sigtest";


    // ------------------------------------------------------------ Constructors

    // Access via factory method
    private SignatureTestDriverFactory() { } // END SignatureTestDriverFactory


    // ---------------------------------------------------------- Public Methods

    /**
     * <p>Obtain a {@link SignatureTestDriver} instance based on the
     * <code>type</code> argument.
     *
     * @param type the driver type to create
     * @return a {@link SignatureTestDriver} implementation
     */
    public static SignatureTestDriver getInstance(String type) {

        if (type == null || type.length() == 0) {
            throw new IllegalArgumentException("Type was null or empty");
        }

        if (API_CHECK.equals(type)) {
            return new ApiCheckDriver();
        } else if (SIG_TEST.equals(type)) {
            return new SigTestDriver();
        } else {
            throw new IllegalArgumentException("Unknown Type: '" + type + '\'');
        }

    } // END getInstance

} // END SignatureTestDriverFactory
