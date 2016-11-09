/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: ExcludeListProcessor.java 52502 2007-01-24 02:50:22Z lschwenk $
 */

package com.sun.ts.lib.harness;

import java.util.Vector;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class ExcludeListProcessor {

	//pass in a string which has the filename#testname
	public static boolean isTestExcluded(String fileName)
	{
		//check to see if it exists in the exclude list
		return fileNameList.contains(fileName);		
	}   

  public static void readExcludeList(String fileName) {
    BufferedReader d = null;
    try {
      d = new BufferedReader (new FileReader (fileName));
      String line;
      while ((line = d.readLine()) != null) {
        line = line.trim();
        if (line.length() > 0 && !line.startsWith ("#")) {
          String entry = new String (line);
          fileNameList.addElement(entry.trim());
        }
      }
      d.close();
    } catch (FileNotFoundException e) {
      System.out.println (e.toString());
	  e.printStackTrace();
    } catch (IOException e) {
      System.out.println (e.toString());
	  e.printStackTrace();
    }
  }

  /*----------- Private Members of this class -------------*/
  private static Vector fileNameList = new Vector();

}
