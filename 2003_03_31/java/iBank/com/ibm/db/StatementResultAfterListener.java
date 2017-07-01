//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\StatementResultAfterListener.java

package com.ibm.db;

import java.util.EventListener;

public interface StatementResultAfterListener extends EventListener 
{
   
   /**
    * @param arg0
    * @roseuid 3E003FC8029F
    */
   public abstract void addedNewRow(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E003FC80322
    */
   public abstract void cacheRowsChanged(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E003FC803A4
    */
   public abstract void closed(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E003FC9003E
    */
   public abstract void deletedRow(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E003FC900C0
    */
   public abstract void updatedRow(com.ibm.db.DataEvent arg0);
}
