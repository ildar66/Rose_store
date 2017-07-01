//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\StatementResultBeforeEventMulticaster.java

package com.ibm.db;

import java.awt.AWTEventMulticaster;
import java.util.EventListener;

class StatementResultBeforeEventMulticaster extends java.awt.AWTEventMulticaster implements com.ibm.db.StatementResultBeforeListener 
{
   private static final String copyright;
   
   /**
    * @param arg0
    * @param arg1
    * @roseuid 3E003FCB036C
    */
   protected StatementResultBeforeEventMulticaster(com.ibm.db.StatementResultBeforeListener arg0, com.ibm.db.StatementResultBeforeListener arg1) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FCC007E
    */
   public void aboutToAddNewRow(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FCC00F7
    */
   public void aboutToClose(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FCC0179
    */
   public void aboutToDeleteRow(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FCC01FB
    */
   public void aboutToUpdateRow(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return com.ibm.db.StatementResultBeforeListener
    * @roseuid 3E003FCC02A5
    */
   public static com.ibm.db.StatementResultBeforeListener add(com.ibm.db.StatementResultBeforeListener arg0, com.ibm.db.StatementResultBeforeListener arg1) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return java.util.EventListener
    * @roseuid 3E003FCD0044
    */
   protected static java.util.EventListener addInternal(java.util.EventListener arg0, java.util.EventListener arg1) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return com.ibm.db.StatementResultBeforeListener
    * @roseuid 3E003FCD0148
    */
   public static com.ibm.db.StatementResultBeforeListener remove(com.ibm.db.StatementResultBeforeListener arg0, com.ibm.db.StatementResultBeforeListener arg1) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.util.EventListener
    * @roseuid 3E003FCD02D9
    */
   protected java.util.EventListener remove(java.util.EventListener arg0) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return java.util.EventListener
    * @roseuid 3E003FCD038D
    */
   protected static java.util.EventListener removeInternal(java.util.EventListener arg0, java.util.EventListener arg1) 
   {
    return null;
   }
}
