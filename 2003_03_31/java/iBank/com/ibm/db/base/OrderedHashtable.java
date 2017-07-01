//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\base\\OrderedHashtable.java

package com.ibm.db.base;

import java.util.Dictionary;
import java.io.Serializable;
import java.util.Vector;
import java.util.Hashtable;
import java.util.Enumeration;

public class OrderedHashtable extends java.util.Dictionary implements java.io.Serializable 
{
   private Vector sequenceableKeys;
   private Vector sequenceableValues;
   private Hashtable hashtable;
   static final long serialVersionUID = 2096557439;
   private static final String copyright;
   
   /**
    * @roseuid 3E00405400F3
    */
   public OrderedHashtable() 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00405400E8
    */
   public OrderedHashtable(int arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @return boolean
    * @roseuid 3E00405400FC
    */
   public synchronized boolean contains(java.lang.Object arg0) 
   {
    return true;
   }
   
   /**
    * @param arg0
    * @return boolean
    * @roseuid 3E004054012E
    */
   public synchronized boolean containsKey(java.lang.Object arg0) 
   {
    return true;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @roseuid 3E0040540156
    */
   private synchronized void decrementIndexesBetween(int arg0, int arg1) 
   {
    
   }
   
   /**
    * @return java.util.Enumeration
    * @roseuid 3E0040540188
    */
   public synchronized java.util.Enumeration elements() 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.lang.Object
    * @roseuid 3E00405401F6
    */
   public synchronized Object get(java.lang.Object arg0) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.lang.Object
    * @roseuid 3E004054025B
    */
   public synchronized Object getAtIndex(int arg0) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @roseuid 3E004054028D
    */
   private synchronized void incrementIndexesBetween(int arg0, int arg1) 
   {
    
   }
   
   /**
    * @param arg0
    * @return int
    * @roseuid 3E00405402A2
    */
   public synchronized int indexOfKey(java.lang.Object arg0) 
   {
    return 0;
   }
   
   /**
    * @return boolean
    * @roseuid 3E00405402D3
    */
   public boolean isEmpty() 
   {
    return true;
   }
   
   /**
    * @return java.util.Enumeration
    * @roseuid 3E00405402FB
    */
   public synchronized java.util.Enumeration keys() 
   {
    return null;
   }
   
   /**
    * @return java.lang.Integer
    * @roseuid 3E0040540369
    */
   private Integer newIndex() 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return java.lang.Object
    * @roseuid 3E00405403AF
    */
   public synchronized Object put(java.lang.Object arg0, java.lang.Object arg1) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.lang.Object
    * @roseuid 3E0040550049
    */
   public synchronized Object remove(java.lang.Object arg0) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.lang.Object
    * @roseuid 3E00405500B7
    */
   public synchronized Object removeElementAt(int arg0) 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3E00405500EA
    */
   public int size() 
   {
    return 0;
   }
   
   /**
    * @return java.lang.String
    * @roseuid 3E0040550112
    */
   public synchronized String toString() 
   {
    return null;
   }
   
   /**
    * @param obj
    * @return Object
    * @roseuid 3E0042CC0259
    */
   public Object get(Object obj) 
   {
    return null;
   }
   
   /**
    * @param obj
    * @param obj1
    * @return Object
    * @roseuid 3E0042CC0264
    */
   public Object put(Object obj, Object obj1) 
   {
    return null;
   }
   
   /**
    * @param obj
    * @return Object
    * @roseuid 3E0042CC0277
    */
   public Object remove(Object obj) 
   {
    return null;
   }
}
