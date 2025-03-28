//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\SelectStatement.java

package com.ibm.db;

import java.io.ObjectInputStream;
import java.io.IOException;

public class SelectStatement extends com.ibm.db.Statement implements com.ibm.db.DatabaseConnectionBeforeListener 
{
   protected boolean fieldLockRows;
   protected int fieldMaximumPacketsInCache;
   protected int fieldMaximumRows;
   protected int fieldPacketSize;
   protected boolean fieldFillCacheOnExecute;
   protected boolean fieldForceSearchedUpdate;
   protected boolean forVAJavaSelect;
   protected boolean largeResultSetScrollingEnabled;
   protected transient boolean executing;
   protected transient boolean firstFirstRow;
   private static final long serialVersionUID = -408125570;
   private static final String copyright;
   protected com.ibm.db.SelectResult fieldResult;
   
   /**
    * @roseuid 3E003F8D0178
    */
   public SelectStatement() 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F8D0164
    */
   public SelectStatement(boolean arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F8D0182
    */
   public void aboutToCommit(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F8D0204
    */
   public void aboutToConnect(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F8D0287
    */
   public void aboutToDisconnect(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F8D0309
    */
   public void aboutToRollback(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @return boolean
    * @roseuid 3E003F8D038B
    */
   public boolean areDistinctTypesEnabled() 
   {
    return true;
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F8D0395
    */
   public void cancelExecution() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F8E006B
    */
   protected void checkConnection() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F8E0129
    */
   public void close() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F8E01DE
    */
   protected void closeInternal(boolean arg0) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F8E029D
    */
   public void committed(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F8E031E
    */
   public void connected(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F8E03A0
    */
   protected void createResultTable() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @roseuid 3E003F8F0077
    */
   protected void disconnect() 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F8F0081
    */
   public void disconnected(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F8F0103
    */
   public synchronized void execute() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws java.lang.Throwable
    * @roseuid 3E003F8F01C1
    */
   protected void finalize() throws java.lang.Throwable 
   {
      super.finalize();    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F8F021B
    */
   protected void fireAboutToClose(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F8F029D
    */
   protected void fireClosed(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @return int
    * @roseuid 3E003F8F0320
    */
   public int getMaximumPacketsInCache() 
   {
    return 0;
   }
   
   /**
    * @return int
    * @roseuid 3E003F8F032A
    */
   public int getMaximumRows() 
   {
    return 0;
   }
   
   /**
    * @return int
    * @roseuid 3E003F8F0334
    */
   public int getPacketSize() 
   {
    return 0;
   }
   
   /**
    * @return com.ibm.db.SelectResult
    * @roseuid 3E003F8F035C
    */
   public com.ibm.db.SelectResult getResult() 
   {
    return null;
   }
   
   /**
    * @roseuid 3E003F8F03DE
    */
   protected void initialize() 
   {
    
   }
   
   /**
    * @return boolean
    * @roseuid 3E003F900000
    */
   public boolean isFillCacheOnExecute() 
   {
    return true;
   }
   
   /**
    * @return boolean
    * @roseuid 3E003F90000A
    */
   public boolean isForceSearchedUpdate() 
   {
    return true;
   }
   
   /**
    * @return boolean
    * @roseuid 3E003F900014
    */
   protected boolean isForVAJavaSelect() 
   {
    return true;
   }
   
   /**
    * @return boolean
    * @roseuid 3E003F900028
    */
   public boolean isLargeResultSetScrollingEnabled() 
   {
    return true;
   }
   
   /**
    * @return boolean
    * @roseuid 3E003F900032
    */
   public boolean isLockRows() 
   {
    return true;
   }
   
   /**
    * @return boolean
    * @roseuid 3E003F90003C
    */
   public boolean isOpen() 
   {
    return true;
   }
   
   /**
    * @param arg0
    * @throws java.io.IOException
    * @throws java.lang.ClassNotFoundException
    * @roseuid 3E003F900046
    */
   private void readObject(java.io.ObjectInputStream arg0) throws java.io.IOException, java.lang.ClassNotFoundException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F900136
    */
   public synchronized void refresh() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F9001EB
    */
   protected void refreshResultTable() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F9002A9
    */
   public void rolledBack(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F90032B
    */
   public void setConnection(com.ibm.db.DatabaseConnection arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F9003AD
    */
   public void setDistinctTypesEnabled(boolean arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F9003C1
    */
   public void setFillCacheOnExecute(boolean arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F9003CC
    */
   public void setForceSearchedUpdate(boolean arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F9003DF
    */
   public void setLargeResultSetScrollingEnabled(boolean arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F91000B
    */
   public void setLockRows(boolean arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F910016
    */
   public void setMaximumPacketsInCache(int arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F910029
    */
   public void setMaximumRows(int arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F91003D
    */
   public synchronized void setMetaData(com.ibm.db.StatementMetaData arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F9100C0
    */
   public void setPacketSize(int arg0) 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F9100CB
    */
   protected void validateSQL() throws com.ibm.db.DataException 
   {
    
   }
}
