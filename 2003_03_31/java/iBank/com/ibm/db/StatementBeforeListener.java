//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\StatementBeforeListener.java

package com.ibm.db;

import java.util.EventListener;

public interface StatementBeforeListener extends EventListener 
{
   
   /**
    * @param arg0
    * @roseuid 3E003FAF023F
    */
   public abstract void aboutToClose(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E003FAF02C1
    */
   public abstract void aboutToExecute(com.ibm.db.DataEvent arg0);
}
