//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\StatementResult.java

package com.ibm.db;

import com.ibm.db.base.DatabaseResultTableParent;
import java.io.Serializable;
import java.util.Enumeration;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import com.ibm.db.base.DatabaseResultTable;

public abstract class StatementResult implements java.io.Serializable 
{
   protected int fieldNumRows;
   static final long serialVersionUID = 2145701847;
   private static final String copyright;
   protected transient com.ibm.db.base.DatabaseResultTableParent rt;
   protected transient com.ibm.db.StatementResultBeforeListener aStatementResultBeforeListener;
   protected transient com.ibm.db.StatementResultAfterListener aStatementResultAfterListener;
   
   /**
    * @roseuid 3E003FBD01C7
    */
   public StatementResult() 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FBD01D1
    */
   public void addStatementResultAfterListener(com.ibm.db.StatementResultAfterListener arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FBD025D
    */
   public void addStatementResultBeforeListener(com.ibm.db.StatementResultBeforeListener arg0) 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FBD02E0
    */
   public abstract void closeResult() throws com.ibm.db.DataException;
   
   /**
    * @return java.util.Enumeration
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FBD03B2
    */
   public abstract java.util.Enumeration columnNames() throws com.ibm.db.DataException;
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FBE00CE
    */
   public abstract void deleteRow() throws com.ibm.db.DataException;
   
   /**
    * @throws java.lang.Throwable
    * @roseuid 3E003FBE018D
    */
   protected void finalize() throws java.lang.Throwable 
   {
      super.finalize();    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FBE01DD
    */
   protected void fireAboutToAddNewRow(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FBE0269
    */
   protected void fireAboutToClose(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FBE02F5
    */
   protected void fireAboutToDeleteRow(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FBE0377
    */
   protected void fireAboutToUpdateRow(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FBF001C
    */
   protected void fireAddedNewRow(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FBF009E
    */
   protected void fireClosed(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FBF012A
    */
   protected void fireDeletedRow(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FBF01AC
    */
   protected void fireUpdatedRow(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @return int
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FBF0238
    */
   public abstract int getColumnCount() throws com.ibm.db.DataException;
   
   /**
    * @param arg0
    * @return java.lang.String
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FBF030B
    */
   public abstract String getColumnName(int arg0) throws com.ibm.db.DataException;
   
   /**
    * @param arg0
    * @return java.lang.Object
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FC0001D
    */
   public abstract Object getColumnValue(int arg0) throws com.ibm.db.DataException;
   
   /**
    * @param arg0
    * @return java.lang.Object
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FC00117
    */
   public abstract Object getColumnValue(java.lang.String arg0) throws com.ibm.db.DataException;
   
   /**
    * @param arg0
    * @return java.lang.String
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FC00230
    */
   public abstract String getColumnValueToString(int arg0) throws com.ibm.db.DataException;
   
   /**
    * @param arg0
    * @return java.lang.String
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FC0032A
    */
   public abstract String getColumnValueToString(java.lang.String arg0) throws com.ibm.db.DataException;
   
   /**
    * @return java.sql.ResultSetMetaData
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FC1005A
    */
   public java.sql.ResultSetMetaData getJDBCMetaData() throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3E003FC10155
    */
   public int getNumRows() 
   {
    return 0;
   }
   
   /**
    * @return com.ibm.db.base.DatabaseResultTableParent
    * @roseuid 3E003FC10187
    */
   protected com.ibm.db.base.DatabaseResultTableParent getResultTable() 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FC10209
    */
   protected static void handleSQLException(java.sql.SQLException arg0) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FC10317
    */
   protected abstract void initialize() throws com.ibm.db.DataException;
   
   /**
    * @return boolean
    * @roseuid 3E003FC103D6
    */
   public boolean isOpen() 
   {
    return true;
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FC103E0
    */
   public void removeStatementResultAfterListener(com.ibm.db.StatementResultAfterListener arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FC2007A
    */
   public void removeStatementResultBeforeListener(com.ibm.db.StatementResultBeforeListener arg0) 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FC200FC
    */
   public abstract void restoreRow() throws com.ibm.db.DataException;
   
   /**
    * @param arg0
    * @param arg1
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FC201BA
    */
   public abstract void setColumnValue(int arg0, java.lang.Object arg1) throws com.ibm.db.DataException;
   
   /**
    * @param arg0
    * @param arg1
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FC202A1
    */
   public abstract void setColumnValue(java.lang.String arg0, java.lang.Object arg1) throws com.ibm.db.DataException;
   
   /**
    * @param arg0
    * @param arg1
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FC203A5
    */
   public abstract void setColumnValueFromString(int arg0, java.lang.String arg1) throws com.ibm.db.DataException;
   
   /**
    * @param arg0
    * @param arg1
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FC30099
    */
   public abstract void setColumnValueFromString(java.lang.String arg0, java.lang.String arg1) throws com.ibm.db.DataException;
   
   /**
    * @param arg0
    * @roseuid 3E003FC3019E
    */
   protected void setResultTable(com.ibm.db.base.DatabaseResultTable arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FC3022A
    */
   protected void setResultTable(com.ibm.db.base.DatabaseResultTableParent arg0) 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FC302B6
    */
   public abstract void updateRow() throws com.ibm.db.DataException;
}
