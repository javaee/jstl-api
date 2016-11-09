/*
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * $Id: Dog.java 52683 2007-02-12 02:25:42Z lschwenk $
 */

package com.sun.ts.lib.deliverable.cts.resource;

/**
 * A simple JavaBean class to be used as a custom resource type.
 */
public class Dog implements java.io.Serializable {
    public static final String DOG_NAME = "wangwang";
    public static final int DOG_AGE = 2;
    
    private static Dog instance = new Dog();
    
    private int age = DOG_AGE;
    private String name = DOG_NAME;
    
    public Dog() {
    }
    
    public static Dog getInstance() {
        return instance;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        String retValue;
        retValue = super.toString() + ", name=" + name
                + ", age=" + age;
        return retValue;
    }
    
    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((name == null) ? 0 : name.hashCode());
        result = PRIME * result + age;
        return result;
    }
    
    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Dog) {
            Dog anotherDog = (Dog) anObject;
            return (this.age == anotherDog.age && this.name.equals(anotherDog.name));
        }
        return false;
    }
    
}
