/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: DMProps.java 52683 2007-02-12 02:25:42Z lschwenk $
 */

/*
 * @(#)DMProps.java	1.1   02/04/15
 */



package com.sun.ts.lib.deliverable.cts.deploy;

// Java imports
import java.lang.String;
import java.util.Properties;

// Harness imports
import com.sun.ts.lib.util.TestUtil;

public class DMProps {

  private String jarfile;
  private String uri;
  private String uname;
  private String passwd;

  public DMProps(String jarfile, String uri, String uname, String passwd) {
    this.jarfile = jarfile;
    this.uri = uri;
    this.uname = uname;
    this.passwd = passwd;
  }

    public boolean equals(DMProps dm2) {
    return (this.jarfile.equals(dm2.jarfile) && this.uri.equals(dm2.uri) && this.uname.equals(dm2.uname) && this.passwd.equals(dm2.passwd));
  }
  
  public void setJarFile(String jarfile) {
    this.jarfile = jarfile;
  }

  public void setURI(String uri) {
    this.uri = uri;
  }

  public void setUname(String uname) {
    this.uname = uname;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  public String getJarFile() {
    return (jarfile);
  }

  public String getURI() {
    return (uri);
  }

  public String getUname() {
    return (uname);
  }

  public String getPasswd() {
    return (passwd);
  }

}

