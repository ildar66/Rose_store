//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\base\\DatabaseConnection.java

package com.ibm.db.base;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.sql.SQLException;

public class DatabaseConnection 
{
   private boolean externallyManaged;
   private transient Hashtable dbSearchTypeInfo;
   protected transient Object websphereConnection;
   private static final String copyright;
   private com.ibm.db.base.DatabaseConnectionSpec connSpec;
   private java.sql.Connection jdbcConnection;
   private com.ibm.db.base.JDBCConnectionManager databaseManager;
   protected transient java.sql.DatabaseMetaData conMetaData;
   transient java.lang.Class websphereJdbcConnPoolAccess;
   protected transient java.lang.reflect.Method getIBMJdbcConn;
   protected transient java.lang.reflect.Method getJdbcConn;
   protected transient java.lang.reflect.Method releaseIBMConn;
   static java.lang.Class class$javax$sql$DataSource;
   static java.lang.Class class$java$sql$SQLException;
   static java.lang.Class class$java$lang$String;
   static java.lang.Class class$javax$naming$NoInitialContextException;
   
   /**
    * @param arg0
    * @roseuid 3E003FFE01DF
    */
   public DatabaseConnection(com.ibm.db.base.JDBCConnectionManager arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @throws java.sql.SQLException
    * @roseuid 3E003FFE013F
    */
   public DatabaseConnection(java.sql.Connection arg0) throws java.sql.SQLException 
   {
    
   }
   
   /**
    * @throws java.sql.SQLException
    * @roseuid 3E003FFE026B
    */
   public void commitTransaction() throws java.sql.SQLException 
   {
    
   }
   
   /**
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E003FFE02BB
    */
   public void connectToDataSource() throws java.sql.SQLException, com.ibm.db.base.DataException 
   {
    
   }
   
   /**
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @throws java.lang.NullPointerException
    * @roseuid 3E003FFF000A
    */
   public void disconnect() throws java.sql.SQLException, com.ibm.db.base.DataException, java.lang.NullPointerException 
   {
    
   }
   
   /**
    * @return java.lang.String
    * @roseuid 3E003FFF019A
    */
   public String getAlias() 
   {
    return null;
   }
   
   /**
    * @return boolean
    * @throws java.sql.SQLException
    * @roseuid 3E003FFF01C2
    */
   public boolean getAutoCommit() throws java.sql.SQLException 
   {
    return true;
   }
   
   /**
    * @return java.sql.DatabaseMetaData
    * @throws java.sql.SQLException
    * @roseuid 3E003FFF0230
    */
   public java.sql.DatabaseMetaData getConnectionMetaData() throws java.sql.SQLException 
   {
    return null;
   }
   
   /**
    * @return com.ibm.db.base.DatabaseConnectionSpec
    * @roseuid 3E003FFF02E5
    */
   public com.ibm.db.base.DatabaseConnectionSpec getConnectionSpec() 
   {
    return null;
   }
   
   /**
    * @return java.lang.String
    * @roseuid 3E003FFF038F
    */
   private String getConnectionUrl() 
   {
    return null;
   }
   
   /**
    * @return com.ibm.db.base.JDBCConnectionManager
    * @roseuid 3E003FFF03D5
    */
   protected com.ibm.db.base.JDBCConnectionManager getDatabaseManager() 
   {
    return null;
   }
   
   /**
    * @return java.sql.Connection
    * @roseuid 3E0040000083
    */
   public java.sql.Connection getJdbcConnection() 
   {
    return null;
   }
   
   /**
    * @return java.util.Hashtable
    * @throws java.sql.SQLException
    * @roseuid 3E00400000FB
    */
   protected Hashtable getSearchTypeInfo() throws java.sql.SQLException 
   {
    return null;
   }
   
   /**
    * @return int
    * @throws java.sql.SQLException
    * @roseuid 3E0040000169
    */
   public int getTransactionIsolation() throws java.sql.SQLException 
   {
    return 0;
   }
   
   /**
    * @return boolean
    * @throws java.sql.SQLException
    * @roseuid 3E00400001BA
    */
   public boolean isConnected() throws java.sql.SQLException 
   {
    return true;
   }
   
   /**
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E0040000214
    */
   protected void obtainWebsphereConnection() throws com.ibm.db.base.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E00400002FA
    */
   protected void releaseWebsphereConnection() throws com.ibm.db.base.DataException 
   {
    
   }
   
   /**
    * @throws java.sql.SQLException
    * @roseuid 3E0040010002
    */
   public void rollbackTransaction() throws java.sql.SQLException 
   {
    
   }
   
   /**
    * @param arg0
    * @throws java.sql.SQLException
    * @roseuid 3E0040010053
    */
   public void setAutoCommit(boolean arg0) throws java.sql.SQLException 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00400100B7
    */
   public void setConnectionSpec(com.ibm.db.base.DatabaseConnectionSpec arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E0040010143
    */
   protected void setDatabaseManager(com.ibm.db.base.JDBCConnectionManager arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00400101CF
    */
   protected void setJdbcConnection(java.sql.Connection arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @throws java.sql.SQLException
    * @roseuid 3E0040010229
    */
   public void setTransactionIsolation(int arg0) throws java.sql.SQLException 
   {
    
   }
}
