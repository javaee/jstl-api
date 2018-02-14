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

package org.apache.taglibs.standard.extra.spath;

public interface SPathParserConstants {

  int EOF = 0;
  int LITERAL = 1;
  int QNAME = 2;
  int NCNAME = 3;
  int NSWILDCARD = 4;
  int NCNAMECHAR = 5;
  int LETTER = 6;
  int DIGIT = 7;
  int COMBINING_CHAR = 8;
  int EXTENDER = 9;
  int UNDERSCORE = 10;
  int DOT = 11;
  int DASH = 12;
  int SLASH = 13;
  int STAR = 14;
  int COLON = 15;
  int START_BRACKET = 16;
  int END_BRACKET = 17;
  int AT = 18;
  int EQUALS = 19;

  int DEFAULT = 0;

  String[] tokenImage = {
    "<EOF>",
    "<LITERAL>",
    "<QNAME>",
    "<NCNAME>",
    "<NSWILDCARD>",
    "<NCNAMECHAR>",
    "<LETTER>",
    "<DIGIT>",
    "<COMBINING_CHAR>",
    "<EXTENDER>",
    "\"_\"",
    "\".\"",
    "\"-\"",
    "\"/\"",
    "\"*\"",
    "\":\"",
    "\"[\"",
    "\"]\"",
    "\"@\"",
    "\"=\"",
  };

}
