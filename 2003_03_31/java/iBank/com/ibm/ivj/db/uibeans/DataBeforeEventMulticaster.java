//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\ivj\\db\\uibeans\\DataBeforeEventMulticaster.java

package com.ibm.ivj.db.uibeans;

import java.awt.AWTEventMulticaster;
import com.ibm.db.DataEvent;
import java.util.EventListener;

class DataBeforeEventMulticaster extends java.awt.AWTEventMulticaster implements com.ibm.ivj.db.uibeans.DataBeforeListener 
{
   private static final String copyright;
   
   /**
    * @param arg0
    * @param arg1
    * @roseuid 3E004062007A
    */
   protected DataBeforeEventMulticaster(com.ibm.ivj.db.uibeans.DataBeforeListener arg0, com.ibm.ivj.db.uibeans.DataBeforeListener arg1) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E004062016A
    */
   public void aboutToAddNewRow(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00406201F7
    */
   public void aboutToClose(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E0040620279
    */
   public void aboutToCommit(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00406202FB
    */
   public void aboutToConnect(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E004062037D
    */
   public void aboutToDeleteRow(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E0040630017
    */
   public void aboutToDisconnect(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E004063009A
    */
   public void aboutToExecute(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E0040630126
    */
   public void aboutToRollback(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00406301A8
    */
   public void aboutToUpdateRow(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return com.ibm.ivj.db.uibeans.DataBeforeListener
    * @roseuid 3E0040630248
    */
   public static com.ibm.ivj.db.uibeans.DataBeforeListener add(com.ibm.ivj.db.uibeans.DataBeforeListener arg0, com.ibm.ivj.db.uibeans.DataBeforeListener arg1) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return java.util.EventListener
    * @roseuid 3E00406303CF
    */
   protected static java.util.EventListener addInternal(java.util.EventListener arg0, java.util.EventListener arg1) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return com.ibm.ivj.db.uibeans.DataBeforeListener
    * @roseuid 3E00406400FF
    */
   public static com.ibm.ivj.db.uibeans.DataBeforeListener remove(com.ibm.ivj.db.uibeans.DataBeforeListener arg0, com.ibm.ivj.db.uibeans.DataBeforeListener arg1) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.util.EventListener
    * @roseuid 3E0040640286
    */
   protected java.util.EventListener remove(java.util.EventListener arg0) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return java.util.EventListener
    * @roseuid 3E0040640344
    */
   protected static java.util.EventListener removeInternal(java.util.EventListener arg0, java.util.EventListener arg1) 
   {
    return null;
   }
}
