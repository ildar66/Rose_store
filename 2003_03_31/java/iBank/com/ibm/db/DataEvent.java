//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\DataEvent.java

package com.ibm.db;

import java.util.EventObject;

public class DataEvent extends java.util.EventObject 
{
   protected int triggeringAction;
   public static final int ACTION_DELETE_ROW = 1;
   public static final int ACTION_DELETE_ROW_AND_REFILL = 2;
   public static final int ACTION_NEW_ROW = 3;
   public static final int ACTION_NEXT_PACKET = 4;
   public static final int ACTION_NOT_APPLICABLE = 0;
   private static final String copyright;
   
   /**
    * @param arg0
    * @roseuid 3E003F530374
    */
   public DataEvent(java.lang.Object arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @roseuid 3E003F53034B
    */
   public DataEvent(java.lang.Object arg0, int arg1) 
   {
    
   }
   
   /**
    * @return int
    * @roseuid 3E003F5303A6
    */
   public int getTriggeringAction() 
   {
    return 0;
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F5303B0
    */
   public void setTriggeringAction(int arg0) 
   {
    
   }
}
