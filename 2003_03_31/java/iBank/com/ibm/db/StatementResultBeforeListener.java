//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\StatementResultBeforeListener.java

package com.ibm.db;

import java.util.EventListener;

public interface StatementResultBeforeListener extends EventListener 
{
   
   /**
    * @param arg0
    * @roseuid 3E003FCE026C
    */
   public abstract void aboutToAddNewRow(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E003FCE02EE
    */
   public abstract void aboutToClose(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E003FCE0370
    */
   public abstract void aboutToDeleteRow(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E003FCF0015
    */
   public abstract void aboutToUpdateRow(com.ibm.db.DataEvent arg0);
}
