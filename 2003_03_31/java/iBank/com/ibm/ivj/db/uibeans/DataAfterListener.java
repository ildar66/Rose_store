//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\ivj\\db\\uibeans\\DataAfterListener.java

package com.ibm.ivj.db.uibeans;

import java.util.EventListener;
import com.ibm.db.DataEvent;

public interface DataAfterListener extends EventListener 
{
   
   /**
    * @param arg0
    * @roseuid 3E00405E029B
    */
   public abstract void addedNewRow(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E00405E031D
    */
   public abstract void cacheRowsChanged(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E00405E039F
    */
   public abstract void closed(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E00405F003A
    */
   public abstract void committed(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E00405F00C6
    */
   public abstract void connected(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E00405F0148
    */
   public abstract void deletedRow(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E00405F01CA
    */
   public abstract void disconnected(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E00405F024C
    */
   public abstract void executed(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E00405F02CF
    */
   public abstract void rolledBack(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E00405F0351
    */
   public abstract void updatedRow(com.ibm.db.DataEvent arg0);
}
