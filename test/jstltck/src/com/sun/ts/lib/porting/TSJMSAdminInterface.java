/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: TSJMSAdminInterface.java 55283 2008-07-02 16:30:38Z kgrucci $
 */

package com.sun.ts.lib.porting;

import java.io.*;


/**
 * This is the TSJMSAdminInterface.  An implementation of this interface must
 * be provided by each J2EE implementation, to support their own creation/deletion
 * semantics of topic/queue and QueueConnectionFactory/TopicConnectionFactory.
 *  
 * @author	Kyle Grucci
 */

public interface TSJMSAdminInterface
{
    /**
     * The init method is a logging mechanism for diagnostics. The writer
     * parameter specifies the PrinterWriter that is used to log output.
     *
	 * Initializes a new TSJMSAdminInterface instance.  All output should be 
	 * printed to this PrintWriter.  All properties in 
	 * the ts.jte file are accessible to this porting 
	 * implementation class only via the TSPropertyManager class.
	 *
	 * @param writer   The PrintWriter that is used to log output.
	 */
	public void init(PrintWriter writer);
	

    /**
     * The createQueues method creates queues in a J2EE implementation.
     * The queues parameter specifies the queue destination objects to create.
     *
	 * @param queues    Queues to create
	 * 
	 */
	public void createQueues(String[] queues) throws TSJMSAdminException;

	
    /**
     * The createTopics method creates topics in a J2EE implementation.
     * The topics parameter specifies the topic destination objects to create.
     *
	 * @param topics    Topics to create
	 * 
	 */
	public void createTopics(String[] topics) throws TSJMSAdminException;

	
    /**
     * The removeQueues method removes queues in a J2EE implementation.
     * The queues parameter specifies the queue destination objects to remove.
     *
	 * @param queues    Queues to remove
	 * 
	 */
	public void removeQueues(String[] queues) throws TSJMSAdminException;

	
    /**
     * The removeTopics method remove topics in a J2EE implementation.
     * The topics parameter specifies the topic destination objects to remove.
	 *
	 * @param topics    Topics to remove
	 * 
	 */
	public void removeTopics(String[] topics) throws TSJMSAdminException;

  
  	/**
	 * This method creates QueueConnectionFactorys in a J2EE implementation.
	 *
	 * Two String array parameters are passed when createQueueConnectionFactories 
     * is called, where the first array specifies QueueConnectionFactorys to create and
     * the second array specifies properties associated with the QueueConnectionFactory. 
     * 
	 * Arguments passed as queueConnectionFactories[n],props[n] where props[i] consists
     * all properties that associated to QueueConnectionFactory queueConnectionFactories[i].
     *
     * Each element in the Properties array consists of a String name value pair
     * that defines the properties for the factory connection.  
     * Some of the connection factories set up by J2EE TCK require a property for the clientID.
     * The name value pair in this case would be "clientId=cts".  
	 * If more than one property needs to be specified by a single QueueConnectionFactory, 
     * the properties should be space separated in the props string. 
     * If no property is being specified, the name value pair would be an empty String "".
	 *
	 * @param queueConnectionFactories    queueConnectionFactories to create
	 * @param props                       properties for the connection, if any
	 */

	public void createQueueConnectionFactories(String[] queueConnectionFactories, String[] props) throws TSJMSAdminException;
  

	/**
	 * This method creates TopicConnectionFactorys in a J2EE implementation.
	 *
	 * Two String array parameters are passed when createTopicConnectionFactories 
     * is called, where the first array specifies TopicConnectionFactorys to create and 
     * the second array specifies properties associated with the TopicConnectionFactory. 
     *
	 * Arguments passed as topicConnectionFactories[n],props[n] where props[i] consists
     * all properties that associated to TopicConnectionFactory topicConnectionFactories[i].
     *
     * Each element in the Properties array consists of a String name value pair
     * that defines the properties for the factory connection.  
     * Some of the connection factories set up by J2EE TCK require a property for the clientID.
     * The name value pair in this case would be "clientId=cts".  
	 * If more than one property needs to be specified by a single TopicConnectionFactory, 
     * the properties should be space separated in the props string. 
     * If no property is being specified, the name value pair would be an empty String "".
	 *
	 * @param topicConnectionFactories    topicConnectionFactories to create
	 * @param props                       properties for the connection, if any
	 */
	public void createTopicConnectionFactories(String[] topicConnectionFactories, String[] props) throws TSJMSAdminException;
  

	/**
	 * This method removes ConnectionFactories from a J2EE implementation.
	 *
	 * @param jmsConnectionFactoryNames    JmsConnectionFactoryNames to remove
	 * 
	 */
	public void removeJmsConnectionFactories(String[] jmsConnectionFactoryNames) throws TSJMSAdminException;

}


