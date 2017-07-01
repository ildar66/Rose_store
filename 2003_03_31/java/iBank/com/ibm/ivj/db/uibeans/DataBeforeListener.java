//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\ivj\\db\\uibeans\\DataBeforeListener.java

package com.ibm.ivj.db.uibeans;

import java.util.EventListener;
import com.ibm.db.DataEvent;

public interface DataBeforeListener extends EventListener 
{
   
   /**
    * @param arg0
    * @roseuid 3E004065033B
    */
   public abstract void aboutToAddNewRow(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E00406503BE
    */
   public abstract void aboutToClose(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E0040660058
    */
   public abstract void aboutToCommit(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E00406600E4
    */
   public abstract void aboutToConnect(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E0040660166
    */
   public abstract void aboutToDeleteRow(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E00406601E8
    */
   public abstract void aboutToDisconnect(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E004066026B
    */
   public abstract void aboutToExecute(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E00406602ED
    */
   public abstract void aboutToRollback(com.ibm.db.DataEvent arg0);
   
   /**
    * @param arg0
    * @roseuid 3E004066036F
    */
   public abstract void aboutToUpdateRow(com.ibm.db.DataEvent arg0);
}
