/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: SqlUrlClient.java 54173 2008-01-15 20:33:10Z dougd $ 
 */

package com.sun.ts.tests.jstl.common.client;

import java.util.Properties;
import java.util.Enumeration;
import com.sun.ts.tests.jstl.common.JstlTckConstants;
import com.sun.ts.tests.common.webclient.WebTestCase;
import com.sun.ts.tests.common.webclient.http.HttpRequest;

public class SqlUrlClient extends AbstractUrlClient implements JstlTckConstants {
    protected Properties dbArgs = new Properties();

    @Override
    public void setup(String[] args, Properties p) throws Fault {
        for(int i = 0; i < JSTL_DB_PROPS.length; i++) {
            String s = p.getProperty(JSTL_DB_PROPS[i]);
            if(s != null) {
                dbArgs.setProperty(JSTL_DB_PROPS[i], s.trim());
            }
        }
        super.setup(args, p);
    }

    @Override
    public void setTestProperties(WebTestCase testCase) {
        super.setTestProperties(testCase);
        HttpRequest httpReq = testCase.getRequest();
        Enumeration enumm = dbArgs.propertyNames();
        for(; enumm.hasMoreElements();) {
            String name = (String) enumm.nextElement();
            String value = dbArgs.getProperty(name);
            httpReq.addRequestHeader(name, value);
        }
    }

    private String aggregateParams(String url) {
        StringBuffer newParams = new StringBuffer();
        Enumeration enumm = dbArgs.propertyNames();
        int size = dbArgs.size();
        for(int i = 0; enumm.hasMoreElements(); i++) {
            String name = (String) enumm.nextElement();
            String value = dbArgs.getProperty(name);
            newParams.append(name + "=" + value);
            if (i < (size - 1))
                newParams.append("&");
        }

        // insert these parameters into the URL as appropriate
        if (newParams.length() > 0) {
            int questionMark = url.indexOf('?');
            StringBuffer workingUrl = new StringBuffer(url);
            if (questionMark == -1) {
                int httpMark = url.indexOf("HTTP/");
                workingUrl.insert(httpMark - 1, ("?" + newParams));
            } else {
                workingUrl.insert(questionMark + 1, (newParams + "&"));
            }
            return workingUrl.toString();
        } else {
            return url;
        }
    }
}
