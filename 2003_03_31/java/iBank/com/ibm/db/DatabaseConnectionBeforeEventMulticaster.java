//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\DatabaseConnectionBeforeEventMulticaster.java

package com.ibm.db;

import java.awt.AWTEventMulticaster;
import java.util.EventListener;

class DatabaseConnectionBeforeEventMulticaster extends java.awt.AWTEventMulticaster implements com.ibm.db.DatabaseConnectionBeforeListener 
{
   private static final String copyright;
   
   /**
    * @param arg0
    * @param arg1
    * @roseuid 3E003F4F02AF
    */
   protected DatabaseConnectionBeforeEventMulticaster(com.ibm.db.DatabaseConnectionBeforeListener arg0, com.ibm.db.DatabaseConnectionBeforeListener arg1) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F5001C1
    */
   public void aboutToCommit(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F500243
    */
   public void aboutToConnect(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F5002C5
    */
   public void aboutToDisconnect(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F500347
    */
   public void aboutToRollback(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return com.ibm.db.DatabaseConnectionBeforeListener
    * @roseuid 3E003F5003DD
    */
   public static com.ibm.db.DatabaseConnectionBeforeListener add(com.ibm.db.DatabaseConnectionBeforeListener arg0, com.ibm.db.DatabaseConnectionBeforeListener arg1) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return java.util.EventListener
    * @roseuid 3E003F510186
    */
   protected static java.util.EventListener addInternal(java.util.EventListener arg0, java.util.EventListener arg1) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return com.ibm.db.DatabaseConnectionBeforeListener
    * @roseuid 3E003F51028A
    */
   public static com.ibm.db.DatabaseConnectionBeforeListener remove(com.ibm.db.DatabaseConnectionBeforeListener arg0, com.ibm.db.DatabaseConnectionBeforeListener arg1) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.util.EventListener
    * @roseuid 3E003F520033
    */
   protected java.util.EventListener remove(java.util.EventListener arg0) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return java.util.EventListener
    * @roseuid 3E003F5200F1
    */
   protected static java.util.EventListener removeInternal(java.util.EventListener arg0, java.util.EventListener arg1) 
   {
    return null;
   }
}
