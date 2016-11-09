/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: Goldenfile.java 53299 2007-04-27 18:01:30Z dougd $
 */

package com.sun.ts.tests.common.webclient;

import com.sun.ts.lib.util.TestUtil;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;
import java.io.IOException;

/**
 * A representation of a Goldenfile that may be used by
 * a particular test case.
 */

public class Goldenfile {

    /*
     * Message to be returned if the goldenfile cannot be located.
     */
    private static final byte[] NOTFOUND = "NO GOLDENFILE FOUND".getBytes();

    /*
     * Message to be returned if the goldenfile doesn't have read permissions.
     */
    private static final byte[] NOPERM = "INSUFFICIENT PERMISSIONS".getBytes();

    /*
     * Goldenfile represented by this object.
     */
    private File _file = null;

    /*
     * Error message to return by public methods if
     * the file is not found or the user has insufficient permissions.
     */
    private byte[] _errMessage = null;

    /*
     * Goldenfile length
     */
    private long _length = 0L;

    /*
     * Encoding
     */
    private String _encoding = null;

    /**
     * Creates a new GoldenFile based on the fully qualified filename provided.
     *
     * @param path Fully qualified file name
     * @param encoding to use when reading the goldenfile
     */
    public Goldenfile(String path, String encoding) {
        _file = new File(path);
        if (!_file.exists()) {
            TestUtil.logTrace("[GoldenFile] Goldenfile: " + path + ", not found!");
            _errMessage = NOTFOUND;
            _file = null;
        } else if (!_file.canRead()) {
            _errMessage = NOPERM;
            _file = null;
        } else {
            _length = _file.length();
            _encoding = encoding;
        }
    }

/*
 * public methods
 * ========================================================================
 */

    /**
     * Returns the length of the Goldenfile.
     *
     * @return long length
     */
    public long getLength() {
        return _length;
    }

    /**
     * Returns the byte content of the specified goldenfile using the charset
     * encoding specified in the response from the server.
     *
     * @return the goldenfile as a byte array
     * @throws IOException if an error occurs processing the file.
     */
    public byte[] getGoldenFileAsBytes() throws IOException {
        if (_file != null) {
            return getGoldenFileAsString().getBytes();
        } else {
            return _errMessage;
        }
    }

    /**
     * Retuns a string representation of the specified goldenfile using the
     * charset encoding specified in the response from the server.
     *
     * @return the goldenfile as a String.
     * @throws IOException if an error occurs processing the file.
     */
    public String getGoldenFileAsString() throws IOException {
        String gf = null;
        if (_file != null) {
            TestUtil.logTrace("[Goldenfile] Loading goldenfile using " +
                              "encoding: " + _encoding);
            FileInputStream in = new FileInputStream(_file);
            gf = Util.getEncodedStringFromStream(in, _encoding);
            in.close();
        } else {
            gf = new String(_errMessage);
        }
        return gf;
    }

    /**
     * Returns the goldenfile as an InputStream using the charset encoding
     * specified in the response from the server.
     *
     * @return goldenfile as an InputStream
     * @throws IOException If an error occurs processing the file.
     */
    public InputStream getGoldenFileAsStream() throws IOException {
        if (_file != null) {
            return new ByteArrayInputStream(getGoldenFileAsBytes());
        } else {
            return new ByteArrayInputStream(_errMessage);
        }
    }
}
