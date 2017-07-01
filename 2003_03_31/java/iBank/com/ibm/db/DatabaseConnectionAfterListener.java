//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\DatabaseConnectionAfterListener.java

package com.ibm.db;

import java.util.EventListener;

public interface DatabaseConnectionAfterListener extends EventListener 
{
   
   /**
    * @param arg0
    * @roseuid 3E003F4D01C6
    */
   public abstract void committed(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E003F4D0248
    */
   public abstract void connected(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E003F4D02CB
    */
   public abstract void disconnected(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E003F4D034D
    */
   public abstract void rolledBack(com.ibm.db.DataEvent arg0);
}
