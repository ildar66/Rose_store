//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\ivj\\db\\uibeans\\Statement.java

package com.ibm.ivj.db.uibeans;

import com.ibm.db.DatabaseConnection;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import com.ibm.db.DataEvent;
import java.beans.PropertyChangeListener;
import com.ibm.db.DataException;
import com.ibm.db.StatementMetaData;
import java.beans.PropertyChangeEvent;

public abstract class Statement implements java.io.Serializable 
{
   static final long serialVersionUID = -631310561;
   private static final String copyright;
   com.ibm.db.DatabaseConnection fieldDatabaseConnection;
   protected transient com.ibm.ivj.db.uibeans.DataAfterListener aDataAfterListener;
   protected transient com.ibm.ivj.db.uibeans.DataBeforeListener aDataBeforeListener;
   protected transient java.beans.PropertyChangeSupport propertyChange;
   
   /**
    * @roseuid 3E00408F007F
    */
   public Statement() 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00408F0089
    */
   public void aboutToClose(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00408F0115
    */
   public void aboutToCommit(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00408F01A1
    */
   public void aboutToConnect(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00408F0223
    */
   public void aboutToDisconnect(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00408F02B0
    */
   public void aboutToExecute(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00408F0332
    */
   public void aboutToRollback(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00408F03BE
    */
   public void addDataAfterListener(com.ibm.ivj.db.uibeans.DataAfterListener arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E0040900030
    */
   public void addDataBeforeListener(com.ibm.ivj.db.uibeans.DataBeforeListener arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E004090008A
    */
   public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00409000E4
    */
   public void cacheResultsChanged(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E0040900171
    */
   public abstract void cancelAction() throws com.ibm.db.DataException;
   
   /**
    * @param arg0
    * @roseuid 3E004090022F
    */
   public void closed(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00409002BB
    */
   public void committed(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E004090033D
    */
   public void connected(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00409003C9
    */
   public void disconnected(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E004091006E
    */
   public abstract void execute() throws com.ibm.db.DataException;
   
   /**
    * @param arg0
    * @roseuid 3E004091014A
    */
   public void executed(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E0040910335
    */
   protected void fireAboutToClose(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00409103C1
    */
   protected void fireAboutToCommit(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E004092005B
    */
   protected void fireAboutToConnect(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00409200E7
    */
   protected void fireAboutToDisconnect(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E004092017D
    */
   protected void fireAboutToExecute(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E004092020A
    */
   protected void fireAboutToRollback(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E0040920282
    */
   protected void fireClosed(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E0040920318
    */
   protected void fireCommitted(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00409203A4
    */
   protected void fireConnected(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E0040930048
    */
   protected void fireDisconnected(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00409300D5
    */
   protected void fireExecuted(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @param arg2
    * @roseuid 3E0040930161
    */
   protected void firePropertyChange(java.lang.String arg0, java.lang.Object arg1, java.lang.Object arg2) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00409301E3
    */
   protected void fireRolledBack(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @return com.ibm.db.DatabaseConnection
    * @roseuid 3E0040930297
    */
   public com.ibm.db.DatabaseConnection getDatabaseConnection() 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.lang.Object
    * @throws com.ibm.db.DataException
    * @roseuid 3E0040930338
    */
   public abstract Object getParameter(int arg0) throws com.ibm.db.DataException;
   
   /**
    * @param arg0
    * @return java.lang.Object
    * @throws com.ibm.db.DataException
    * @roseuid 3E0040940054
    */
   public abstract Object getParameter(java.lang.String arg0) throws com.ibm.db.DataException;
   
   /**
    * @param arg0
    * @return java.lang.String
    * @throws com.ibm.db.DataException
    * @roseuid 3E004094016C
    */
   public abstract String getParameterToString(int arg0) throws com.ibm.db.DataException;
   
   /**
    * @param arg0
    * @return java.lang.String
    * @throws com.ibm.db.DataException
    * @roseuid 3E004094027B
    */
   public abstract String getParameterToString(java.lang.String arg0) throws com.ibm.db.DataException;
   
   /**
    * @return com.ibm.db.StatementMetaData
    * @roseuid 3E0040940393
    */
   public abstract com.ibm.db.StatementMetaData getStatementMetaData();
   
   /**
    * @return int
    * @roseuid 3E004095002D
    */
   public abstract int getTimeout();
   
   /**
    * @return boolean
    * @throws com.ibm.db.DataException
    * @roseuid 3E0040950041
    */
   public boolean isConnected() throws com.ibm.db.DataException 
   {
    return true;
   }
   
   /**
    * @param arg0
    * @roseuid 3E00409500F6
    */
   public void removeDataAfterListener(com.ibm.ivj.db.uibeans.DataAfterListener arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E004095015A
    */
   public void removeDataBeforeListener(com.ibm.ivj.db.uibeans.DataBeforeListener arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00409501B4
    */
   public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E004095020E
    */
   public void rolledBack(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E004095029A
    */
   public void setDatabaseConnection(com.ibm.db.DatabaseConnection arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @throws com.ibm.db.DataException
    * @roseuid 3E0040950326
    */
   public abstract void setParameter(int arg0, java.lang.Object arg1) throws com.ibm.db.DataException;
   
   /**
    * @param arg0
    * @param arg1
    * @throws com.ibm.db.DataException
    * @roseuid 3E004096002F
    */
   public abstract void setParameter(java.lang.String arg0, java.lang.Object arg1) throws com.ibm.db.DataException;
   
   /**
    * @param arg0
    * @param arg1
    * @throws com.ibm.db.DataException
    * @roseuid 3E004096013D
    */
   public abstract void setParameterFromString(int arg0, java.lang.String arg1) throws com.ibm.db.DataException;
   
   /**
    * @param arg0
    * @param arg1
    * @throws com.ibm.db.DataException
    * @roseuid 3E004096022D
    */
   public abstract void setParameterFromString(java.lang.String arg0, java.lang.String arg1) throws com.ibm.db.DataException;
   
   /**
    * @param arg0
    * @roseuid 3E0040960332
    */
   public abstract void setStatementMetaData(com.ibm.db.StatementMetaData arg0);
   
   /**
    * @param arg0
    * @roseuid 3E00409603BE
    */
   public abstract void setTimeout(int arg0);
   
   /**
    * @param arg0
    * @roseuid 3E00409603D3
    */
   public abstract void propertyChange(java.beans.PropertyChangeEvent arg0);
}
