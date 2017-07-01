//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\StatementAfterListener.java

package com.ibm.db;

import java.util.EventListener;

public interface StatementAfterListener extends EventListener 
{
   
   /**
    * @param arg0
    * @roseuid 3E003FAB0135
    */
   public abstract void closed(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E003FAB01C1
    */
   public abstract void executed(com.ibm.db.DataEvent arg0);
}
