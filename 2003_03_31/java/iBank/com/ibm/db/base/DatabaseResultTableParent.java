//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\base\\DatabaseResultTableParent.java

package com.ibm.db.base;

import java.sql.ResultSet;
import java.util.Hashtable;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.sql.SQLWarning;

public abstract class DatabaseResultTableParent extends com.ibm.db.base.DatabaseStatement 
{
   protected int resultSetType;
   protected transient Hashtable dbSearchTypeInfo;
   private static final String copyright;
   protected com.ibm.db.base.DatabaseCompoundType rowStruct;
   protected java.sql.ResultSet resultSet;
   static java.lang.Class class$com$ibm$db$base$DatabaseObjectField;
   
   /**
    * @roseuid 3E00402E009D
    */
   public DatabaseResultTableParent() 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @roseuid 3E00402D0381
    */
   public DatabaseResultTableParent(com.ibm.db.base.DatabaseConnection arg0, com.ibm.db.base.DatabaseQuerySpec arg1) 
   {
    
   }
   
   /**
    * @param arg0
    * @return boolean
    * @throws java.sql.SQLException
    * @roseuid 3E00402E00A7
    */
   public boolean absoluteRow(int arg0) throws java.sql.SQLException 
   {
    return true;
   }
   
   /**
    * @param arg0
    * @roseuid 3E00402E0101
    */
   public abstract void addQuerySpec(com.ibm.db.base.DatabaseQuerySpec arg0);
   
   /**
    * @throws java.sql.SQLException
    * @roseuid 3E00402E018E
    */
   public abstract void cancel() throws java.sql.SQLException;
   
   /**
    * @param arg0
    * @param arg1
    * @throws java.sql.SQLException
    * @roseuid 3E00402E01DE
    */
   private void checkSearchLevel(java.lang.String arg0, com.ibm.db.base.DatabaseTypeField arg1) throws java.sql.SQLException 
   {
    
   }
   
   /**
    * @throws java.sql.SQLException
    * @roseuid 3E00402E02D8
    */
   public void clearWarnings() throws java.sql.SQLException 
   {
    
   }
   
   /**
    * @throws java.sql.SQLException
    * @roseuid 3E00402E0328
    */
   public synchronized void close() throws java.sql.SQLException 
   {
    
   }
   
   /**
    * @throws java.sql.SQLException
    * @roseuid 3E00402E0382
    */
   public abstract void closeStatement() throws java.sql.SQLException;
   
   /**
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E00402E03DD
    */
   protected void describe() throws java.sql.SQLException, com.ibm.db.base.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @param arg2
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E00402F0121
    */
   protected void describeCol(int arg0, com.ibm.db.base.DatabaseCompoundType arg1, java.sql.ResultSetMetaData arg2) throws java.sql.SQLException, com.ibm.db.base.DataException 
   {
    
   }
   
   /**
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E00402F0320
    */
   public abstract void execute() throws java.sql.SQLException, com.ibm.db.base.DataException;
   
   /**
    * @param arg0
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E0040300064
    */
   public abstract void execute(com.ibm.db.base.DatabaseRow arg0) throws java.sql.SQLException, com.ibm.db.base.DataException;
   
   /**
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E0040300213
    */
   protected void fillInColumnShape() throws java.sql.SQLException, com.ibm.db.base.DataException 
   {
    
   }
   
   /**
    * @return java.lang.String
    * @throws java.sql.SQLException
    * @roseuid 3E004030035D
    */
   public abstract String getCursorName() throws java.sql.SQLException;
   
   /**
    * @return java.sql.ResultSetMetaData
    * @throws java.sql.SQLException
    * @roseuid 3E0040310001
    */
   public java.sql.ResultSetMetaData getMetaData() throws java.sql.SQLException 
   {
    return null;
   }
   
   /**
    * @return java.sql.ResultSet
    * @roseuid 3E00403100C0
    */
   protected java.sql.ResultSet getResultSet() 
   {
    return null;
   }
   
   /**
    * @return com.ibm.db.base.DatabaseRow
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E004031012E
    */
   public com.ibm.db.base.DatabaseRow getRow() throws java.sql.SQLException, com.ibm.db.base.DataException 
   {
    return null;
   }
   
   /**
    * @return int
    * @throws java.sql.SQLException
    * @roseuid 3E00403102D2
    */
   public int getRowNumber() throws java.sql.SQLException 
   {
    return 0;
   }
   
   /**
    * @return com.ibm.db.base.DatabaseCompoundType
    * @roseuid 3E0040310341
    */
   public com.ibm.db.base.DatabaseCompoundType getRowStruct() 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3E00403103C3
    */
   public int getType() 
   {
    return 0;
   }
   
   /**
    * @return java.sql.SQLWarning
    * @throws java.sql.SQLException
    * @roseuid 3E0040320003
    */
   public abstract java.sql.SQLWarning getWarnings() throws java.sql.SQLException;
   
   /**
    * @return boolean
    * @roseuid 3E00403200A3
    */
   public abstract boolean isReadOnlyResultSet();
   
   /**
    * @return boolean
    * @throws java.sql.SQLException
    * @roseuid 3E00403200AD
    */
   public boolean lastRow() throws java.sql.SQLException 
   {
    return true;
   }
   
   /**
    * @return com.ibm.db.base.DatabaseRow
    * @roseuid 3E004032011B
    */
   protected com.ibm.db.base.DatabaseRow newEmptyRow() 
   {
    return null;
   }
   
   /**
    * @return boolean
    * @throws java.sql.SQLException
    * @roseuid 3E0040320193
    */
   public boolean nextRow() throws java.sql.SQLException 
   {
    return true;
   }
   
   /**
    * @return boolean
    * @throws java.sql.SQLException
    * @roseuid 3E00403201F8
    */
   public boolean previousRow() throws java.sql.SQLException 
   {
    return true;
   }
   
   /**
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E0040320248
    */
   public abstract void refresh() throws java.sql.SQLException, com.ibm.db.base.DataException;
   
   /**
    * @param arg0
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E00403203B0
    */
   public abstract void refresh(com.ibm.db.base.DatabaseRow arg0) throws java.sql.SQLException, com.ibm.db.base.DataException;
   
   /**
    * @param arg0
    * @return boolean
    * @throws java.sql.SQLException
    * @roseuid 3E0040330181
    */
   public boolean relativeRow(int arg0) throws java.sql.SQLException 
   {
    return true;
   }
   
   /**
    * @param arg0
    * @roseuid 3E00403301DB
    */
   protected void setQuerySpec(com.ibm.db.base.DatabaseQuerySpec arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E0040330267
    */
   protected void setResultSet(java.sql.ResultSet arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00403302CB
    */
   protected void setRowStruct(com.ibm.db.base.DatabaseCompoundType arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @throws java.sql.SQLException
    * @roseuid 3E004033034D
    */
   public abstract void setTimeout(int arg0) throws java.sql.SQLException;
}
