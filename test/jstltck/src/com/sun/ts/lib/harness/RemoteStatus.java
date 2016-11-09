/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: RemoteStatus.java 52502 2007-01-24 02:50:22Z lschwenk $
 */

package com.sun.ts.lib.harness;

import java.io.*;
import com.sun.javatest.Status;

public class RemoteStatus implements Serializable
{
	int type;
	String reason;
	
	public RemoteStatus(Status s) 
	{
		type = s.getType();
		reason = s.getReason();
	}
	
	public Status toStatus() 
	{
		return new Status(type, reason);
	}

	public int getType() 
	{
		return type;
	}
	
}
