//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\ivj\\db\\uibeans\\DataAfterEventMulticaster.java

package com.ibm.ivj.db.uibeans;

import java.awt.AWTEventMulticaster;
import com.ibm.db.DataEvent;
import java.util.EventListener;

class DataAfterEventMulticaster extends java.awt.AWTEventMulticaster implements com.ibm.ivj.db.uibeans.DataAfterListener 
{
   private static final String copyright;
   
   /**
    * @param arg0
    * @param arg1
    * @roseuid 3E00405A02F9
    */
   protected DataAfterEventMulticaster(com.ibm.ivj.db.uibeans.DataAfterListener arg0, com.ibm.ivj.db.uibeans.DataAfterListener arg1) 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return com.ibm.ivj.db.uibeans.DataAfterListener
    * @roseuid 3E00405B002A
    */
   public static com.ibm.ivj.db.uibeans.DataAfterListener add(com.ibm.ivj.db.uibeans.DataAfterListener arg0, com.ibm.ivj.db.uibeans.DataAfterListener arg1) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @roseuid 3E00405B01A6
    */
   public void addedNewRow(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return java.util.EventListener
    * @roseuid 3E00405B0247
    */
   protected static java.util.EventListener addInternal(java.util.EventListener arg0, java.util.EventListener arg1) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @roseuid 3E00405B032D
    */
   public void cacheRowsChanged(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00405B03AF
    */
   public void closed(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00405C0049
    */
   public void committed(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00405C00D6
    */
   public void connected(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00405C0158
    */
   public void deletedRow(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00405C01DA
    */
   public void disconnected(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00405C025C
    */
   public void executed(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return com.ibm.ivj.db.uibeans.DataAfterListener
    * @roseuid 3E00405C02FC
    */
   public static com.ibm.ivj.db.uibeans.DataAfterListener remove(com.ibm.ivj.db.uibeans.DataAfterListener arg0, com.ibm.ivj.db.uibeans.DataAfterListener arg1) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.util.EventListener
    * @roseuid 3E00405D00A5
    */
   protected java.util.EventListener remove(java.util.EventListener arg0) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return java.util.EventListener
    * @roseuid 3E00405D016D
    */
   protected static java.util.EventListener removeInternal(java.util.EventListener arg0, java.util.EventListener arg1) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @roseuid 3E00405D0254
    */
   public void rolledBack(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00405D02D6
    */
   public void updatedRow(com.ibm.db.DataEvent arg0) 
   {
    
   }
}
